package com.ljdo.controller;

import com.google.common.base.Joiner;
import com.ljdo.bean.User;
import com.ljdo.bean.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by fly on 2016/1/3.
 */
@Controller
public class UserController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("index","fly , i am coming!");
        return model;
    }

    /**
     * 参数
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("test01")
    @ResponseBody
    public String test01(String name,Integer age){
        return "name:"+name+"    age:"+age;
    }

    /**
     * 参数
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("test02/{name}/{age}")
    @ResponseBody
    public String test02(@PathVariable("name") String name,@PathVariable("age") Integer age){
        return "name:"+name+"    age:"+age;
    }

    /**
     * 对象
     * @param user
     * @return
     */
    @RequestMapping("test03")
    @ResponseBody
    public String test03(User user){
        return user.toString();
    }

    /**
     * 对象
     * @param user
     * @return
     */
    @RequestMapping("test04")
    @ResponseBody
    public User test04(@RequestBody User user){
        System.out.println("!!!!!!!!!!!!" + user.toString());
        return user;
    }
    /**
     * 对象
     * @param user
     * @return
     */
    @RequestMapping("test041")
    @ResponseBody
    public String test041(@RequestBody User user) {
        System.out.println("!!!!!!!!!!!!" + user.toString());
        /* 在实际运用中，不会返回String类型
        当返回String类型时，
        前端如果使用dataType:"json",（设置返回的类型）这个时会报parseError,
        如果使用dataType:"text"则不会报错
        function test041(){
            var params = {name:"小花", age:18, height:19.87, hasGirl:true, likes:"MOVIE"};
            console.info("a1");
            console.info(JSON.stringify(params));
            $.ajax({
                    type:"post",
                    url:"/test041",
                    dataType:"text",
//                dataType:"json",//设置返回的类型
                    processData : false,
                    contentType : 'application/json', //设置请求头信息
                    data:JSON.stringify(params),
                    success:function(data){
                alert(data);
            }
            });
        }*/
        return user.toString();
    }

    /**
     * 字符串集合
     * @param list
     * @return
     */
    @RequestMapping("test05")
    @ResponseBody
    public String test05(@RequestParam("list[]") List<String> list){
        return list.toString();
    }

    /**
     * 对象集合
     * @param users
     * @return
     */
    @RequestMapping("test06")
    @ResponseBody
    public String test06(@RequestBody List<User> users){
        return users.toString();
    }

    /**
     * 对象数组
     * @param users
     * @return
     */
    @RequestMapping("test07")
    @ResponseBody
    public String test07(@RequestBody User[] users){
        return Arrays.toString(users);
    }

    /**
     * map集合
     * @param list
     * @return
     */
    @RequestMapping("test08")
    @ResponseBody
    public String test08(@RequestBody List<Map<String,Object>> list){
        return list.toString();
    }

    /**
     * 对象中有对象集合
     * @param list
     * @return
     */
    @RequestMapping("test09")
    @ResponseBody
    public String test09(@RequestBody Users list){
        return list.toString();
    }

    /**
     * 字符串数组
     * @param str
     * @return
     */
    @RequestMapping("test10")
    @ResponseBody
    public String test10(@RequestBody String[] str){
        return Arrays.toString(str);
    }

    /**
     * PathVariable 奇葩的Integer数组传递方式（慎用）
     * @param ids
     * @return
     */
    @RequestMapping("test11/{ids}")
    @ResponseBody
    public String test10(@PathVariable Integer[] ids){
        return Joiner.on(",").join(ids);
    }
}