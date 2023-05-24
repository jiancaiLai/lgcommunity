package com.gdlgxy.lgcommunity.dao;


import com.gdlgxy.lgcommunity.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);

    // discussPostId查询帖子
    DiscussPost selectDiscussPostById(int id);

    // 添加帖子
    int addDisscusPost(DiscussPost discussPost);

    // 更新帖子评论数量
    int updateCommentCount(int id, int commentCount);

    // 置顶
    int updateType(int id, int type);

    // 加精、删除
    int updateStatus(int id, int status);

    // 更新分数
    int updateScore(int id, double score);

}
