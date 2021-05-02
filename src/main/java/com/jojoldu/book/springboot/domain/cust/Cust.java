package com.jojoldu.book.springboot.domain.cust;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Cust extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
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

}
