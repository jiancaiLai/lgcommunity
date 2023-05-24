package com.gdlgxy.lgcommunity.service;

import com.gdlgxy.lgcommunity.dao.DiscussPostMapper;
import com.gdlgxy.lgcommunity.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    // 查询用户帖子
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    // 查询总记录行数
    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
