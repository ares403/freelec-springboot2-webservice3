package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.svc.Svc;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SvcSaveRequestDto {
    private Long svc_mgmt_num;
    private String fee_prod_id;
    private String cust_num;

    @Builder
    public SvcSaveRequestDto(Long svc_mgmt_num, String fee_prod_id, String cust_num) {
        this.svc_mgmt_num = svc_mgmt_num;
        this.fee_prod_id = fee_prod_id;
        this.cust_num = cust_num;
    }

    public Svc toEntity() {
        return Svc.builder()
                .svc_mgmt_num(svc_mgmt_num)
                .fee_prod_id(fee_prod_id)
                .cust_num(cust_num)
                .build();
    }

}
