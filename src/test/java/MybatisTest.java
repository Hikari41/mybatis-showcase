import com.cheer.mybatis.model.Blog;
import com.cheer.mybatis.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class MybatisTest extends AbseractMapperTest {
    private static final Logger LOGGER = LogManager.getLogger(MybatisTest.class);

    @Test
    public void getBlog() {
        Blog blog = blogMapper.getBlog(1);
        Assert.assertNotNull(blog);
        LOGGER.debug(blog);
    }

    @Test
    public void insert() {
        Blog blog = new Blog();
        blog.setId(2);
        blog.setTitle("平安京");
        blog.setAuthor("老贾兴国");
        this.blogMapper.insert(blog);
    }

    @Test
    public void update() {
        Blog blog = new Blog();
        blog.setId(2);
        blog.setTitle("决战平安京");
        blog.setAuthor("老贾");
        this.blogMapper.update(blog);
    }

    @Test
    public void delete() {
        this.blogMapper.delete(2);
    }

    @Test
    public void getPage() {
        /*int count = blogMapper.getCount();
        Page page = new Page(count,2,1);
        blogMapper.getPage(page);*/

        PageHelper.startPage(2,2);
        List<Blog> blogList = blogMapper.getAll();
        PageInfo pageInfo = new PageInfo(blogList);
        Assert.assertEquals(2,blogList.size());
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

    @Test
    public void getCount() {
        int count = blogMapper.getCount();
        LOGGER.debug(count);
    }

    @Test
    public void getAll() {
        blogMapper.getAll();
    }

    @Test
    public void selectPerson()
    {
        List<Map<String,Object>> mapList = personMapper.selectPerson();
        for (Map<String,Object> map : mapList) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.printf("key=%s,value=%s",entry.getKey(),entry.getValue());
            }
        }
        System.out.println(new Gson().toJson(mapList));
    }
}
