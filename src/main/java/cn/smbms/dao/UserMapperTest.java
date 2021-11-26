package cn.smbms.dao;

import cn.smbms.utils.MyBatiesUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class UserMapperTest {
    private Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void test () {
        String resource = "configuration.xml";
        SqlSession sqlSession = null ;
        int count ;
        try {
            //1 获取mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            //2 创建SqlSessionFactory对象，完成对配置文件的读取
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //3 创建sqlSession
            sqlSession = factory.openSession();
            //4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
           /* count = sqlSession.selectOne("cn.smbms.dao.UserMapper.count");
            logger.debug("UserMapperTest count---> " + count);*/


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test02() {
        SqlSession sqlSession = MyBatiesUtil.createSqlSession();
        //int count  = sqlSession.selectOne("cn.smbms.user.UserMapper.count");
        int count = sqlSession.getMapper(UserMapper.class).count();
        logger.debug("改进后查询的结果"  + count );
        MyBatiesUtil.closeSqlSession(sqlSession);
    }

}
