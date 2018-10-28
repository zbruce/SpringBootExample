package com.weibo.controller;

import com.weibo.domain.Girl;
import com.weibo.domain.Result;
import com.weibo.repository.GirlRepository;
import com.weibo.service.GirlService;
import com.weibo.utility.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class GirlController {
    //spring自带的日志框架
    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girladd") //可以使用postman做试验，参数在body中添加，post请求。当类的属性很多时，逐个添加参数很麻烦，可以使用下面的方法。
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    //valid注解表示对这个对象进行验证, bindingresult表示验证的结果
    @PostMapping(value = "/girladd2")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage()); //输出错误信息
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge()); //这样添加的话，即使有很多属性，也不必在参数中都列出来。
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过id查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "girls/{id}")
    public Girl girlGet(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    //使用put请求时，在postman里的body标签页，不能使用form-data，而要使用x-www-form-urlencoded
    @PutMapping(value = "girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = girlRepository.findOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 根据id删除一条女生信息
     * @param id
     */
    @DeleteMapping(value = "girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 按照年龄查询女生列表
     * @param age
     * @return
     */
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    //感悟：都没有写try/catch语句，这里抛出异常后，ExceptionHandle类就自动捕获处理了。
    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
