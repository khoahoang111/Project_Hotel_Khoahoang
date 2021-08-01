/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.RoomTypeEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khoa hoang
 */
@Repository
public interface RoomTypeRepository extends CrudRepository<RoomTypeEntity, Integer> {

    List<RoomTypeEntity> findByIdContaining(int id);
}
