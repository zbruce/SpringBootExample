package com.weibo.controller;

import com.weibo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

//web方式访问需要restcontroller注解，等同于Controller+ResponseBody，原来返回json需要这两个
//后端开发，只需要提供rest接口，返回json格式即可
@RestController
@RequestMapping("/all") //可以给整个类指定一个映射，可选
public class HelloController {

    @Value("${height}")
    private double height;

    @Value("${gender}")
    private String gender;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    //配置url映射，多个映射可以对应同一返回。如果类配置了映射，前面加上类的映射
    @RequestMapping(value = {"/hello", "/hello2"}, method = RequestMethod.GET)
    public String say(){
        return content + " hello spring boot " + height + gender;
    }

    @RequestMapping(value = "/hi", method = RequestMethod.POST) //post方法不支持浏览器访问，可以使用postman
    public String hi(){
        return girlProperties.getCupSize() + " " + girlProperties.getAge();
    }

    @GetMapping(value = "/hii")
    public String hii(){
        return girlProperties.getCupSize() + " " + girlProperties.getAge();
    }

    //使用PathVariable获取url中的参数，http://127.0.0.1:8080/example/all/4/go/5, id1=4, id2=5
    @RequestMapping(value = "/{id1}/go/{id2}", method = RequestMethod.GET)
    public String go(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2){
        return "id1: " + id1 + " id2: " + id2;
    }

    //使用RequestParam获取请求参数值，其中的id不必与形参同名，但是要与url里的一致, http://127.0.0.1:8080/example/all/run?id=11, myId=11
    @RequestMapping(value = "run", method = RequestMethod.GET)
    public String run(@RequestParam("id") Integer myId){
        System.out.println("aaa");
        return "id1: " + myId;
    }

    //RequestParam可以设置是否必传和默认值，其中默认值必须字符串, http://127.0.0.1:8080/example/all/run2
    @RequestMapping(value = "run2", method = RequestMethod.GET)
    public String run2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "id1: " + myId;
    }

    //组合注解，可以省略method, 对应的还有postmapping等，http://127.0.0.1:8080/example/all/run3?id=5
    @GetMapping(value = "run3")
    public String run3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "id1: " + myId;
    }
}
