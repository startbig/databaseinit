package com.database.handler;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;import com.database.utils.PageVo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.database.po.Brand;
import com.database.service.BrandService;
import com.database.utils.HandlerBase;
import com.database.utils.Constant;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/brand")
public class BrandHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
	@Resource 
	private BrandService brandService;

	@RequestMapping("/getBrandList")
	@ResponseBody
	public PageVo getBrandList(Integer page,Integer limit, Brand brand){
		if(brand==null){
			brand=new Brand();
		}
		brand.setPageSize(limit);
		brand.setCurrPage(page);
		pageVo=brandService.getBrandList(brand);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/insertBrand")
	@ResponseBody
	public PageVo insertBrand(Brand brand){
		pageVo = new PageVo();
		String userName=Constant.getUserName(request);
		brand.setCreateUser(userName);
		boolean success=brandService.insertBrand(brand);
		pageVo.setSuccess(success);
		return pageVo;
	}
	@RequestMapping("/updateBrand")
	@ResponseBody
	public PageVo updateBrand(Brand brand){
		pageVo = new PageVo();
		boolean success=brandService.updateBrand(brand);
		pageVo.setSuccess(success);
		return pageVo;
	}
}