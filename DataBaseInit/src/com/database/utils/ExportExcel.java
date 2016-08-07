package com.database.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.database.po.Gene;

public class ExportExcel {
	public static WritableSheet sheet;
	public static WritableWorkbook workbook;

	/*** 具体载入的方法 */
	public static WritableWorkbook  excelExportGenu(List<Gene> list,OutputStream os) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String name = sdf.format(new Date()).toString();
		try {
			workbook = Workbook.createWorkbook(os);
			// 创建一个工作簿
			WritableSheet sheet = workbook.createSheet(name, 0);
			sheet.setColumnView(0, 16);
			jxl.write.Label label0 = new jxl.write.Label(0, 0, "上机芯片");
			jxl.write.Label label1 = new jxl.write.Label(1, 0, "样品编号");
			jxl.write.Label label2 = new jxl.write.Label(2, 0, "疾病/OMIM号/遗传方式");
			jxl.write.Label label3 = new jxl.write.Label(3, 0, "基因");
			jxl.write.Label label4 = new jxl.write.Label(4, 0, "参考序列/转录本");
			jxl.write.Label label5 = new jxl.write.Label(5, 0, "核苷酸变化");
			jxl.write.Label label6 = new jxl.write.Label(6, 0, "氨基酸变化");
			jxl.write.Label label7 = new jxl.write.Label(7, 0, "基因亚区");
			jxl.write.Label label8 = new jxl.write.Label(8, 0, "染色体位置");
			jxl.write.Label label9 = new jxl.write.Label(9, 0, "rs号");
			jxl.write.Label label10 = new jxl.write.Label(10, 0, "dbINDEL频率*");
			jxl.write.Label label11 = new jxl.write.Label(11, 0, "Hapmap频率*");
			jxl.write.Label label12 = new jxl.write.Label(12, 0, "千人频率*");
			jxl.write.Label label13 = new jxl.write.Label(13, 0, "本地频率*");
			jxl.write.Label label14 = new jxl.write.Label(14, 0, "功能改变");
			jxl.write.Label label15 = new jxl.write.Label(15, 0, "突变类型");
			jxl.write.Label label16 = new jxl.write.Label(16, 0, "参考文献");
			jxl.write.Label label17 = new jxl.write.Label(17, 0, "位点说明");
			jxl.write.Label label18 = new jxl.write.Label(18, 0, "备注");
			jxl.write.Label label19 = new jxl.write.Label(19, 0, "疾病表型");
			sheet.addCell(label0);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			sheet.addCell(label5);
			sheet.addCell(label6);
			sheet.addCell(label7);
			sheet.addCell(label8);
			sheet.addCell(label9);
			sheet.addCell(label10);
			sheet.addCell(label11);
			sheet.addCell(label12);
			sheet.addCell(label13);
			sheet.addCell(label14);
			sheet.addCell(label15);
			sheet.addCell(label16);
			sheet.addCell(label17);
			sheet.addCell(label18);
			sheet.addCell(label19);
	for (int i = 0; i < list.size(); i++) {
		Gene data = list.get(i);
		 String sampleNum="";
		 String chip="";
		if(data.getListChip()!=null){
			for (int j = 0; j < data.getListChip().size(); j++) {
				chip=chip+data.getListChip().get(j).getChip()+"\n";
			}
		}else{
			chip="\\";
		}
		if(data.getListSample()!=null){
			for (int j = 0; j < data.getListSample().size(); j++) {
				sampleNum=sampleNum+data.getListSample().get(j).getSampleNum()+"\n";
			}
		}else{
			sampleNum="\\";
		}
	        jxl.write.Label labe0 = new jxl.write.Label(0, i + 1,chip );
	        jxl.write.Label labe1 = new jxl.write.Label(1, i + 1, sampleNum);
		    jxl.write.Label labe2 = new jxl.write.Label(2, i + 1, data.getGeneticMode()!=null?data.getGeneticMode():"\\");
			jxl.write.Label labe3 = new jxl.write.Label(3, i + 1, data.getGene()!=null?data.getGene():"\\");
			jxl.write.Label labe4 = new jxl.write.Label(4, i + 1, data.getSequence()!=null?data.getSequence():"\\");
			jxl.write.Label labe5 = new jxl.write.Label(5, i + 1, data.getNucleotide()!=null?data.getNucleotide():"\\");
			jxl.write.Label labe6 = new jxl.write.Label(6, i + 1, data.getAminophenol()!=null?data.getAminophenol():"\\");
			jxl.write.Label labe7 = new jxl.write.Label(7, i + 1, data.getGeneRegion()!=null?data.getGeneRegion():"\\");
			jxl.write.Label labe8 = new jxl.write.Label(8, i + 1, data.getChromosome()!=null?data.getChromosome():"\\");
			jxl.write.Label labe9 = new jxl.write.Label(9, i + 1, data.getRsnum()!=null?data.getRsnum():"\\");
			jxl.write.Label labe10 = new jxl.write.Label(10, i + 1, data.getDbindel()!=null?data.getDbindel():"\\");
			jxl.write.Label labe11 = new jxl.write.Label(11, i + 1, data.getHapmap()!=null?data.getHapmap():"\\");
			jxl.write.Label labe12 = new jxl.write.Label(12, i + 1, data.getFrequency()!=null?data.getFrequency():"\\");
			jxl.write.Label labe13 = new jxl.write.Label(13, i + 1, data.getLocalFrequency()!=null?data.getLocalFrequency():"\\");
			jxl.write.Label labe14 = new jxl.write.Label(14, i + 1, data.getFeatureChange()!=null?data.getFeatureChange():"\\");
			jxl.write.Label labe15 = new jxl.write.Label(15, i + 1, data.getMutationType()!=null?data.getMutationType():"\\");
			jxl.write.Label labe16 = new jxl.write.Label(16, i + 1, data.getLiterature()!=null?data.getLiterature():"\\");
			jxl.write.Label labe17 = new jxl.write.Label(17, i + 1, data.getSiteRemark()!=null?data.getSiteRemark():"\\");
			jxl.write.Label labe18 = new jxl.write.Label(18, i + 1, data.getRemark()!=null?data.getRemark():"\\");
			jxl.write.Label labe19 = new jxl.write.Label(19, i + 1, data.getDiseasePhenotype()!=null?data.getDiseasePhenotype():"\\");


			sheet.addCell(labe0);
			sheet.addCell(labe1);
			sheet.addCell(labe2);
			sheet.addCell(labe3);
			sheet.addCell(labe4);
			sheet.addCell(labe5);
			sheet.addCell(labe6);
			sheet.addCell(labe7);
			sheet.addCell(labe8);
			sheet.addCell(labe9);
			sheet.addCell(labe10);
			sheet.addCell(labe11);
			sheet.addCell(labe12);
			sheet.addCell(labe13);
			sheet.addCell(labe14);
			sheet.addCell(labe15);
			sheet.addCell(labe16);
			sheet.addCell(labe17);
			sheet.addCell(labe18);
			sheet.addCell(labe19);


		}
			workbook.write();
			workbook.close();
			os.close();
		} catch (RowsExceededException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook;
	}

	


}