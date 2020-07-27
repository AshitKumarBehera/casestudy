package com.dxc.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product 
{
	

@Id
private int pid;
private String pname;
private double pprice;
private int pquantity;
private double pdiscount;

@ManyToMany
List<Customer> clist=new ArrayList<>();

public Product()
{
	
}

public Product(int pid, String pname, double pprice, int pquantity, double pdiscount) 
{
	super();
	this.pid = pid;
	this.pname = pname;
	this.pprice = pprice;
	this.pquantity = pquantity;
	this.pdiscount = pdiscount;
}

public int getPid() 
{
	return pid;
}

public void setPid(int pid) 
{
	this.pid = pid;
}

public String getPname() 
{
	return pname;
}

public void setPname(String pname) 
{
	this.pname = pname;
}

public double getPprice() 
{
	return pprice;
}

public void setPprice(double pprice) 
{
	this.pprice = pprice;
}

public int getPquantity() 
{
	return pquantity;
}

public void setPquantity(int pquantity) 
{
	this.pquantity = pquantity;
}

public double getPdiscount() 
{
	return pdiscount;
}

public void setPdiscount(double pdiscount) 
{
	this.pdiscount = pdiscount;
}


public List<Customer> getClist() 
{
	return clist;
}

public void setClist(List<Customer> clist) 
{
	this.clist = clist;
}

@Override
public String toString() 
{
	return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pquantity=" + pquantity
			+ ", pdiscount=" + pdiscount + "]";
}
}
