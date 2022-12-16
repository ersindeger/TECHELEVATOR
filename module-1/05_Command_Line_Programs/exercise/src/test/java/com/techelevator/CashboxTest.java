package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CashboxTest {

    private Cashbox cashbox;

    @Before
    public void setup() {

        cashbox = new Cashbox();
    }

    @Test
    public void test_return_30_cents() {

        cashbox.addToBalance(37);
        cashbox.subtractFromBalance(.7);

        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(1);
        testList.add(1);
        testList.add(1);
        testList.add(1);
        testList.add(0);
        testList.add(1);

        Assert.assertArrayEquals(testList.toArray(), cashbox.giveChange().toArray());
    }

    @Test
    public void test_return_45_cents() {

        cashbox.addToBalance(37);
        cashbox.subtractFromBalance(.55);

        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(1);
        testList.add(1);
        testList.add(1);
        testList.add(1);
        testList.add(2);
        testList.add(0);

        Assert.assertArrayEquals(testList.toArray(), cashbox.giveChange().toArray());
    }

}
