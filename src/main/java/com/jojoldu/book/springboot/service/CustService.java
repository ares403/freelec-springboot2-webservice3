package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.cust.Cust;
import com.jojoldu.book.springboot.domain.cust.CustRepository;
import com.jojoldu.book.springboot.web.dto.CustListResponseDto;
import com.jojoldu.book.springboot.web.dto.CustResponseDto;
import com.jojoldu.book.springboot.web.dto.CustSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.CustUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustService {

    private final CustRepository custRepository;

    @Transactional
    public Long save(CustSaveRequestDto requestDto) {
        return custRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CustUpdateRequestDto requestDto) {
        Cust cust = custRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        cust.update(requestDto.getSex_cd(), requestDto.getAcnt_num());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Cust cust = custRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        custRepository.delete(cust);
    }

    @Transactional(readOnly = true)
    public CustResponseDto findById(Long id) {
        Cust entity = custRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new CustResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CustListResponseDto> findAllDesc() {
        return custRepository.findAllDesc().stream()
                .map(CustListResponseDto::new)
                .collect(Collectors.toList());
    }
}
