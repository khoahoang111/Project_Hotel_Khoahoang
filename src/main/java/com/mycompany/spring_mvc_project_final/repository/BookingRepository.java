/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
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
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

//     @Query("select p from ProductEntity p where p.category.name like %?1% and p.price >=?2")
//     List<ProductEntity> findProductByCategory(String category, double price);
//    select r.price,r.numberOfBed,rt.name from booking b
//join booking_detail bd on bd.booking_id = b.id
//join room r on r.id = bd.rooom_id
//join room_type rt on rt.id = r.roomtype_id
// where 
//b.checkin_date >= '2021-05-05' AND b.checkout_date <= '2021-05-09' and r.roomtype_id = 2;
   
    @Query(value = "select * from booking b "
            + "join booking_detail bd on bd.booking_id = b.id "
            + "join room r on r.id = bd.rooom_id "
            + "join room_type rt on rt.id = r.roomtype_id "
            + "where "
            + "b.checkin_date >= :check_in AND b.checkout_date <= :check_out and r.roomtype_id = :room_type ", nativeQuery = true)
    List<BookingEntity> finBookingEntitys(
            @Param("check_in") Date check_in,
            @Param("check_out") Date check_out,
            @Param("room_type") int room_type);
    
//       @Query(value = "select * from booking b\n" +
//"join booking_detail bd on bd.booking_id = b.id\n" +
//"join room r on r.id = bd.rooom_id\n" +
//"join room_type rt on rt.id = r.roomtype_id\n" +
//" where \n" +
//" r.roomtype_id = ?1;", nativeQuery = true)
//    List<BookingEntity> finBookingEntitys1(int room_type);
    
    
    
    
//        @Query("select r from RoomEntity r order by r.id desc")
//    List<RoomEntity> getRoomDetails(int roomType);

}
