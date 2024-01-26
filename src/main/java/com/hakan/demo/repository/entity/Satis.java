package com.hakan.demo.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tblsatis")
public class Satis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long urunid;
    Long tarih;
    Integer adet;
    Double birimfiyat;
    Double toplamfiyat;
}

/*
    1-Kime ne satıldı? findAll
    2-x müşterisine ne satıldı? findAllByMusteriid(Long musteriid)
    3-En çok alışveriş yapan müşteri? select musteriid from tblsatis group by musteriid order by count(musteriid) desc limit 1
    4-En çok satılan 3 ürün id sini getirelim.
 */
