/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.utils.PaginatesDto;
import org.springframework.stereotype.Service;

/**
 *
 * @author khoa hoang
 */
@Service
public interface IPaginatesService {
    public PaginatesDto getInfopaginates(int  totalDate, int limit, int currentPager);    
}
