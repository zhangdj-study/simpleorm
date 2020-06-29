package com.neusiri.orm;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2020-01-15 17:00
 */
public class Configuration {

    public <T> T getMapper(Class<T> clazz,SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},
                new MapperProxy(sqlSession));
    }

    /**
     * 模拟解析xml文件  映射mapper中方法和xml中的sql语句
     */
    static class UserMapperXML{
        public static final String namespace = "com.neusiri.mapper.UserMapper";

        public static final Map<String,String> sqlMappings = new HashMap<String, String>();

        static {
            sqlMappings.put("queryById","select * from t_innodb_user where id = %d");
            sqlMappings.put("queryList","select * from t_innodb_user");
        }
    }
}
