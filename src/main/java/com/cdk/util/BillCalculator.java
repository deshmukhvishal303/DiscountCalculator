package com.cdk.util;

import com.cdk.entity.discount.DiscountSlab;

import java.util.Set;

public class BillCalculator {

    public Integer calculateBillAmount(Integer purchaseAmount, Set<DiscountSlab> discountSlab) {
        Integer discountAmount = 0;

        Integer amount = purchaseAmount;
        for (DiscountSlab ds : discountSlab) {
            if(purchaseAmount.compareTo(ds.getLowerRange()) < 0){
                break;
            }

            Integer discountApplicableAmount = ds.getUpperRange() - ds.getLowerRange();
            if(amount.compareTo(discountApplicableAmount) < 0)
                discountApplicableAmount = amount;

            discountAmount += (discountApplicableAmount * ds.getDiscountPercentage() / 100);
            amount -= discountApplicableAmount;
        }

        return purchaseAmount - discountAmount;
    }
}
