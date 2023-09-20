package cn.edu.cug.mapper;

import cn.edu.cug.pojo.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    /**
     * 查询某个用户的所有帖子
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    public List<DiscussPost> selectDiscussPosts(Integer userId, Integer offset, Integer limit);
    //offset是每一页的起始行号，limit是一页有多少行

    /**
     * 查询某个用户帖子总数
     * @param userId
     * @return
     */
    public int selectDiscussPostRows(@Param("userId") Integer userId);
    //@Param注解给参数起别名
    //如果方法只有一个参数，并且在<if>里使用，则必须加别名。
    @Select("select * from discuss_post where user_id=#{userId}")
    public List<DiscussPost> lists(Integer userId);
}
