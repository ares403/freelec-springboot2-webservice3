package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.svc.Svc;
import lombok.Getter;

@Getter
public class SvcResponseDto {

    private Long id;
    private Long svc_mgmt_num;
    private String fee_prod_id;
    private String cust_num;

    public SvcResponseDto(Svc entity) {
        this.id = entity.getId();
        this.svc_mgmt_num = entity.getSvc_mgmt_num();
        this.fee_prod_id = entity.getFee_prod_id();
        this.cust_num = entity.getCust_num();
    }
}
