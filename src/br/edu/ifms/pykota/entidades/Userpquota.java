package br.edu.ifms.pykota.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Userpquota {
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
	
	public Userpquota() {
	}
	
	private void setId(long value) {
		this.id = value;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}
	
	public void setUser(Users value) {
		this.user = value;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Users getUser() {
		return user;
	}
	
	public void setPrinter(Printers value) {
		this.printer = value;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Printers getPrinter() {
		return printer;
	}
	
	public void setLifepagecounter(int value) {
		setLifepagecounter(new Integer(value));
	}
	
	public void setLifepagecounter(Integer value) {
		this.lifepagecounter = value;
	}
	
	@Column(name = "lifepagecounter")
	public Integer getLifepagecounter() {
		return lifepagecounter;
	}
	
	public void setPagecounter(int value) {
		setPagecounter(new Integer(value));
	}
	
	public void setPagecounter(Integer value) {
		this.pagecounter = value;
	}
	
	@Column(name = "pagecounter")
	public Integer getPagecounter() {
		return pagecounter;
	}
	
	public void setSoftlimit(int value) {
		setSoftlimit(new Integer(value));
	}
	
	public void setSoftlimit(Integer value) {
		this.softlimit = value;
	}
	
	@Column(name = "softlimit")
	public Integer getSoftlimit() {
		return softlimit;
	}
	
	public void setHardlimit(int value) {
		setHardlimit(new Integer(value));
	}
	
	public void setHardlimit(Integer value) {
		this.hardlimit = value;
	}
	
	@Column(name = "hardlimit")
	public Integer getHardlimit() {
		return hardlimit;
	}
	
	public void setDatelimit(java.sql.Timestamp value) {
		this.datelimit = value;
	}
	
	@Column(name = "datelimit")
	public java.sql.Timestamp getDatelimit() {
		return datelimit;
	}
	
	public void setMaxjobsize(int value) {
		setMaxjobsize(new Integer(value));
	}
	
	public void setMaxjobsize(Integer value) {
		this.maxjobsize = value;
	}
	
	@Column(name = "maxjobsize")
	public Integer getMaxjobsize() {
		return maxjobsize;
	}
	
	public void setWarncount(int value) {
		setWarncount(new Integer(value));
	}
	
	public void setWarncount(Integer value) {
		this.warncount = value;
	}
	
	@Column(name = "warncount")
	public Integer getWarncount() {
		return warncount;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
}
