package com.fyqz.controller;

import com.fyqz.frameowrk.cache.CacheUtil;
import com.fyqz.frameowrk.util.Result;
import com.fyqz.user.entity.SysUser;
import com.fyqz.user.service.impl.SysUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private SysUserServiceImpl sysUserService;


    @ApiOperation(value = "测试Redis", notes = "测试Redis")
    @PostMapping("/hello/{message}")
    public String hello(@PathVariable("message") String message){
        CacheUtil.getCache().set("testKey",message);
        return "hello-----"+message;
    }

    @ApiOperation(value = "测试测试异常", notes = "测试测试异常")
    @PostMapping("/exceptionOne")
    public Result exception(){
      SysUser user= sysUserService.queryById("1");
        return Result.ok().put("user",user);
    }
}