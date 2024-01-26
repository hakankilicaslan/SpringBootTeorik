package com.hakan.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Kaydederken kullanıcıdan alınacak minimum bilgileri içeren dto
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MusteriSaveRequestDto {

    String username;
    String password;
    String ad;

}
