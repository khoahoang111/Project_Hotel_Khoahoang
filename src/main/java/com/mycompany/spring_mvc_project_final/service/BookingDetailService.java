/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.repository.BookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khoa hoang
 */
@Service
public class BookingDetailService {
    
    @Autowired
    private BookingDetailRepository bookingDetailRepository;
    
    public void save(BookingDetailEntity bookingDetail) {
        bookingDetailRepository.save(bookingDetail);
    }
    
}
