package cn.smbms.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatiesUtil {

    private  static  SqlSessionFactory factory = null ;
    // 读取配置文件
    // 创建工厂
    static {
        String resource = "configuration.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 打开会话
    public static SqlSession createSqlSession() {

        return factory.openSession();
    }

    // 关闭会话
    public static void closeSqlSession(SqlSession sqlSession ) {
        if ( null != sqlSession ) {
            sqlSession.close();
        }
    }


}
