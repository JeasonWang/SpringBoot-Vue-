package com.wanghuan.blogserver;

import com.wanghuan.blogserver.util.TokenConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class BlogserverApplicationTests {
    @Autowired
    TokenConfig tokenConfig;

    @Test
    void contextLoads() {
        System.out.println(tokenConfig.getExpiration());
    }


}
