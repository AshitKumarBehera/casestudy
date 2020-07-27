package com.dxc.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer 
{
	
@Id
 private int cid;
 private String cname;
 private String cpassword;
 private double cbalance;
 
 @ManyToMany
 List<Product> plist=new ArrayList<>();
 
 public Customer()
 {
	 
 }

public Customer(int cid, String cname, String cpassword, double cbalance) 
{
	super();
	this.cid = cid;
	this.cname = cname;
	this.cpassword = cpassword;
	this.cbalance = cbalance;
}

public int getCid() 
{
	return cid;
}

public void setCid(int cid) 
{
	this.cid = cid;
}

public String getCname() 
{
	return cname;
}

public void setCname(String cname) 
{
	this.cname = cname;
}

public String getCpassword() 
{
	return cpassword;
}

public void setCpassword(String cpassword) 
{
	this.cpassword = cpassword;
}

public double getCbalance() 
{
	return cbalance;
}

public void setCbalance(double cbalance) 
{
	this.cbalance = cbalance;
}


public List<Product> getPlist() 
{
	return plist;
}

public void setPlist(List<Product> plist) 
{
	this.plist = plist;
}

@Override
public String toString() 
{
	return "Customer [cid=" + cid + ", cname=" + cname + ", cpassword=" + cpassword + ", cbalance=" + cbalance + "]";
}
}