import com.xxc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class UserTest {
    @Test
    public void userFindByIdTest() {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try{
            //读取配置文件内容到reader对象中
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("User.findById", 1);
        System.out.println(user);
        session.close();
    }

}
