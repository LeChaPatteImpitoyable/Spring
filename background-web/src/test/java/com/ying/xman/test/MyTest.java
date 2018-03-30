package com.ying.xman.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by yingsy on 2018/3/30.
 */
public class MyTest extends BaseTest {

    @Test
    public void redisTest(){
        Jedis jedis = new Jedis("127.0.0.1");
        String str = jedis.get("a");
        System.out.println(jedis.isConnected());
        System.out.println(str);
        jedis.quit();
        jedis.close();
        System.out.println(jedis.isConnected());
    }
}
