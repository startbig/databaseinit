/**
 * 
 */
package com.database.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.database.po.Gene;

/**
 * @项目名称：Sims
 * @类名称：UtilsExcel.java
 * @类描述：
 * @创建人：guchong
 * @创建时间：2016年1月14日 上午9:44:21
 * @version： 1.0
 */
public class UtilsExcel {
    public static List < Gene > readExcelByGene(InputStream f) {
        Workbook book = null;
        try {
            book = Workbook.getWorkbook(f);
        } catch (BiffException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Sheet sheet = book.getSheet(0);
        int rows = sheet.getRows(); // 总行数
        String columns_a1 = "上机芯片";
        String columns_a2 = "样本编号";
        String columns_a3 = "疾病/OMIM号/遗传方式";
        String columns_a4 = "基因";
        String columns_a5 = "参考序列/转录本";
        String columns_a6 = "核苷酸变化";
        String columns_a7 = "氨基酸变化";
        String columns_a8 = "基因亚区";
        String columns_a9 = "染色体位置";
        String columns_a10 = "rs号";
        String columns_a11 = "dbINDEL频率*";
        String columns_a12 = "Hapmap频率*";
        String columns_a13 = "千人频率*";
        String columns_a14 = "本地频率*";
        String columns_a15 = "功能改变";
        String columns_a16 = "突变类型";
        String columns_a17 = "参考文献";
        String columns_a18 = "位点说明";
        String columns_a19 = "备注";
        String columns_a20 = "疾病表型";
        String sampleNum = null;
        String chip = null;
        String geneticMode = null;
        String gene = null;
        String sequence = null;
        String nucleotide = null;
        String aminophenol = null;
        String geneRegion = null;
        String chromosome = null;
        String rsnum = null;
        String dbindel = null;
        String hapmap = null;
        String frequency = null;
        String localFrequency = null;
        String featureChange = null;
        String mutationType = null;
        String literature = null;
        String siteRemark = null;
        String remark = null;
        String diseasePhenotype = null;

        int index_a1 = -1;
        int index_a2 = -1;
        int index_a3 = -1;
        int index_a4 = -1;
        int index_a5 = -1;
        int index_a6 = -1;
        int index_a7 = -1;
        int index_a8 = -1;
        int index_a9 = -1;
        int index_a10 = -1;
        int index_a11 = -1;
        int index_a12 = -1;
        int index_a13 = -1;
        int index_a14 = -1;
        int index_a15 = -1;
        int index_a16 = -1;
        int index_a17 = -1;
        int index_a18 = -1;
        int index_a19 = -1;
        int index_a20 = -1;
        for (int i = 0; i < sheet.getColumns(); i++) {
            String index_name = sheet.getCell(i, 0).getContents();
            if (index_name != null && index_name.equals(columns_a1)) {
                index_a1 = i;
            } else if (index_name != null && index_name.equals(columns_a2)) {
                index_a2 = i;
            } else if (index_name != null && index_name.equals(columns_a3)) {
                index_a3 = i;
            } else if (index_name != null && index_name.equals(columns_a4)) {
                index_a4 = i;
            } else if (index_name != null && index_name.equals(columns_a5)) {
                index_a5 = i;
            } else if (index_name != null && index_name.equals(columns_a6)) {
                index_a6 = i;
            } else if (index_name != null && index_name.equals(columns_a7)) {
                index_a7 = i;
            } else if (index_name != null && index_name.equals(columns_a8)) {
                index_a8 = i;
            } else if (index_name != null && index_name.equals(columns_a9)) {
                index_a9 = i;
            } else if (index_name != null && index_name.equals(columns_a10)) {
                index_a10 = i;
            } else if (index_name != null && index_name.equals(columns_a11)) {
                index_a11 = i;
            } else if (index_name != null && index_name.equals(columns_a12)) {
                index_a12 = i;
            } else if (index_name != null && index_name.equals(columns_a13)) {
                index_a13 = i;
            } else if (index_name != null && index_name.equals(columns_a14)) {
                index_a14 = i;
            } else if (index_name != null && index_name.equals(columns_a15)) {
                index_a15 = i;
            } else if (index_name != null && index_name.equals(columns_a16)) {
                index_a16 = i;
            } else if (index_name != null && index_name.equals(columns_a17)) {
                index_a17 = i;
            } else if (index_name != null && index_name.equals(columns_a18)) {
                index_a18 = i;
            } else if (index_name != null && index_name.equals(columns_a19)) {
                index_a19 = i;
            } else if (index_name != null && index_name.equals(columns_a20)) {
                index_a20 = i;
            }
        }
        List < Gene > list = new ArrayList < Gene > ();
        for (int i = 1; i < rows; i++) {
        	Gene data = new Gene();
            if (index_a1!= -1) {
                if (sheet.getCell(index_a1, i).getContents() != null && sheet.getCell(index_a1, i).getContents().trim().length() > 0) {
                	chip = sheet.getCell(index_a1, i).getContents().trim();
                } else {
                	chip = null;
                }
            }
            if (index_a2!= -1) {
                if (sheet.getCell(index_a2, i).getContents() != null && sheet.getCell(index_a2, i).getContents().length() > 0) {
                	sampleNum = sheet.getCell(index_a2, i).getContents().trim();
                } else {
                	sampleNum = null;
                }
            }
            if (index_a3!= -1) {
                if (sheet.getCell(index_a3, i).getContents().trim() != null && sheet.getCell(index_a3, i).getContents().trim().length() > 0) {
                    geneticMode = sheet.getCell(index_a3, i).getContents().trim();
                } else {
                    geneticMode = null;
                }
            }
            if (index_a4!= -1) {
                if (sheet.getCell(index_a4, i).getContents().trim() != null && sheet.getCell(index_a4, i).getContents().trim().length() > 0) {
                    gene = sheet.getCell(index_a4, i).getContents().trim();
                } else {
                    gene = null;
                }
            }
            if (index_a5!= -1) {
                if (sheet.getCell(index_a5, i).getContents().trim() != null && sheet.getCell(index_a5, i).getContents().trim().length() > 0) {
                    sequence = sheet.getCell(index_a5, i).getContents().trim();
                } else {
                    sequence = null;
                }
            }
            if (index_a6!= -1) {
                if (sheet.getCell(index_a6, i).getContents().trim() != null && sheet.getCell(index_a6, i).getContents().trim().length() > 0) {
                    nucleotide = sheet.getCell(index_a6, i).getContents().trim();
                } else {
                    nucleotide = null;
                }
            }
            if (index_a7!= -1) {
                if (sheet.getCell(index_a7, i).getContents().trim() != null && sheet.getCell(index_a7, i).getContents().trim().length() > 0) {
                    aminophenol = sheet.getCell(index_a7, i).getContents().trim();
                } else {
                    aminophenol = null;
                }
            }
            if (index_a8!= -1) {
                if (sheet.getCell(index_a8, i).getContents().trim() != null && sheet.getCell(index_a8, i).getContents().trim().length() > 0) {
                    geneRegion = sheet.getCell(index_a8, i).getContents().trim();
                } else {
                    geneRegion = null;
                }
            }
            if (index_a9!= -1) {
                if (sheet.getCell(index_a9, i).getContents().trim() != null && sheet.getCell(index_a9, i).getContents().trim().length() > 0) {
                    chromosome = sheet.getCell(index_a9, i).getContents().trim();
                } else {
                    chromosome = null;
                }
            }
            if (index_a10!= -1) {
                if (sheet.getCell(index_a10, i).getContents().trim() != null && sheet.getCell(index_a10, i).getContents().trim().length() > 0) {
                    rsnum = sheet.getCell(index_a10, i).getContents().trim();
                } else {
                    rsnum = null;
                }
            }
            if (index_a11!= -1) {
                if (sheet.getCell(index_a11, i).getContents().trim() != null && sheet.getCell(index_a11, i).getContents().trim().length() > 0) {
                    dbindel = sheet.getCell(index_a11, i).getContents().trim();
                } else {
                    dbindel = null;
                }
            }
            if (index_a12!= -1) {
                if (sheet.getCell(index_a12, i).getContents().trim() != null && sheet.getCell(index_a12, i).getContents().trim().length() > 0) {
                    hapmap = sheet.getCell(index_a12, i).getContents().trim();
                } else {
                    hapmap = null;
                }
            }
            if (index_a13!= -1) {
                if (sheet.getCell(index_a13, i).getContents().trim() != null && sheet.getCell(index_a13, i).getContents().trim().length() > 0) {
                    frequency = sheet.getCell(index_a13, i).getContents().trim();
                } else {
                    frequency = null;
                }
            }
            if (index_a14!= -1) {
                if (sheet.getCell(index_a14, i).getContents().trim() != null && sheet.getCell(index_a14, i).getContents().trim().length() > 0) {
                    localFrequency = sheet.getCell(index_a14, i).getContents().trim();
                } else {
                    localFrequency = null;
                }
            }
            if (index_a15!= -1) {
                if (sheet.getCell(index_a15, i).getContents().trim() != null && sheet.getCell(index_a15, i).getContents().trim().length() > 0) {
                    featureChange = sheet.getCell(index_a15, i).getContents().trim();
                } else {
                    featureChange = null;
                }
            }
            if (index_a16!= -1) {
                if (sheet.getCell(index_a16, i).getContents().trim() != null && sheet.getCell(index_a16, i).getContents().trim().length() > 0) {
                    mutationType = sheet.getCell(index_a16, i).getContents().trim();
                } else {
                    mutationType = null;
                }
            }
            if (index_a17!= -1) {
                if (sheet.getCell(index_a17, i).getContents().trim() != null && sheet.getCell(index_a17, i).getContents().trim().length() > 0) {
                    literature = sheet.getCell(index_a17, i).getContents().trim();
                } else {
                    literature = null;
                }
            }
            if (index_a18!= -1) {
                if (sheet.getCell(index_a18, i).getContents().trim() != null && sheet.getCell(index_a18, i).getContents().trim().length() > 0) {
                    siteRemark = sheet.getCell(index_a18, i).getContents().trim();
                } else {
                    siteRemark = null;
                }
            }
            if (index_a19!= -1) {
                if (sheet.getCell(index_a19, i).getContents().trim() != null && sheet.getCell(index_a19, i).getContents().trim().length() > 0) {
                    remark = sheet.getCell(index_a19, i).getContents().trim();
                } else {
                    remark = null;
                }
            }
            if (index_a20!= -1) {
                if (sheet.getCell(index_a20, i).getContents().trim() != null && sheet.getCell(index_a20, i).getContents().trim().length() > 0) {
                    diseasePhenotype = sheet.getCell(index_a20, i).getContents().trim();
                } else {
                    diseasePhenotype = null;
                }
            }
            data.setSampleNum(sampleNum);
            data.setChip(chip);
            data.setGeneticMode(geneticMode);
            data.setGene(gene);
            data.setSequence(sequence);
            data.setNucleotide(nucleotide);
            data.setAminophenol(aminophenol);
            data.setGeneRegion(geneRegion);
            data.setChromosome(chromosome);
            data.setRsnum(rsnum);
            data.setDbindel(dbindel);
            data.setHapmap(hapmap);
            data.setFrequency(frequency);
            data.setLocalFrequency(localFrequency);
            data.setFeatureChange(featureChange);
            data.setMutationType(mutationType);
            data.setLiterature(literature);
            data.setSiteRemark(siteRemark);
            data.setRemark(remark);
            data.setDiseasePhenotype(diseasePhenotype);
            list.add(data);
        }
        return list;
    }

   
}
