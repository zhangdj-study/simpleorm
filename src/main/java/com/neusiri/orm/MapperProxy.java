package com.neusiri.orm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhangdj
 * @date 2020-01-15 17:29
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法名一样
        if (method.getDeclaringClass().getName().equals(Configuration.UserMapperXML.namespace)){
            String methodName = method.getName();
            String statement = Configuration.UserMapperXML.sqlMappings.get(methodName);
            String params = String.valueOf(args[0]);
            return sqlSession.selectList(statement,params);
        }
        return method.invoke(this,args);
    }
}
