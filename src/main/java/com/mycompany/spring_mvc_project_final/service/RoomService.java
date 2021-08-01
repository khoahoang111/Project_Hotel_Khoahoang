/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomTypeEntity;
import com.mycompany.spring_mvc_project_final.repository.RoomRepository;
import com.mycompany.spring_mvc_project_final.repository.RoomTypeRepository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author khoa hoang
 */
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public List<RoomEntity> getAllRooom() {
        Pageable pageable = PageRequest.of(0, 3);
        List<RoomEntity> listrooom = roomRepository.findAll(pageable);
        return listrooom;
    }

    public List<RoomEntity> getlimit(int page) {
        Pageable pageable = PageRequest.of(page, 3);
        List<RoomEntity> listroom = roomRepository.getRoomDetails(pageable);
        return listroom;
    }

//    public List<RoomEntity> getlimit1() {
//        return (List<RoomEntity>) roomRepository.getLastStudentDetails(PageRequest.of(2, 3));
    public int getcountRoom() {
        int total = roomRepository.countRoom();
        int totalPage = total / 3;
        if (total % 2 != 0) {
            totalPage++;
        }
        return totalPage;
    }

//    public List<RoomEntity> getCountpaging(){
//        return  roomRepository.countRoom(1, 3);
//    }
    public List<RoomEntity> getBookingEntity(LocalDate check_in, LocalDate check_out, int room_type) {

//        List<RoomTypeEntity> roomTypes = (List<RoomTypeEntity>) roomTypeRepository.findAll();
//        RoomTypeEntity roomType = roomTypes.get(room_type - 1);     
//        List<RoomEntity> roomsSearch = roomType.getRooms();
//        List<RoomEntity> roomsSearch = (List<RoomEntity>) roomRepository.finBookingEntitys1(room_type);
//
//        List<RoomEntity> roomsSearch1 = roomRepository.finBookingEntitys(check_in, check_out, room_type);
//        if (roomsSearch1.size() > 0) {
//            for (RoomEntity roomEntity : roomsSearch) {
//                for (RoomEntity roomEntity1 : roomsSearch1) {
//                    if (roomEntity.getId() == roomEntity1.getId()) {
//                       roomsSearch.remove(roomEntity1);
//                        break;
//                    }
//                }
//            }
//        } else {
//            return roomsSearch;
//        }

        return roomRepository.finBookingEntitys1(check_in, check_in, room_type);

    }
    
    public RoomEntity getmybooking(int room_id){
        Optional<RoomEntity> room = roomRepository.findById(room_id);
        if(room.isPresent()){
            return room.get();
        }
        return  new RoomEntity();
    }
}
