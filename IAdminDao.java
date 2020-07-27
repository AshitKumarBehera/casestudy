package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public interface IAdminDao 
{
	public void createAdmin(Admin a);
	
	public int adminLogin(int aid, String apassword);
	
	public int searchProduct(int pid, String pname);
	
	public void addProduct(Product p);
	
	public List<Product> getProductList();
	
	public void addCustomer(Customer c);
	
	public int searchCustomer(int cid);
	
	public List<Customer> getCustomerList();

	public void removeCustomer(int cid);
	
	public int searchProd(int pid, String pname);
	
	public void addProductQuantity(int pid, int pquantity);
	
	}
