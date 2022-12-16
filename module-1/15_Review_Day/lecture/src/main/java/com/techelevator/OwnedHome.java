package com.techelevator;

public class OwnedHome extends Home {


    private int monthlyMortgage;
    private boolean isHoa;

//    public OwnedHome (int squareFeet, String mlsId, int numberOfBedrooms, boolean hasBasement,
//     Address address) {
//        super(squareFeet, mlsId, numberOfBedrooms, hasBasement, address);
//    }


    public int getMonthlyMortgage() {
        return monthlyMortgage;
    }

    public void setMonthlyMortgage(int monthlyMortgage) {
        this.monthlyMortgage = monthlyMortgage;
    }

    public boolean isHoa() {
        return isHoa;
    }

    public void setHoa(boolean hoa) {
        isHoa = hoa;
    }
    


}
