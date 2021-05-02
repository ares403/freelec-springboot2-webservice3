package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.cust.Cust;
import lombok.Getter;

@Getter
public class CustResponseDto {

    private Long id;
    private String cust_num;
    private String sex_cd;
    private String acnt_num;

    public CustResponseDto(Cust entity) {
        this.id = entity.getId();
        this.cust_num = entity.getCust_num();
        this.sex_cd = entity.getSex_cd();
        this.acnt_num = entity.getAcnt_num();
    }
}
