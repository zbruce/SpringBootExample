package com.weibo;

import com.weibo.domain.Girl;
import com.weibo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//mvn打包（mvn clean package）时会自动运行单元测试，全部通过后才会打包成功。
//如果希望跳过单元测试，可以使用mvn clean package -Dmaven.test.skip=true
@RunWith(SpringRunner.class) //表示要在测试环境跑，底层使用junit测试工具
@SpringBootTest //表示启动整个springboot工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test //测试方法加上test注解
    public void findOneTest(){
        Girl girl = girlService.findOne(1);
        Assert.assertEquals(new Integer(18), girl.getAge());
    }
}
