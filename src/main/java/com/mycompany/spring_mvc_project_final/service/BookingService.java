/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.repository.BookingRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author khoa hoang
 */
@Service
public class BookingService {
    
    
    @Autowired
    private BookingRepository bookingRepository;
    
    
    public  List<BookingEntity> getBookingEntity(Date check_in, Date check_out, int room_type){
        return bookingRepository.finBookingEntitys(check_in, check_out, room_type);
    }
            
    
    public List<BookingEntity> getRoomSearch(){
        return (List<BookingEntity>) bookingRepository.findAll();
    }
    
    
//    public List<BookingEntity> getsearch(int room_type_Id){
//        return  bookingRepository.finBookingEntitys1(room_type_Id);
//    }
        public void save(BookingEntity booking) {
        bookingRepository.save(booking);
    }     
}
