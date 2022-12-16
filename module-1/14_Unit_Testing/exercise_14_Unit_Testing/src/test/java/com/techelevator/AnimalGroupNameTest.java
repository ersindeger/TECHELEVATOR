package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest extends AnimalGroupName {

    private AnimalGroupName animals;

    @Before
    public void setup(){
        System.out.println("before!");
        //arrange
        animals = new AnimalGroupName();
    }

    @Test
    public void test_getHerd () {
        System.out.println("testing started!");
        Assert.assertEquals("Herd", animals.getHerd("elephant"));
        Assert.assertEquals("Crash", animals.getHerd("RHIno"));
        Assert.assertEquals("unknown", animals.getHerd("cAT"));
        Assert.assertEquals("Kit", animals.getHerd("pIGEOn"));
        Assert.assertEquals("Pack", animals.getHerd("doG"));
        Assert.assertEquals("Herd", animals.getHerd("DEEr"));


    }

}
