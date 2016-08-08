package com.database.handler;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;import com.database.utils.PageVo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.database.po.Model;
import com.database.service.ModelService;
import com.database.utils.HandlerBase;
import com.database.utils.Constant;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/model")
public class ModelHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
	@Resource 
	private ModelService modelService;

	@RequestMapping("/getModelList")
	@ResponseBody
	public PageVo getModelList(Integer page,Integer limit, Model model){
		if(model==null){
			model=new Model();
		}
		model.setPageSize(limit);
		model.setCurrPage(page);
		pageVo=modelService.getModelList(model);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/insertModel")
	@ResponseBody
	public PageVo insertModel(Model model){
		pageVo = new PageVo();
		String userName=Constant.getUserName(request);
		model.setCreateUser(userName);
		boolean success=modelService.insertModel(model);
		pageVo.setSuccess(success);
		return pageVo;
	}
	@RequestMapping("/updateModel")
	@ResponseBody
	public PageVo updateModel(Model model){
		pageVo = new PageVo();
		boolean success=modelService.updateModel(model);
		pageVo.setSuccess(success);
		return pageVo;
	}
}