package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.CustService;
import com.jojoldu.book.springboot.web.dto.CustListResponseDto;
import com.jojoldu.book.springboot.web.dto.CustResponseDto;
import com.jojoldu.book.springboot.web.dto.CustSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.CustUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustApiController {

    private final CustService custService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody CustSaveRequestDto requestDto) {
        return custService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody CustUpdateRequestDto requestDto) {
        return custService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        custService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public CustResponseDto findById(@PathVariable Long id) {
        return custService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<CustListResponseDto> findAll() {
        return custService.findAllDesc();
    }
}
