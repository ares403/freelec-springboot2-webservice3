package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.svc.Svc;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SvcListResponseDto {
    private Long id;
    private Long svc_mgmt_num;
    private String fee_prod_id;
    private LocalDateTime modifiedDate;

    public SvcListResponseDto(Svc entity) {
        this.id = entity.getId();
        this.svc_mgmt_num = entity.getSvc_mgmt_num();
        this.fee_prod_id = entity.getFee_prod_id();
        this.modifiedDate = entity.getModifiedDate();
    }
}
