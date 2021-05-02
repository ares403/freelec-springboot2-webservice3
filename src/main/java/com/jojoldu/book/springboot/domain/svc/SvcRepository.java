package com.jojoldu.book.springboot.domain.svc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SvcRepository extends JpaRepository<Svc, Long>  {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Svc> findAllDesc();

}
