package com.weibo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

//entity注解会自动根据类在数据库中创建表，此程序在dbgirl数据库中创建表girl
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer Id;

    private String cupSize;

    @Min(value = 18, message = "未成年禁止") //用于表单验证的最小值
    private Integer age;

    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //必须是无参的构造方法，否则数据库中会报错
    public Girl(){}

    @Override
    public String toString() { //右键generate，选择toString()
        return "Girl{" +
                "Id=" + Id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
