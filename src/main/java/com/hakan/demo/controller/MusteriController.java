package com.hakan.demo.controller;

import com.hakan.demo.dto.request.MusteriSaveRequestDto;
import com.hakan.demo.dto.response.MusteriFindAllResponseDto;
import com.hakan.demo.exception.DemoException;
import com.hakan.demo.exception.ErrorType;
import com.hakan.demo.repository.entity.Musteri;
import com.hakan.demo.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hakan.demo.constant.EndPoints.*; //static olarak import ettiğimiz için başlarına Endpoints yazmamıza gerek kalmıyor ama bunu yapmak için bütün fieldların static olması gerekiyor.
import java.util.List;

@RestController
@RequestMapping(ROOT+MUSTERI)
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriService service;

//    @GetMapping("/save")
//    public ResponseEntity<Musteri> save(String ad,String adres){
//        return ResponseEntity.ok(service.save(Musteri.builder().ad(ad).adres(adres).build()));
//    }

//    @PostMapping("/save")
//    public ResponseEntity<Musteri> save(String ad,String adres){
//        return ResponseEntity.ok(service.save(Musteri.builder().ad(ad).adres(adres).build()));
//        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Musteri());
//    }

    @PostMapping(SAVE)
    public ResponseEntity<String> save(MusteriSaveRequestDto dto){
        service.saveDto(dto);
        return ResponseEntity.ok("Kayıt Başarılı");
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Musteri());
    }

//    @GetMapping(FINDALL)
//    public ResponseEntity<List<Musteri>> findAll(){
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("baslik", "deger");
//            //return ResponseEntity.ok(service.findAll());
//            return new ResponseEntity<>(service.findAll(),headers, HttpStatus.OK);
//            //throw new RuntimeException("deneme exception");
//        }
//        catch (RuntimeException ex){
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @GetMapping(GETALL)
    public ResponseEntity<List<MusteriFindAllResponseDto>> getAll(){
        return ResponseEntity.ok(service.findAllResponseDtos());
    }

    @GetMapping(FINDBYAD)
    public ResponseEntity<List<Musteri>> findByAd(String ad) throws Exception {
        if(ad==null){
            throw new DemoException(ErrorType.PARAMETRE_EKSIK);
        }

        return ResponseEntity.ok(service.findByAd(ad));
    }


    @RequestMapping(value = "/deneme",method = RequestMethod.GET,produces = "application/json")
    public String deneme(){
        return "DENEME";
    }

}
