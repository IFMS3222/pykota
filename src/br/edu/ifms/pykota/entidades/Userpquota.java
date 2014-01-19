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
public class Userpquota {
	public Userpquota() {
	}
	
	private long id;
	
	private Users user;
	
	private Printers printer;
	
	private Integer lifepagecounter = new Integer(0);
	
	private Integer pagecounter = new Integer(0);
	
	private Integer softlimit;
	
	private Integer hardlimit;
	
	private java.sql.Timestamp datelimit;
	
	private Integer maxjobsize;
	
	private Integer warncount = new Integer(0);
	
	private java.util.Set jobhistory = new java.util.HashSet();
	
	private void setId(long value) {
		this.id = value;
	}
	
	public long getId() {
		return id;
	}
	
	public long getORMID() {
		return getId();
	}
	
	public void setLifepagecounter(int value) {
		setLifepagecounter(new Integer(value));
	}
	
	public void setLifepagecounter(Integer value) {
		this.lifepagecounter = value;
	}
	
	public Integer getLifepagecounter() {
		return lifepagecounter;
	}
	
	public void setPagecounter(int value) {
		setPagecounter(new Integer(value));
	}
	
	public void setPagecounter(Integer value) {
		this.pagecounter = value;
	}
	
	public Integer getPagecounter() {
		return pagecounter;
	}
	
	public void setSoftlimit(int value) {
		setSoftlimit(new Integer(value));
	}
	
	public void setSoftlimit(Integer value) {
		this.softlimit = value;
	}
	
	public Integer getSoftlimit() {
		return softlimit;
	}
	
	public void setHardlimit(int value) {
		setHardlimit(new Integer(value));
	}
	
	public void setHardlimit(Integer value) {
		this.hardlimit = value;
	}
	
	public Integer getHardlimit() {
		return hardlimit;
	}
	
	public void setDatelimit(java.sql.Timestamp value) {
		this.datelimit = value;
	}
	
	public java.sql.Timestamp getDatelimit() {
		return datelimit;
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
	
	public void setWarncount(int value) {
		setWarncount(new Integer(value));
	}
	
	public void setWarncount(Integer value) {
		this.warncount = value;
	}
	
	public Integer getWarncount() {
		return warncount;
	}
	
	public void setUser(Users value) {
		this.user = value;
	}
	
	public Users getUser() {
		return user;
	}
	
	public void setPrinter(Printers value) {
		this.printer = value;
	}
	
	public Printers getPrinter() {
		return printer;
	}
	
	public void setJobhistory(java.util.Set value) {
		this.jobhistory = value;
	}
	
	public java.util.Set getJobhistory() {
		return jobhistory;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
