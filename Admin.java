package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin 
{
	
@Id
  private int aid;
  private String apassword;
  
  public Admin()
  {
	  
  }

public Admin(int aid, String apassword) 
{
	super();
	this.aid = aid;
	this.apassword = apassword;
}

public int getAid() 
{
	return aid;
}

public void setAid(int aid) 
{
	this.aid = aid;
}

public String getApassword() 
{
	return apassword;
}

public void setApassword(String apassword) 
{
	this.apassword = apassword;
}

@Override
public String toString() 
{
	return "Admin [aid=" + aid + ", apassword=" + apassword + "]";
}  
}
