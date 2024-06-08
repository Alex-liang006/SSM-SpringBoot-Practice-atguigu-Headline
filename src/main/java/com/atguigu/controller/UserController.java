package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.Result;
import com.atguigu.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Classname: UserController
 * Package: com.atguigu.controller
 * Description:
 * 用户管理controller
 * @Author Alex Liang
 * @Create 2024/5/29 16:31
 * @Version 1.0
 */
@RestController // 返回JSON数据
@RequestMapping("user") // 项目访问根路径
@CrossOrigin // 跨域访问注解
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;


    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token){

        boolean expiration = jwtHelper.isExpiration(token);
        if(expiration){
            // 已经过期
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        return Result.ok(null);
    }




    @PostMapping("login")
    public Result login(@RequestBody User user){
        Result result = userService.login(user);
        return  result;
    }
    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        Result result = userService.getUserInfo(token);
        return result;
    }

    @PostMapping("checkUserName")
    public Result checkUserName(String username){
        Result result = userService.checkUserName(username);

        return result;
    }

    @PostMapping("regist")
    public Result regist(@RequestBody User user){
        Result result = userService.regist(user);
        return result;
    }


}
