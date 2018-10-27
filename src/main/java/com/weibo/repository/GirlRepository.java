package com.weibo.repository;

import com.weibo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface GirlRepository extends JpaRepository<Girl, Integer> { //类名和id的类型

    /**
     * 按照年龄查询
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);

    /**
     * 按照罩杯查询
     * @param cupSize
     * @return
     */
    List<Girl> findByCupSize(String cupSize);
}
