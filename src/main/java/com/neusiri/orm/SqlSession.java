package com.neusiri.orm;


import java.util.List;

/**
 * @author zhangdj
 * @date 2020-01-15 15:49
 */
public class SqlSession {

    private Configuration configuration;

    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 获取Mapper
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }

    /**
     * 查询
     * @param statement sql
     * @param params 参数
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statement,String params){
        return executor.selectOne(statement,params);
    }

    public <T> List<T> selectList(String statement,String params) throws Exception{
        return executor.selectList(statement,params);
    }
}
