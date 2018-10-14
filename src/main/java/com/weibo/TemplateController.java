package com.weibo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//controller要配合ResponseBody。如果是前端开发，要配合模版使用，可以在resources里新建templates
@Controller
@ResponseBody
public class TemplateController {

    @Value("${height}")
    private double height;

    @Value("${gender}")
    private String gender;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/template", method = RequestMethod.GET) //配置url映射
    public String say(){
        return content;
    }

}
