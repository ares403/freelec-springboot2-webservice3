package com.jojoldu.book.springboot.domain.svc;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import com.jojoldu.book.springboot.domain.cust.Cust;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Svc extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private Long svc_mgmt_num;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String fee_prod_id;
    private String cust_num;

    @Builder
    public Svc(Long svc_mgmt_num, String fee_prod_id, String cust_num) {
        this.svc_mgmt_num = svc_mgmt_num;
        this.fee_prod_id = fee_prod_id;
        this.cust_num = cust_num;
    }

    public void update(String fee_prod_id, String cust_num) {
        this.fee_prod_id = fee_prod_id;
        this.cust_num = cust_num;
    }

    @ManyToOne
    @JoinColumn(name="CUST_NUM")
    private Cust cust;
}
