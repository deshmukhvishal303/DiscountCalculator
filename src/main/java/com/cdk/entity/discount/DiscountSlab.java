package com.cdk.entity.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class DiscountSlab implements Comparable<DiscountSlab>{
    @NonNull
    private Integer lowerRange;

    @NonNull
    private Integer upperRange;

    @NonNull
    private Integer discountPercentage;

    public int compareTo(DiscountSlab o) {
        return lowerRange.compareTo(o.lowerRange);
    }
}
