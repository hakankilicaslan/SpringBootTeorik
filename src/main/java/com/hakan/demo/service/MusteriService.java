package com.hakan.demo.service;

import com.hakan.demo.dto.request.MusteriSaveRequestDto;
import com.hakan.demo.dto.response.MusteriFindAllResponseDto;
import com.hakan.demo.mapper.IMusteriMapper;
import com.hakan.demo.repository.IMusteriRepository;
import com.hakan.demo.repository.entity.Musteri;
import com.hakan.demo.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
//@RequiredArgsConstructor //Gerekli argümanlarla constructor oluşturmamıza yarıyor aşağıdaki constructor ı arka planda oluşturuyor.
public class MusteriService extends ServiceManager<Musteri,Long> {

    private final IMusteriRepository repository;

    //private final DenemeComponent denemeComponent;

    public MusteriService(IMusteriRepository repository) {
        super(repository);
        this.repository = repository;}

    //ServiceManager dan implement ettiğimiz için save ve findAll metotları orda var artık MusteriService içine yazmamıza gerek kalmadı.
    //public Musteri save(Musteri musteri){return repository.save(musteri);}
    //public List<Musteri> findAll(){return repository.findAll();}

    //public void denemeComponentKullan(){denemeComponent.metod1();}

    public List<Musteri> findByAd(String ad) {
        return repository.findByAd(ad);
    }

    public void saveDto(MusteriSaveRequestDto dto){
//        Musteri m1 = Musteri.builder()
//                .username(dto.getUsername())
//                .password(dto.getPassword())
//                .ad(dto.getAd())
//                .build();

        Musteri m1 = IMusteriMapper.INSTANCE.musteriSaveRequestDtoToMusteri(dto);
        save(m1); //ServiceManager içindeki save() metodunu çağırmış olduk.
    }

    public List<MusteriFindAllResponseDto> findAllResponseDtos(){
        List<MusteriFindAllResponseDto> liste = new ArrayList<>();
        findAll().forEach(musteri->{
//            liste.add(MusteriFindAllResponseDto.builder()
//                    .ad(musteri.getAd())
//                    .username(musteri.getUsername())
//                    .img(musteri.getImg())
//                    .build());
              liste.add(IMusteriMapper.INSTANCE.musteriToFindAllResponseDto(musteri));
        });
        return liste;
    }
}
