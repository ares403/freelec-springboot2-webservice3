package com.jojoldu.book.springboot.domain.cust;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CustRepository extends JpaRepository<Cust, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Cust> findAllDesc();
}
