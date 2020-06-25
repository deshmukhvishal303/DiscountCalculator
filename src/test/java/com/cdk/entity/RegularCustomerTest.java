package com.cdk.entity;

import com.cdk.entity.discount.DiscountSlab;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class RegularCustomerTest {

    private Customer regularCustomer = new RegularCustomer();

    @Before
    public void setUpRegularCustomer(){
        Set<DiscountSlab> discountSlabs = new TreeSet<>();
        discountSlabs.add(new DiscountSlab(0, 5000, 0));
        discountSlabs.add(new DiscountSlab(5000,10000, 10));
        discountSlabs.add(new DiscountSlab(10000,999999999, 20));
        regularCustomer.setDiscountSlab(discountSlabs);
    }

    @Test
    public void testWithPurchaseEligibleForNoDiscount(){
        regularCustomer.setPurchaseAmount(5000);
        Integer billAmount = regularCustomer.calculateBillAmount();
        Assert.assertEquals("Customer Should not have got any discount",
                new Integer(5000), billAmount);
    }

    @Test
    public void testWithPurchaseEligibleFor10PercentDiscount(){
        regularCustomer.setPurchaseAmount(8000);
        Integer billAmount = regularCustomer.calculateBillAmount();
        Assert.assertEquals("Customer did'nt got any discount",
                new Integer(7700), billAmount);
    }

    @Test
    public void testWithPurchaseEligibleFor20PercentDiscount(){
        regularCustomer.setPurchaseAmount(17000);
        Integer billAmount = regularCustomer.calculateBillAmount();
        Assert.assertEquals("Customer did'nt got any discount",
                new Integer(15100), billAmount);
    }
}
