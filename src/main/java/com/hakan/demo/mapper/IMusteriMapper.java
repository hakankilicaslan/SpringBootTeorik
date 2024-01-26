package com.hakan.demo.mapper;

import com.hakan.demo.dto.request.MusteriSaveRequestDto;
import com.hakan.demo.dto.response.MusteriFindAllResponseDto;
import com.hakan.demo.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMusteriMapper {

    IMusteriMapper INSTANCE = Mappers.getMapper(IMusteriMapper.class);

    MusteriFindAllResponseDto musteriToFindAllResponseDto(Musteri musteri);

    Musteri musteriSaveRequestDtoToMusteri(MusteriSaveRequestDto dto);

}
