/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khoa hoang
 */
@Repository
public interface PromotionRepository extends CrudRepository<PromotionEntity, Integer> {

    @Query(value = "select * from promotion pr\n" +
"join promotion_roomtype prr on prr.promotion_id = pr.id\n" +
"join room_type rt on rt.id = prr.roomtype_id where rt.id = :room_type and pr.end_date >= :end_date ", nativeQuery = true)
    List<PromotionEntity> getpromotion(
            @Param("room_type") int room_type,
            @Param("end_date") LocalDate end_date);

}
