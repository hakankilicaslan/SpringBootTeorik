package com.hakan.demo.controller;

import com.hakan.demo.dto.request.UrunSaveRequestDto;
import com.hakan.demo.dto.response.UrunFindAllResponseDto;
import com.hakan.demo.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.hakan.demo.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT+URUN)
@RequiredArgsConstructor
public class UrunController {

    private final UrunService service;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(UrunSaveRequestDto dto){
        service.save(dto);
        return ResponseEntity.ok("Kayıt başarılı");
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<UrunFindAllResponseDto>> getall(){
        return  ResponseEntity.ok(service.findAllResponseDto());
    }

    @GetMapping("/hatafirlat")
    public String hatafirlat(){
        throw new RuntimeException("Hata oluştu");
    }

}
