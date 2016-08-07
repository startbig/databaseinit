package com.database.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Gene;
import com.database.po.GeneExport;
import com.database.po.GeneRecord;
import com.database.po.User;
import com.database.service.GeneExportService;
import com.database.service.GeneRecordService;
import com.database.service.GeneService;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/gene")  
public class GeneHandler extends HandlerBase {

	@Resource
	private GeneService geneService;
	@Resource
	private GeneExportService geneExportService;
	@Resource
	private GeneRecordService geneRecordService;
	private PageVo pageVo = new PageVo();
	
	
	@RequestMapping("/selectGeneExportList")
	@ResponseBody
	public PageVo selectGeneExportList(Integer page,Integer limit, GeneExport geneExport){
		if(geneExport==null){
			geneExport=new GeneExport();
		}
		geneExport.setPageSize(limit);
		geneExport.setCurrPage(page);
		pageVo=geneExportService.selectGeneExportList(geneExport);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
	@RequestMapping("/selectGeneRecordList")
	@ResponseBody
	public PageVo selectGeneRecordList(Integer page,Integer limit, GeneRecord record){
		if(record==null){
			record=new GeneRecord();
		}
		record.setPageSize(limit);
		record.setCurrPage(page);
		pageVo=geneRecordService.selectGeneRecordList(record);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
	@RequestMapping("/selectGeneList")
	@ResponseBody
	public PageVo selectGeneList(Integer page,Integer limit, Gene gene){
		if(gene==null){
			gene=new Gene();
		}
		gene.setPageSize(limit);
		gene.setCurrPage(page);
		pageVo=geneService.selectGeneList(gene);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
	@RequestMapping("/updateGene")
	@ResponseBody
	public PageVo updateGene( Gene gene) {
		pageVo = new PageVo();
		User loginUser = (User) request.getSession().getAttribute("loginUser");  
		gene.setUpdateUser(loginUser.getUserName());
		boolean flag = geneService.updateGene(gene);
		pageVo.setSuccess(flag);
		return pageVo;
	}

}
