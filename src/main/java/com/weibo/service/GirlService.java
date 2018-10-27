package com.weibo.service;

import com.weibo.domain.Girl;
import com.weibo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional //数据库事务管理的注解
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(20);
        girlA.setCupSize("D");

        Girl girlB = new Girl();
        girlB.setAge(22);
        girlB.setCupSize("Eaaaaa");

        girlRepository.save(girlA);
        girlRepository.save(girlB);
    }
}
