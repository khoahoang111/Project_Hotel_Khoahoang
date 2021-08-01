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
public class IPaginatesServiceImpl {

    public PaginatesDto getInfopaginates(int totalDate, int limit, int currentPager) {
        PaginatesDto paginatesDto = new PaginatesDto();
        paginatesDto.setLimit(limit);
//        paginatesDto.setTotalPage(totalDate);

        paginatesDto.setTotalPage(SetInfoTotalPage(totalDate, limit));
        paginatesDto.setCurrentPage(checkCurrentPage(currentPager, paginatesDto.getTotalPage()));
        int start = FintStart(paginatesDto.getCurrentPage(), limit);
        int end = FintEnd(paginatesDto.getStart(), limit, totalDate);
        paginatesDto.setStart(start);
        paginatesDto.setEnd(end);
        return paginatesDto;
    }

    private Integer SetInfoTotalPage(int totalDate, int limit) {
        int totalPage = 0;
        totalPage = totalDate / limit;
        totalPage = totalPage * limit < totalDate ? totalPage + 1 : totalPage;
        return totalPage;
    }

    public int checkCurrentPage(int currentPage, int totalPage) {
        if (currentPage < 1) {
            return 1;
        }
        if (currentPage > totalPage) {
            return totalPage;
        }
        return currentPage;
    }

    private int FintStart(int currentPage, int limit) {
        return ((currentPage - 1) * limit) + 1;
    }

    private int FintEnd(int start, int limit, int totalDate) {
        return  start + limit > totalDate ? totalDate : (start + limit) - 1;
    }
}
