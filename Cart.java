package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart 
{
	
	@Id
	private int sno;
	private int cid;
	private int pid;
	private String pname;
	private int pquantity;
	private double totalamount;
	private double discount;
	private double payableamount;
	
	public Cart()
	{
		
	}

	public Cart(int sno, int cid, int pid, String pname, int pquantity, double totalamount, double discount, double payableamount) 
	{
		super();
		this.sno = sno;
		this.cid = cid;
		this.pid = pid;
		this.pname = pname;
		this.pquantity = pquantity;
		this.totalamount = totalamount;
		this.discount = discount;
		this.payableamount = payableamount;
	}

	public int getSno() 
	{
		return sno;
	}

	public void setSno(int sno) 
	{
		this.sno = sno;
	}

	public int getCid() 
	{
		return cid;
	}

	public void setCid(int cid) 
	{
		this.cid = cid;
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

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) 
	{
		this.pquantity = pquantity;
	}

	public double getTotalamount() 
	{
		return totalamount;
	}

	public void setTotalamount(double totalamount) 
	{
		this.totalamount = totalamount;
	}

	public double getDiscount() 
	{
		return discount;
	}

	public void setDiscount(double discount) 
	{
		this.discount = discount;
	}

	public double getPayableamount() 
	{
		return payableamount;
	}

	public void setPayableamount(double payableamount) 
	{
		this.payableamount = payableamount;
	}

	@Override
	public String toString() 
	{
		return "Cart [sno=" + sno + ", cid=" + cid + ", pid=" + pid + ", pname=" + pname + ", pquantity=" + pquantity
				+ ", totalamount=" + totalamount + ", discount=" + discount + ", payableamount=" + payableamount + "]";
	}
}
