package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.SvcService;
import com.jojoldu.book.springboot.web.dto.SvcListResponseDto;
import com.jojoldu.book.springboot.web.dto.SvcResponseDto;
import com.jojoldu.book.springboot.web.dto.SvcSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.SvcUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SvcApiController {

    private final SvcService svcService;

    @PostMapping("/api/v1/svc")
    public Long save(@RequestBody SvcSaveRequestDto requestDto) {
        return svcService.save(requestDto);
    }

    @PutMapping("/api/v1/svc/{id}")
    public Long update(@PathVariable Long id, @RequestBody SvcUpdateRequestDto requestDto) {
        return svcService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/svc/{id}")
    public Long delete(@PathVariable Long id) {
        svcService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/svc/{id}")
    public SvcResponseDto findById(@PathVariable Long id) {
        return svcService.findById(id);
    }

    @GetMapping("/api/v1/svc/list")
    public List<SvcListResponseDto> findAll() {
        return svcService.findAllDesc();
    }
}
