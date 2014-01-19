package br.edu.ifms.pykota.entidades;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
public class Printers {
	public Printers() {
	}
	
	private int id;
	
	private String printername;
	
	private String description;
	
	private Float priceperpage = new Float(0);
	
	private Float priceperjob = new Float(0);
	
	private String passthrough = "f";
	
	private Integer maxjobsize;
	
	private java.util.Set group = new java.util.HashSet();
	
	private java.util.Set printer = new java.util.HashSet();
	
	private java.util.Set coefficients = new java.util.HashSet();
	
	private java.util.Set grouppquota = new java.util.HashSet();
	
	private java.util.Set userpquota = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPrintername(String value) {
		this.printername = value;
	}
	
	public String getPrintername() {
		return printername;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPriceperpage(float value) {
		setPriceperpage(new Float(value));
	}
	
	public void setPriceperpage(Float value) {
		this.priceperpage = value;
	}
	
	public Float getPriceperpage() {
		return priceperpage;
	}
	
	public void setPriceperjob(float value) {
		setPriceperjob(new Float(value));
	}
	
	public void setPriceperjob(Float value) {
		this.priceperjob = value;
	}
	
	public Float getPriceperjob() {
		return priceperjob;
	}
	
	public void setPassthrough(String value) {
		this.passthrough = value;
	}
	
	public String getPassthrough() {
		return passthrough;
	}
	
	public void setMaxjobsize(int value) {
		setMaxjobsize(new Integer(value));
	}
	
	public void setMaxjobsize(Integer value) {
		this.maxjobsize = value;
	}
	
	public Integer getMaxjobsize() {
		return maxjobsize;
	}
	
	public void setGroup(java.util.Set value) {
		this.group = value;
	}
	
	public java.util.Set getGroup() {
		return group;
	}
	
	
	public void setPrinter(java.util.Set value) {
		this.printer = value;
	}
	
	public java.util.Set getPrinter() {
		return printer;
	}
	
	
	public void setCoefficients(java.util.Set value) {
		this.coefficients = value;
	}
	
	public java.util.Set getCoefficients() {
		return coefficients;
	}
	
	
	public void setGrouppquota(java.util.Set value) {
		this.grouppquota = value;
	}
	
	public java.util.Set getGrouppquota() {
		return grouppquota;
	}
	
	
	public void setUserpquota(java.util.Set value) {
		this.userpquota = value;
	}
	
	public java.util.Set getUserpquota() {
		return userpquota;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
