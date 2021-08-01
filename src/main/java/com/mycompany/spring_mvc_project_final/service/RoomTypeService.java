/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.RoomTypeEntity;
import com.mycompany.spring_mvc_project_final.repository.RoomTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khoa hoang
 */
@Service
public class RoomTypeService {
    
    @Autowired
    private RoomTypeRepository romRoomTypeRepository;
    
    
    public List<RoomTypeEntity>  getRoomType(){
        return  (List<RoomTypeEntity>) romRoomTypeRepository.findAll();
    }
    
    
//    public List<RoomTypeEntity> search(Integer id){
////         return  productRepositoty.findByNameContaining(name);
//           return  romRoomTypeRepository.findByIdContaining(id);
//     }
}
