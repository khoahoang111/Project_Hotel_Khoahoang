/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khoa hoang
 */
@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {

//     @Query("select p from ProductEntity p where p.category.name like %?1% and p.price >=?2")
//     List<ProductEntity> findProductByCategory(String category, double price);
    @Query("select r from RoomEntity r order by r.id desc")
    List<RoomEntity> getRoomDetails(Pageable pageable);

//     @Query("select r from RoomEntity r where r.roomType =?1")
//    List<RoomEntity> getRoomType(int roomType_id);
//    
//     @Query("select r from RoomEntity r order by r.id desc")
//    List<RoomEntity> getLastStudentDetails(Pageable pageable);
//    @Query("with x as ( SELECT  r,ROW_NUMBER() OVER(ORDER BY r.id ASC) AS sequence_number from RoomEntity r)\n" +
//" select x1 from x as x1 where x1.sequence_number between ?1 and ?2")
//    List<RoomEntity> countRoom(int page, int size);
    @Query("select count(*) from RoomEntity r")
    int countRoom();

    public List<RoomEntity> findAll(Pageable pageable);

//        @Query(value = "select * from booking b "
//            + "join booking_detail bd on bd.booking_id = b.id "
//            + "join room r on r.id = bd.rooom_id "
//            + "join room_type rt on rt.id = r.roomtype_id "
//            + "where "
//            + "b.checkin_date >= :check_in AND b.checkout_date <= :check_out and r.roomtype_id = :room_type ", nativeQuery = true)
//    List<RoomEntity> finBookingEntitys(
//            @Param("check_in") Date check_in,
//            @Param("check_out") Date check_out,
//            @Param("room_type") int room_type);
//    
    @Query(value = "select * from room r "
            //            + "join booking_detail bd on bd.booking_id = b.id "
            //            + "join room r on r.id = bd.rooom_id "
            + "join room_type rt on rt.id = r.roomtype_id "
            + "join booking_detail bd on  bd.rooom_id = r.id "
            + "join booking  b on b.id = bd.booking_id "
            + "where "
            + "b.checkin_date >= :check_in AND b.checkout_date <= :check_out and r.roomtype_id = :room_type ", nativeQuery = true)
    List<RoomEntity> finBookingEntitys(
            @Param("check_in") LocalDate check_in,
            @Param("check_out") LocalDate check_out,
            @Param("room_type") int room_type);

    @Query(value = "SELECT * FROM room r\n"
            + "join room_type rt on rt.id = r.roomtype_id\n"
//            + "join promotion_roomtype p on p.roomtype_id = rt.id\n"
//            + "join promotion pr on pr.id = p.promotion_id\n"
            + "where r.id not in\n"
            + "(select r.id from room  r \n"
            + "join room_type rt on rt.id = r.roomtype_id\n"
            + "join booking_detail bt on bt.rooom_id = r.id\n"
            + "join booking b on b.id = bt.booking_id\n"
            + "where b.checkin_date >= :check_in and b.checkout_date >= :check_out) and rt.id = :room_type", nativeQuery = true)
    List<RoomEntity> finBookingEntitys1(
            @Param("check_in") LocalDate check_in,
            @Param("check_out") LocalDate check_out,
            @Param("room_type") int room_type);

    @Query(value = "select * from room r "
            + "join room_type rt on rt.id = r.roomtype_id "
            + "where "
            + "r.roomtype_id = :room_type ", nativeQuery = true)
    List<RoomEntity> finBookingEntitys1(
            @Param("room_type") int room_type);
    
    
    
    @Query(value = "select * from room where id =:room_id ", nativeQuery = true)
    RoomEntity mybooking(
            @Param("room_id") int room_id);
    
}
