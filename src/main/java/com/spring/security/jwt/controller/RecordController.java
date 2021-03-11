package com.spring.security.jwt.controller;

import com.spring.security.jwt.entity.RecordEntity;
import com.spring.security.jwt.entity.dto.mapper.RecordMapper;
import com.spring.security.jwt.entity.dto.request.RecordRequest;
import com.spring.security.jwt.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
@AllArgsConstructor
public class RecordController {
    private final RecordService recordService;
    private final RecordMapper recordMapper;

    @PostMapping
    public void add(@RequestBody RecordRequest recordRequest) {
        recordService.add(recordMapper.fromDto(recordRequest));
    }

    @PostMapping("/{id}")
    public void add(@PathVariable Long id, @RequestBody RecordRequest recordRequest) {
        RecordEntity record = recordMapper.fromDto(recordRequest);
        record.setId(id);
        recordService.update(record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recordService.delete(recordService.getById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordEntity> get(@PathVariable Long id) {
        return new ResponseEntity<>(recordService.getById(id), HttpStatus.OK);
    }
}
