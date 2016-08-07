package com.database.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Device;
import com.database.service.DeviceService;
import com.database.utils.Constant;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/device")  
public class DeviceHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
    @Resource  
    private DeviceService deviceService;
    
    

	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
	

	@RequestMapping("/getDeviceList")
	@ResponseBody
	public PageVo getDeviceList(Integer page,Integer limit, Device device){
		if(device==null){
			device=new Device();
		}
		device.setPageSize(limit);
		device.setCurrPage(page);
		pageVo=deviceService.selectDeviceList(device);
		pageVo.setSuccess(true);
		return pageVo;
	}

	@RequestMapping("/insertDevice")
	@ResponseBody
	public PageVo insertDevice( Device uDevice){
		    pageVo = new PageVo();
        	String userName=Constant.getUserName(request);
        	uDevice.setCreateUser(userName);
      		boolean success=deviceService.insertDevice(uDevice);
      		pageVo.setSuccess(success);	
		return pageVo;
	}
	
	@RequestMapping("/updateDevice")
	@ResponseBody
	public PageVo updateDevice( Device uDevice){
		    pageVo = new PageVo();
      		boolean success=deviceService.updateDevice(uDevice);
      		pageVo.setSuccess(success);	
		return pageVo;
	}
	@RequestMapping("/intoStorage")
	@ResponseBody
	public PageVo intoStorage(  Device uDevice){
		    pageVo = new PageVo();
      		boolean success=deviceService.updateDevice(uDevice);
      		pageVo.setSuccess(success);	
		return pageVo;
	}


	
}
