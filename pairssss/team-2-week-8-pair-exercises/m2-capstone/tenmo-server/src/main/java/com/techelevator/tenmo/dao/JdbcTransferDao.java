package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exceptions.TransferNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getBalance(String username) {

        if (username == null)
            {throw new IllegalArgumentException("USERNAME cannot be null");}

        BigDecimal result;
        try {
            String sql = "SELECT balance FROM account JOIN tenmo_user on account.user_id = tenmo_user.user_id " +
                    "WHERE username = ?;";

            result = jdbcTemplate.queryForObject(sql, BigDecimal.class, username);
        }
        catch (NullPointerException | EmptyResultDataAccessException e)
            {throw  new UsernameNotFoundException("User " + username + " was not found.");}

        return result;
    }

    public Transfer createTransfer(int userIdFrom, int userIdTo, BigDecimal amount){
      Transfer transfer = new Transfer();

        String sql1 = "SELECT account_id FROM account WHERE user_id = ?; ";  //gives us accountFROM

        Integer accountFrom = jdbcTemplate.queryForObject(sql1, Integer.class, userIdFrom );

        String sql2 = "SELECT account_id FROM account WHERE user_id = ?; ";  //gives us accountTO

        Integer accountTo = jdbcTemplate.queryForObject(sql2, Integer.class, userIdTo );


         String sql = "INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount)" +
                 " VALUES(?, ?, ?, ?, ?) RETURNING transfer_id; ";

         Integer transferId = jdbcTemplate.queryForObject(sql, Integer.class, 2, 2,
                 accountFrom, accountTo, amount);

         String sql3 = "UPDATE account SET balance  = balance - ? WHERE user_id = ? RETURNING balance;"; // subtracts AMOUNT from ACCOUNT_FROM

        jdbcTemplate.queryForObject(sql3, Integer.class, amount, userIdFrom);

        String sql4 = "UPDATE account SET balance  = balance + ? WHERE user_id = ? RETURNING balance;"; // adds AMOUNT to ACCOUNT_TO

       jdbcTemplate.queryForObject(sql4, Integer.class, amount, userIdTo);


       return transfer;

    }

    public List<Transfer> retrieveListOfAllTransfers (int currentUserId){
        List<Transfer> transferHistory = new ArrayList<>();

        String sql1 ="SELECT transfer.transfer_id, userFrom.user_id AS user_id_from, userFrom.username AS user_from," +
                " userTo.user_id AS user_id_to, userTo.username AS user_to, transfer.amount" +
                " FROM transfer" +
                " JOIN account AS acctFrom ON transfer.account_from = acctFrom.account_id" +
                " JOIN tenmo_user AS userFrom ON acctFrom.user_id = userFrom.user_id" +
                " JOIN account AS acctTo ON transfer.account_to = acctTo.account_id" +
                " JOIN tenmo_user AS userTo ON acctTo.user_id = userTo.user_id" +
                " WHERE userFrom.user_id = ? OR userTo.user_id = ?; ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql1, currentUserId, currentUserId);

        while(result.next()){
            Transfer transfer = mapRowToUser(result);
            transferHistory.add(transfer);
        }

        return transferHistory;
    }

    public Transfer retrieveTransferByTransferId (int transferId ) throws TransferNotFoundException {
        Transfer transfer = null;

        String sql2 = "SELECT transfer.transfer_id, userFrom.username AS user_from," +
                " userTo.username AS user_to, transfer.amount, transfer.transfer_type_id, transfer.transfer_status_id" +
                " FROM transfer" +
                " JOIN account AS acctFrom ON transfer.account_from = acctFrom.account_id" +
                " JOIN tenmo_user AS userFrom ON acctFrom.user_id = userFrom.user_id" +
                " JOIN account AS acctTo ON transfer.account_to = acctTo.account_id" +
                " JOIN tenmo_user AS userTo ON acctTo.user_id = userTo.user_id " +
                " WHERE transfer.transfer_id = ? ; ";

        SqlRowSet result2 = jdbcTemplate.queryForRowSet(sql2, transferId );

        if(result2.next()){
            transfer = mapRowToTransfer(result2);
        }

        if(transfer == null){
            throw new TransferNotFoundException();
        }

        return transfer;
    }


    private Transfer mapRowToUser(SqlRowSet rs) {
        Transfer transfer = new Transfer();

        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setUserIdFrom(rs.getInt("user_id_from"));
        transfer.setUserIdTo(rs.getInt("user_id_to"));
        transfer.setAmount(rs.getBigDecimal("amount"));
        transfer.setUserFrom(rs.getString("user_from"));
        transfer.setUserTo(rs.getString("user_to"));
//        transfer.setTransferType(rs.getInt("transfer_type_id"));
//        transfer.setTransferStatus(rs.getInt("transfer_status_id"));

        return transfer;
    }
    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();

        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setAmount(rs.getBigDecimal("amount"));
        transfer.setUserFrom(rs.getString("user_from"));
        transfer.setUserTo(rs.getString("user_to"));
        transfer.setTransferType(rs.getInt("transfer_type_id"));
        transfer.setTransferStatus(rs.getInt("transfer_status_id"));

        return transfer;
    }


}
