package com.winby.demo.core.service;

import com.winby.demo.core.dao.persistence.DemoDao;
import com.winby.demo.core.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    DemoDao demoDao;
    public Demo getById(Long id){
        return demoDao.selectByPrimaryKey(id);
    }
}
