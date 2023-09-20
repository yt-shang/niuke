package cn.edu.cug;

import cn.edu.cug.mapper.DiscussPostMapper;
import cn.edu.cug.pojo.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DiscussMapperTest {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPostRows(){
        int count = discussPostMapper.selectDiscussPostRows(101);
        System.out.println(count);
    }
    @Test
    public void testList(){
        List<DiscussPost> discussLists = discussPostMapper.lists(101);
        for(DiscussPost discussPost:discussLists){
            System.out.println(discussPost);
        }
    }
    @Test
    public void testSelectPost(){
        List<DiscussPost> discussLists = discussPostMapper.selectDiscussPosts(101,0,10);
        for (DiscussPost discussPost:discussLists){
            System.out.println(discussPost);
        }
    }
}
