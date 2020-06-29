package com.neusiri;

import com.neusiri.mapper.UserMapper;
import com.neusiri.model.UserDO;
import com.neusiri.orm.Configuration;
import com.neusiri.orm.Executor;
import com.neusiri.orm.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangdj
 * @date 2020-01-16 16:51
 */
public class Main {

    @Test
    public void ormTest(){
        Configuration configuration = new Configuration();
        Executor executor = new Executor();
        SqlSession sqlSession = new SqlSession(configuration,executor);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserDO> userDOS = mapper.queryList(1L);
        System.out.println(userDOS);
    }

}
