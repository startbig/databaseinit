package com.database.po;
 import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Gene extends Page implements Serializable {

	/****/
	private String id;

	/**疾病/OMIM号/遗传方式**/
	private String geneticMode;

	/**基因**/
	private String gene;

	/**参考序列/转录本**/
	private String sequence;

	/**核苷酸变化**/
	private String nucleotide;

	/**氨基酸变化**/
	private String aminophenol;

	/**基因亚区**/
	private String geneRegion;

	/**染色体位置**/
	private String chromosome;

	/**rs号**/
	private String rsnum;

	/**dbINDEL频率***/
	private String dbindel;

	/**Hapmap频率***/
	private String hapmap;

	/**千人频率***/
	private String frequency;

	/**本地频率***/
	private String localFrequency;

	/**功能改变**/
	private String featureChange;

	/**突变类型**/
	private String mutationType;

	/**参考文献**/
	private String literature;

	/**位点说明**/
	private String siteRemark;

	/**备注**/
	private String remark;

	/**疾病表型**/
	private String diseasePhenotype;

	/**状态**/
	private String status;

	/**创建人**/
	private String createUser;

	/**创建时间**/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	private Date createTime;

   private String sampleNum;
   private String chip;
   private List<GeneChip> listChip;
   private List<GeneSample> listSample;
   private String updateUser;
   private String  updateReason;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setGeneticMode(String geneticMode){
		this.geneticMode = geneticMode;
	}

	public String getGeneticMode(){
		return this.geneticMode;
	}

	public void setGene(String gene){
		this.gene = gene;
	}

	public String getGene(){
		return this.gene;
	}

	public void setSequence(String sequence){
		this.sequence = sequence;
	}

	public String getSequence(){
		return this.sequence;
	}

	public void setNucleotide(String nucleotide){
		this.nucleotide = nucleotide;
	}

	public String getNucleotide(){
		return this.nucleotide;
	}

	public void setAminophenol(String aminophenol){
		this.aminophenol = aminophenol;
	}

	public String getAminophenol(){
		return this.aminophenol;
	}

	public void setGeneRegion(String geneRegion){
		this.geneRegion = geneRegion;
	}

	public String getGeneRegion(){
		return this.geneRegion;
	}

	public void setChromosome(String chromosome){
		this.chromosome = chromosome;
	}

	public String getChromosome(){
		return this.chromosome;
	}

	public void setRsnum(String rsnum){
		this.rsnum = rsnum;
	}

	public String getRsnum(){
		return this.rsnum;
	}

	public void setDbindel(String dbindel){
		this.dbindel = dbindel;
	}

	public String getDbindel(){
		return this.dbindel;
	}

	public void setHapmap(String hapmap){
		this.hapmap = hapmap;
	}

	public String getHapmap(){
		return this.hapmap;
	}

	public void setFrequency(String frequency){
		this.frequency = frequency;
	}

	public String getFrequency(){
		return this.frequency;
	}

	public void setLocalFrequency(String localFrequency){
		this.localFrequency = localFrequency;
	}

	public String getLocalFrequency(){
		return this.localFrequency;
	}

	public void setFeatureChange(String featureChange){
		this.featureChange = featureChange;
	}

	public String getFeatureChange(){
		return this.featureChange;
	}

	public void setMutationType(String mutationType){
		this.mutationType = mutationType;
	}

	public String getMutationType(){
		return this.mutationType;
	}

	public void setLiterature(String literature){
		this.literature = literature;
	}

	public String getLiterature(){
		return this.literature;
	}

	public void setSiteRemark(String siteRemark){
		this.siteRemark = siteRemark;
	}

	public String getSiteRemark(){
		return this.siteRemark;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setDiseasePhenotype(String diseasePhenotype){
		this.diseasePhenotype = diseasePhenotype;
	}

	public String getDiseasePhenotype(){
		return this.diseasePhenotype;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return this.status;
	}

	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}

	public String getCreateUser(){
		return this.createUser;
	}

//	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSampleNum() {
		return sampleNum;
	}

	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public List<GeneChip> getListChip() {
		return listChip;
	}

	public void setListChip(List<GeneChip> listChip) {
		this.listChip = listChip;
	}

	public List<GeneSample> getListSample() {
		return listSample;
	}

	public void setListSample(List<GeneSample> listSample) {
		this.listSample = listSample;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateReason() {
		return updateReason;
	}

	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
	}

}
