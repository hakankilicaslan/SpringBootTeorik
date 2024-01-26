package com.hakan.demo.repository;

import com.hakan.demo.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUrunRepository extends JpaRepository<Urun,Long> {

    List<Urun> findByAd(String ad);
    List<Urun> findByMarkaAndModel(String marka,String model);
}
