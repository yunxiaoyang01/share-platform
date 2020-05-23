package com.file.share.platform.web;
import com.file.share.platform.core.Result;
import com.file.share.platform.core.ResultGenerator;
import com.file.share.platform.model.User;
import com.file.share.platform.model.request.UserLogin;
import com.file.share.platform.model.request.UserReg;
import com.file.share.platform.model.request.UserSearch;
import com.file.share.platform.service.UserService;
import com.file.share.platform.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import static com.file.share.platform.core.ProjectConstant.*;
/**
* Created by CodeGenerator on 2020/05/20.
*/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        User user1 = userService.findByAccountNumber(user.getAccountNumber());
        if (user1!=null){
            return ResultGenerator.genFailResult("当前手机号已经注册过了");
        }
        user.setCreateTime(new Date());
        user.setPassword("12345");
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }


    @GetMapping("/resetPassword")
    public Result resetPassword(@RequestParam Integer id){
        User user = userService.findById(id);
        if (user==null){
            return ResultGenerator.genFailResult("用户不存在");
        }
        user.setPassword("123456");
        user.setUpdateTime(new Date());
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestBody UserSearch userSearch) {
        PageHelper.startPage(userSearch.getPage(), userSearch.getSize());
        Condition condition = new Condition(User.class);
        Example.Criteria criteria = condition.createCriteria();
        if (userSearch.getRole()==null||userSearch.getRole().equals("")){
            return ResultGenerator.genFailResult("用户角色条件不能为空");
        }
        criteria.andEqualTo("role",userSearch.getRole());
        if (userSearch.getUserName()!=null&&!userSearch.getUserName().equals("")){
            criteria.andLike("userName","%"+userSearch.getUserName()+"%");
        }
        condition.orderBy("id").desc();
        List<User> list = userService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserReg userReg){
        if (!userReg.getConfirmPassword().equals(userReg.getPassword())){
            return ResultGenerator.genFailResult("用户两次密码不一致");
        }
        User user = userService.findByAccountNumber(userReg.getAccountNumber());
        if (user!=null){
            return ResultGenerator.genFailResult("当前手机号已经注册过了，请在登陆页面登陆");
        }
        user = new User();
        BeanUtils.copyProperties(userReg,user);
        user.setCreateTime(new Date());
        user.setRole(StudentRole);
        String token = RandomUtil.genRandomNum();
        user.setToken(token);
        userService.save(user);
        return ResultGenerator.genSuccessResult(user);
    }
    @PostMapping("/login")
    public Result login(@RequestBody UserLogin userLogin){
        User user = userService.findByAccountNumber(userLogin.getAccountNumber());
        if (user==null||!user.getPassword().equals(userLogin.getPassword())){
            return ResultGenerator.genFailResult("用户名或密码错误");
        }
        String token = RandomUtil.genRandomNum();
        user.setToken(token);
        user.setUpdateTime(new Date());
        userService.update(user);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/getInfo")
    public Result getUserInfo(HttpServletRequest request){
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        return ResultGenerator.genSuccessResult(user);
    }


    @PostMapping("/logout")
    public Result logout(HttpServletRequest request){
        User user = getUserByToken(request);
        if (user==null){
            return ResultGenerator.genNotLogin();
        }
        user.setToken("");
        user.setUpdateTime(new Date());
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

}
