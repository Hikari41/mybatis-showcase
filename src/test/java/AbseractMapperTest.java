import com.cheer.mybatis.dao.BlogMapper;
import com.cheer.mybatis.dao.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbseractMapperTest {
    SqlSession sqlSession = null;
    InputStream inputStream = null;
    BlogMapper blogMapper = null;
    PersonMapper personMapper = null;

    @Before
    public void before() {
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            blogMapper = sqlSession.getMapper(BlogMapper.class);
            personMapper = sqlSession.getMapper(PersonMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        // 事务提交
        this.sqlSession.commit();
        this.sqlSession.close();
        try {
            if (inputStream != null) {
                this.inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
