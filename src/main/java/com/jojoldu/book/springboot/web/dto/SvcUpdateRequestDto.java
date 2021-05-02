package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SvcUpdateRequestDto {
    private String cust_num;
    private String fee_prod_id;

    @Builder
    public SvcUpdateRequestDto(String cust_num, String fee_prod_id) {
        this.cust_num = cust_num;
        this.fee_prod_id = fee_prod_id;
    }
}
