package com.jojoldu.book.springboot.domain.cust;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import com.jojoldu.book.springboot.domain.svc.Svc;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Getter
@NoArgsConstructor
@Entity
public class Cust extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, name = "CUST_NUM")
    private String cust_num;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String sex_cd;
    private String acnt_num;

    @Builder
    public Cust(String cust_num, String sex_cd, String acnt_num) {
        this.cust_num = cust_num;
        this.sex_cd = sex_cd;
        this.acnt_num = acnt_num;
    }

    public void update(String sex_cd, String acnt_num) {
        this.sex_cd = sex_cd;
        this.acnt_num = acnt_num;
    }

    @OneToMany(mappedBy = "cust")
    private Collection<Svc> svc;
}
