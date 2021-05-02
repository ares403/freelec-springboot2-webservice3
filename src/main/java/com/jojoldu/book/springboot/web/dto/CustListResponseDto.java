package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.cust.Cust;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CustListResponseDto {
    private Long id;
    private String sex_cd;
    private String anct_num;
    private LocalDateTime modifiedDate;

    public CustListResponseDto(Cust entity) {
        this.id = entity.getId();
        this.sex_cd = entity.getSex_cd();
        this.anct_num = entity.getAcnt_num();
        this.modifiedDate = entity.getModifiedDate();
    }
}
