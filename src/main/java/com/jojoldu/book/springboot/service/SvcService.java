package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.domain.svc.Svc;
import com.jojoldu.book.springboot.domain.svc.SvcRepository;
import com.jojoldu.book.springboot.web.dto.SvcListResponseDto;
import com.jojoldu.book.springboot.web.dto.SvcResponseDto;
import com.jojoldu.book.springboot.web.dto.SvcSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.SvcUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SvcService {
    private final SvcRepository svcRepository;

    @Transactional
    public Long save(SvcSaveRequestDto requestDto) {
        return svcRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, SvcUpdateRequestDto requestDto) {
        Svc svc = svcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        svc.update(requestDto.getCust_num(), requestDto.getFee_prod_id());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Svc svc = svcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        svcRepository.delete(svc);
    }

    @Transactional(readOnly = true)
    public SvcResponseDto findById(Long id) {
        Svc entity = svcRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new SvcResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<SvcListResponseDto> findAllDesc() {
        return svcRepository.findAllDesc().stream()
                .map(SvcListResponseDto::new)
                .collect(Collectors.toList());
    }
}
