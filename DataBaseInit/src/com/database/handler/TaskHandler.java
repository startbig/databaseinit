package com.database.handler;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.database.po.Addpmtask;
import com.database.po.Task;
import com.database.po.User;
import com.database.service.AddpmtaskService;
import com.database.service.TaskService;
import com.database.utils.Constant;
import com.database.utils.FileUtil;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;
@Controller
@RequestMapping("/task")
public class TaskHandler extends HandlerBase {
	private PageVo pageVo = new PageVo();
    @Resource  
    private TaskService taskService;
    
    @Resource  
    private AddpmtaskService addpmtaskService;
    
    

	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
	

	@RequestMapping("/selectTaskList")
	@ResponseBody
	public PageVo selectTaskList(Integer page,Integer limit, Task record){
		if(record==null){
			record=new Task();
		}
		record.setPageSize(limit);
		record.setCurrPage(page);
		pageVo=taskService.selectTaskList(record);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
	@RequestMapping("/selectAddpmtaskList")
	@ResponseBody
	public PageVo selectAddpmtaskList(Integer page,Integer limit, Addpmtask record){
		if(record==null){
			record=new Addpmtask();
		}
		record.setPageSize(limit);
		record.setCurrPage(page);
		pageVo=addpmtaskService.selectAddpmtaskList(record);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/insertAddPmcTask")
	@ResponseBody
	public PageVo insertAddPmcTask( Addpmtask task){
		    pageVo = new PageVo();
        	String userName=Constant.getUserName(request);
        	task.setCreateUser(userName);
        	task.setType("text");
      		boolean success=addpmtaskService.insertAddpmtask(task);
      		pageVo.setSuccess(success);	
		return pageVo;
	}
	@RequestMapping("/uploadFile")
	@ResponseBody
	public PageVo uploadFile(@RequestParam(value = "file", required = false)MultipartFile file,Addpmtask task) throws IOException {
		  String path = request.getSession().getServletContext().getRealPath("upload");
	        String fileName = file.getOriginalFilename();
	        String userName=Constant.getUserName(request);
	        task.setReplyContent("upload/"+fileName);
	        task.setType(FileUtil.getType(fileName));
        	task.setCreateUser(userName);
	        File targetFile = new File(path, fileName);
	        System.out.println(path);
	        if(!targetFile.exists()){
	            targetFile.mkdirs();
	        }
	        //保存
	        try {
	            file.transferTo(targetFile);
	            boolean success=addpmtaskService.insertAddpmtask(task);
	      		pageVo.setSuccess(success);	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return pageVo;  
	}
}
