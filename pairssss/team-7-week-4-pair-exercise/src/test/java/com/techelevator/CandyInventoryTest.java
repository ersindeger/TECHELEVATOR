package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyInventoryTest {

private CandyInventory candy;

@Before
    public void setup() {

    candy = new CandyInventory();
}

@Test
    public void test_negative_inventory() {

    Assert.assertFalse(candy.hasEnoughQty("H3", 101));
    Assert.assertFalse(candy.hasEnoughQty("S4", -101));
}

@Test
    public void test_does_not_contain_product_id() {
    Assert.assertFalse(candy.containsProductId("hello world"));
    Assert.assertFalse(candy.containsProductId(null));

}


}
