package com.hakan.demo.service;

import com.hakan.demo.dto.request.UrunSaveRequestDto;
import com.hakan.demo.dto.response.UrunFindAllResponseDto;
import com.hakan.demo.mapper.IUrunMapper;
import com.hakan.demo.repository.IUrunRepository;
import com.hakan.demo.repository.entity.Urun;
import com.hakan.demo.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrunService extends ServiceManager<Urun,Long> {
    private final IUrunRepository repository;

    public UrunService(IUrunRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Urun> findByAd(String ad) {
        return repository.findByAd(ad);
    }

    public List<Urun> findByMarkaAndModel(String marka,String model){
        return repository.findByMarkaAndModel(marka,model);
    }

    public Urun save(UrunSaveRequestDto dto){
        return save(IUrunMapper.INSTANCE.urunSaveRequestDtoToUrun(dto));
    }

    public List<UrunFindAllResponseDto> findAllResponseDto(){
        List<UrunFindAllResponseDto> liste=new ArrayList<>();
        findAll().forEach(urun->{
            liste.add(IUrunMapper.INSTANCE.urunToDto(urun));
        });
        return liste;
    }

}
