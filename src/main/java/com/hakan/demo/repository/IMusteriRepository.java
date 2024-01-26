package com.hakan.demo.repository;


import com.hakan.demo.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {
    /**
     * find -> kelmesi ile başlamamız gerekli
     * by -> işlem yapılacak bileşen adından önce yazılması gerekli
     * [ad] -> kullanılan repository içindeki entity içindeki arama yapılmak istenen fieldin
     * ilk karakteri büyük harfle olacak şekilde yazılmalıdır.
     * Spring bizim yerimize metodun gövdesini dolduruyor.
     * findBy: Tekil kayıt dönecekse kullanılır.
     * findAll: Çoğul kayıt dönecekse kullanılır.
     */
    List<Musteri> findByAd(String ad); //select * from tblmusteri where ad=?
    Musteri findByAdres(String musteriAdresi); //select * from tblmusteri where adres=?

    Musteri findByAdOrAdres(String ad, String adres); //select * from tblmusteri where ad=? or adres=?

    Musteri findByAdAndAdresAndTelefon(String ad,String adres,String telefon);

    List<Musteri> findAllByIl(String il); //İldeki tüm müşteri listesini getirir.

    Optional<Musteri> findOptionalByAdAndTelefon(String ad,String tel); //Optional

    List<Musteri> findAllByOrderByAd(); //Sıralamalar Order By tersine sıralama istersek metot sonuna Desc ekeyebiliriz.

    List<Musteri> findTop3ByOrderByAd(); //limit -> top

    //son x günde kaydedilenleri getir. -> select * from tblmusteri where kayittarihi=?
    /*
        GreaterThan -> Büyüktür
        LessThan -> Küçüktür
        GreaterThanEqual -> Büyük Eşittir
        LessThanEqual -> Küçük Eşittir
     */
    List<Musteri> findAllByKayittarihiGreaterThan(Long kayitzamani); //GreaterThan -> büyüktür

    //Like -> select * from tblmusteri where ad LIKE '%a'
    //ifade '%a%' içinde a olanları getirir.
    // '%a' a ile bitenleri getirir.
    // 'a%' a ile başlayanları getirir.
    // % işaretini biz eklemeliyiz.

    List<Musteri> findAllByAdLike(String ifade);

    List<Musteri> findAllByAdStartingWith(String ifade); //'a%' bunun karşılığı metot bu oluyor.
    List<Musteri> findAllByAdEndingWithIgnoreCase(String ifade); //'%a' bunun karşılığı metot bu oluyor.
    List<Musteri> findAllByAdContainsIgnoreCase(String ifade); //'%a%' bunun karşılığı metot bu oluyor.

    //Null ve Not Null
    List<Musteri> findAllByTelefonIsNull(); //Telefon kayfı olmayanları getir demiş oluyoruz.

}
