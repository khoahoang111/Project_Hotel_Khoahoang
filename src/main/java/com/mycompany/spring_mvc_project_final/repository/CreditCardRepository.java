/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.CreditCardEntity;
import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khoa hoang
 */
@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Integer> {

    @Query(value = "SELECT * FROM credit_card c where c.cardNumber = :cardNumber ", nativeQuery = true)
    CreditCardEntity getcreditCard(
            @Param("cardNumber") String cardNumber);

}
