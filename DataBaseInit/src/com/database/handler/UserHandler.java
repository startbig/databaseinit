package com.database.handler;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.User;
import com.database.service.UserService;
import com.database.utils.Constant;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/user")  
public class UserHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
    @Resource  
    private UserService userService;
    
    

	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
	

	@RequestMapping("/selectUserList")
	@ResponseBody
	public PageVo selectUserList(Integer page,Integer limit, User user){
		if(user==null){
			user=new User();
		}
		user.setPageSize(limit);
		user.setCurrPage(page);
		pageVo=userService.selectUserList(user);
		pageVo.setSuccess(true);
		return pageVo;
	}

	@RequestMapping("/getUserList")
	@ResponseBody
	public List<User> getUserList(Integer offset,Integer limit, User user){
		if(user==null){
			user=new User();
			user.setPageSize(limit);
			user.setCurrPage(offset);
		}
	
		pageVo=userService.selectUserList(user);
		pageVo.setSuccess(true);
		return pageVo.getRoot();
	}
	
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public PageVo updateUser(@RequestBody User user){
		pageVo = new PageVo();
		boolean flag=userService.updateUser(user);
		pageVo.setSuccess(flag);
		return pageVo;
	}
	@RequestMapping("/insertUser")
	@ResponseBody
	public PageVo insertUser( User user){
		pageVo = new PageVo();
        User loginUser = (User) request.getSession().getAttribute("loginUser");  
        int flag=userService.exist(user);
        if(flag>0){
        	pageVo.setMsg(Constant.EXIST_MSG);	
        	pageVo.setSuccess(false);
        }else{
        	String userName=loginUser.getUserName();
            user.setCreateUser(userName);
      		boolean success=userService.insertUser(user);
      		pageVo.setSuccess(success);	
        }
		return pageVo;
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public PageVo deleteUser(@RequestBody User user){
		pageVo = new PageVo();
		boolean flag=userService.deleteUser(user);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	
}
