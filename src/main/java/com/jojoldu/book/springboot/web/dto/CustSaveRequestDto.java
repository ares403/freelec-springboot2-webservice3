package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.cust.Cust;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustSaveRequestDto {
    private String cust_num;
    private String sex_cd;
    private String acnt_num;

    @Builder
    public CustSaveRequestDto(String cust_num, String sex_cd, String acnt_num) {
        this.cust_num = cust_num;
        this.sex_cd = sex_cd;
        this.acnt_num = acnt_num;
    }

    public Cust toEntity() {
        return Cust.builder()
                .cust_num(cust_num)
                .sex_cd(sex_cd)
                .acnt_num(acnt_num)
                .build();
    }

}
