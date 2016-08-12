package com.database.handler;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import com.database.utils.PageVo;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Syscode;
import com.database.service.SyscodeService;
import com.database.utils.HandlerBase;
import com.database.utils.Constant;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/syscode")
public class SyscodeHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
	@Resource 
	private SyscodeService syscodeService;

	@RequestMapping("/getSyscodeList")
	@ResponseBody
	public PageVo getSyscodeList(Integer page,Integer limit, Syscode syscode){
		if(syscode==null){
			syscode=new Syscode();
		}
		syscode.setPageSize(limit);
		syscode.setCurrPage(page);
		pageVo=syscodeService.getSyscodeList(syscode);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/insertSyscode")
	@ResponseBody
	public PageVo insertSyscode(Syscode syscode){
		pageVo = new PageVo();
		String userName=Constant.getUserName(request);
		syscode.setCreateUser(userName);
		boolean success=syscodeService.insertSyscode(syscode);
		pageVo.setSuccess(success);
		return pageVo;
	}
	@RequestMapping("/updateSyscode")
	@ResponseBody
	public PageVo updateSyscode(Syscode syscode){
		pageVo = new PageVo();
		boolean success=syscodeService.updateSyscode(syscode);
		pageVo.setSuccess(success);
		return pageVo;
	}
	
	@RequestMapping("/deleteSyscode")
	@ResponseBody
	public PageVo deleteSyscode( String  id){
		pageVo = new PageVo();
		boolean success=syscodeService.deleteSyscode(id);
		pageVo.setSuccess(success);
		return pageVo;
	}
	
}
