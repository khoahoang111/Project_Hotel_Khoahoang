/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;
import com.mycompany.spring_mvc_project_final.repository.ServiceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khoa hoang
 */
@Service
public class ServiceService {
    
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    
    public  ServiceEntity finbyId(int serviceId){
      Optional<ServiceEntity> service = serviceRepository.findById(serviceId);
        if(service.isPresent()){
            return service.get();
        }
        return  new ServiceEntity();
    }
    
    
    public List<ServiceEntity> getService(){
        return (List<ServiceEntity>) serviceRepository.findAll();
    }
}
