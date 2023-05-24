package com.gdlgxy.lgcommunity.controller;

import com.gdlgxy.lgcommunity.entity.DiscussPost;
import com.gdlgxy.lgcommunity.entity.Page;
import com.gdlgxy.lgcommunity.entity.User;
import com.gdlgxy.lgcommunity.service.DiscussPostService;
import com.gdlgxy.lgcommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String getIndexPage(Model model, Page page) {
        // 设置分页信息
        // 方法调用前,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);

                // 查询帖子的点赞数量
//                long likeCount = likeService.getLikeCount(ENTITYTYPE, post.getId());
//                map.put("likeCount", likeCount);

                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);

        return "/index";
    }



}
