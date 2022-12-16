package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest{

    private CigarParty cigars = new CigarParty();


    @Before
    public void setup() {
        System.out.println("Before");
    }


    @Test
    public void createAndFillParty(){
        Assert.assertEquals(false, cigars.haveParty(39,false));
        Assert.assertEquals(false, cigars.haveParty(61,false));
        Assert.assertEquals(true, cigars.haveParty(55,false));

        Assert.assertEquals(true, cigars.haveParty(55,true));
        Assert.assertEquals(true, cigars.haveParty(84,true));
        Assert.assertEquals(false, cigars.haveParty(22,true));


    }

}
