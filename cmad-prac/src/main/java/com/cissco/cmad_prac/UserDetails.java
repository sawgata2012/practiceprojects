package com.cissco.cmad_prac;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	String uid;
	String usname;
	String usrtitle;
	String usaddress;
	String usphone;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsrtitle() {
		return usrtitle;
	}
	public void setUsrtitle(String usrtitle) {
		this.usrtitle = usrtitle;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getUsphone() {
		return usphone;
	}
	public void setUsphone(String usphone) {
		this.usphone = usphone;
	}
	public String getUsaddress() {
		return usaddress;
	}
	public void setUsaddress(String usaddress) {
		this.usaddress = usaddress;
	}
	
	
    public String toString(){
    	return this.getUsname() +" "+this.getUsaddress()+" "+this.getUsphone()+" "+this.getUsrtitle();
    }
}
