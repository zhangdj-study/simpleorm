package com.neusiri.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdj
 * @date 2020-01-15 17:09
 */
public class Executor {

    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";


    public <T> T selectOne(String statement, String params) {
        return null;
    }

    public <T> List<T> selectList(String statement, String params) throws Exception{
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(statement);
        while(rs.next()){
            System.out.println(rs.getString("name")+" 手机号："+rs.getString("phone"));
        }
        return new ArrayList<T>();
    }
}
