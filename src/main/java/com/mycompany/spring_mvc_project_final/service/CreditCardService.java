/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.CreditCardEntity;
import com.mycompany.spring_mvc_project_final.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khoa hoang
 */
@Service
public class CreditCardService {
    
    @Autowired
    private CreditCardRepository creditCardRepository;
    
    
    public CreditCardEntity getcreCardEntity(String cardNumber){
        return creditCardRepository.getcreditCard(cardNumber);
    }
    
    
    public void save(CreditCardEntity creditcard) {
        creditCardRepository.save(creditcard);
    }
    
    
    
    
}
