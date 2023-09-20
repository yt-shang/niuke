package cn.edu.cug.controller;

import cn.edu.cug.pojo.DiscussPost;
import cn.edu.cug.pojo.Page;
import cn.edu.cug.pojo.User;
import cn.edu.cug.service.DiscussPostService;
import cn.edu.cug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //方法调用前，SpringMVC会自动实例化model和page而且会将page注入model
        //所以，在thymeleaf中可以直接访问page 对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");//页面index.html,就是点击页码要跳转到的页面,跳转页码会再次发送请求，然后在这里查询第n页的数据，然后响应，然后显示
        List<DiscussPost> list =discussPostService.findDiscussPosts(0,page.getOffSet(), page.getLimit());
        List<Map<String,Object>> discussPostsList = new ArrayList<>();
        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPostsList.add(map);
            }
        }
        model.addAttribute("discussPostsList",discussPostsList);//注入model
        return "/index"; //返回的是页面index.html
    }
}
