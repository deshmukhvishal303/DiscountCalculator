package com.cdk.entity;

import com.cdk.entity.discount.DiscountSlab;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class PremiumCustomerTest {

    private Customer premiumCustomer = new PremiumCustomer();

    @Before
    public void setUpRegularCustomer(){
        Set<DiscountSlab> discountSlabs = new TreeSet<>();
        discountSlabs.add(new DiscountSlab(0, 4000, 10));
        discountSlabs.add(new DiscountSlab(4000,8000, 15));
        discountSlabs.add(new DiscountSlab(8000,12000, 20));
        discountSlabs.add(new DiscountSlab(12000,99999999, 30));
        premiumCustomer.setDiscountSlab(discountSlabs);
    }

    @Test
    public void testWithPurchaseEligibleFor10PercentDiscount(){
        premiumCustomer.setPurchaseAmount(4000);
        Integer billAmount = premiumCustomer.calculateBillAmount();
        Assert.assertEquals("Customer Should have 10% discount",
                new Integer(3600), billAmount);
    }

    @Test
    public void testWithPurchaseEligibleFor15PercentDiscount(){
        premiumCustomer.setPurchaseAmount(8000);
        Integer billAmount = premiumCustomer.calculateBillAmount();
        Assert.assertEquals("Customer did'nt got any discount",
                new Integer(7000), billAmount);
    }

    @Test
    public void testWithPurchaseEligibleFor20PercentDiscount(){
        premiumCustomer.setPurchaseAmount(12000);
        Integer billAmount = premiumCustomer.calculateBillAmount();
        Assert.assertEquals("Customer did'nt got any discount",
                new Integer(10200), billAmount);
    }

    @Test
    public void testWithPurchaseEligibleFor30PercentDiscount(){
        premiumCustomer.setPurchaseAmount(20000);
        Integer billAmount = premiumCustomer.calculateBillAmount();
        Assert.assertEquals("Customer did'nt got any discount",
                new Integer(15800), billAmount);
    }
}
