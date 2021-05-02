package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustUpdateRequestDto {
    private String sex_cd;
    private String acnt_num;

    @Builder
    public CustUpdateRequestDto(String sex_cd, String acnt_num) {
        this.sex_cd = sex_cd;
        this.acnt_num = acnt_num;
    }
}
