package com.hakan.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UrunSaveRequestDto {

    String ad;
    String marka;
    String model;
    Double fiyat;

}
