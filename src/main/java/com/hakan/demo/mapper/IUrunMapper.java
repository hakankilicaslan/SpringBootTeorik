package com.hakan.demo.mapper;

import com.hakan.demo.dto.request.UrunSaveRequestDto;
import com.hakan.demo.dto.response.UrunFindAllResponseDto;
import com.hakan.demo.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUrunMapper {

    IUrunMapper INSTANCE = Mappers.getMapper(IUrunMapper.class);
    Urun urunSaveRequestDtoToUrun(UrunSaveRequestDto dto);
    UrunFindAllResponseDto urunToDto(Urun urun);

}
