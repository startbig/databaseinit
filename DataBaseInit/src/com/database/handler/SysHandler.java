package com.database.handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Syscode;
import com.database.po.User;
import com.database.service.SyscodeService;
import com.database.service.UserService;
import com.database.utils.Constant;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
public class SysHandler extends HandlerBase {
	private PageVo pageVo = new PageVo();

	@Resource
	private UserService userService;
	@Resource
	private SyscodeService syscodeService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, User user) {
		HttpSession session = request.getSession();
		User check = userService.loginUser(user);
		if (check != null) {
			session.setAttribute("loginUser", check);
			 return "redirect:index.jsp";  
		} else {
			session.setAttribute("errorInfo", Constant.ERRORINFO_MSG);
			return "login.jsp";

		}
	}

	@RequestMapping("/selectSyscodeList")
	@ResponseBody
	public PageVo selectSyscodeList(Integer page, Integer limit, Syscode syscode) {
		if (syscode == null) {
			syscode = new Syscode();
		}
		syscode.setPageSize(limit);
		syscode.setCurrPage(page);
		pageVo = syscodeService.selectSyscodeList(syscode);
		pageVo.setSuccess(true);
		return pageVo;
	}

	@RequestMapping("/updateSyscode")
	@ResponseBody
	public PageVo updateSyscode(@RequestBody Syscode syscode) {
		pageVo = new PageVo();
		boolean flag = syscodeService.updateSyscode(syscode);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/insertSyscode")
	@ResponseBody
	public PageVo insertSyscode(@RequestBody List<Syscode> syscode) {
		   pageVo = new PageVo();
			boolean success = syscodeService.insertSyscodeList(syscode);
			pageVo.setSuccess(success);
		
		return pageVo;
	}

	@RequestMapping("/deleteSyscode")
	@ResponseBody
	public PageVo deleteSyscode(@RequestBody Syscode syscode) {
		pageVo = new PageVo();
		boolean flag = syscodeService.deleteSyscode(syscode);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		 return "redirect:login.jsp";  
	}
}
