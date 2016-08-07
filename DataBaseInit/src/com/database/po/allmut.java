package com.database.po;
 import java.io.Serializable;
import com.database.utils.Page;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class allmut extends Page implements Serializable {

	private String disease    ;
    private String gene       ;
    private String descr      ;
    private String dbsnp      ;
    private String hgvs       ;
    private String refseq     ;
    private String omimid     ;
    private String maffreq    ;
    private String wenxian    ;
    private String gene_hagvs ;
    private String chromosome ;
    private String tag        ;
    private String comments ;
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getGene() {
		return gene;
	}
	public void setGene(String gene) {
		this.gene = gene;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getDbsnp() {
		return dbsnp;
	}
	public void setDbsnp(String dbsnp) {
		this.dbsnp = dbsnp;
	}
	public String getHgvs() {
		return hgvs;
	}
	public void setHgvs(String hgvs) {
		this.hgvs = hgvs;
	}
	public String getRefseq() {
		return refseq;
	}
	public void setRefseq(String refseq) {
		this.refseq = refseq;
	}
	public String getOmimid() {
		return omimid;
	}
	public void setOmimid(String omimid) {
		this.omimid = omimid;
	}
	public String getMaffreq() {
		return maffreq;
	}
	public void setMaffreq(String maffreq) {
		this.maffreq = maffreq;
	}
	public String getWenxian() {
		return wenxian;
	}
	public void setWenxian(String wenxian) {
		this.wenxian = wenxian;
	}
	public String getGene_hagvs() {
		return gene_hagvs;
	}
	public void setGene_hagvs(String gene_hagvs) {
		this.gene_hagvs = gene_hagvs;
	}
	public String getChromosome() {
		return chromosome;
	}
	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
    
    
}
