package com.dxc.services;

import java.util.List;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public interface IAdminService
{
	public void createAdmin(Admin a);	
	
	public int adminLogin(int aid, String apassword);
	
	public int searchProduct(int pid, String pname);
	
	public void addProduct(Product p);
	
	public List<Product> getProductList();
	
	public void addCustomer(Customer c);
	
	public int searchCustomer(int cid);
	
    public void removeCustomer(int cid);
	
	public List<Customer> getCustomerList();
	
	public int searchProd(int pid, String pname);
	
	public void addProductQuantity(int pid, int pquantity);

	
	}
