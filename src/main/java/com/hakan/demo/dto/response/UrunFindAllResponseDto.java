package com.hakan.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UrunFindAllResponseDto {
    String ad;
    String marka;
    Double fiyat;
}
