package com.dxc.services;

import java.util.List;

import com.dxc.dao.CustomerDaoImpl;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Product;

public class CustomerServiceImpl implements ICustomerService
{
	 CustomerDaoImpl customerdao=new CustomerDaoImpl();

	 
	@Override
	public int customerLogin(int cid, String cpassword) 
	{
		return customerdao.customerLogin(cid, cpassword);
	}
	
	
	
	@Override
	public List<Product> getProductList() 
	{
		return customerdao.getProductList();
	}

	
	@Override
	public int searchProduct(int pid) 
	{
		return customerdao.searchProduct(pid);
	}

	
	@Override
	public int checkQuantity(int pid, int pquantity) 
	{
		return customerdao.checkQuantity(pid, pquantity);
	}


	@Override
	public void addProducts(int cid, int pid, Product p, Cart c) 
	{
	    customerdao.addProducts(cid, pid, p, c);	
	}



	@Override
	public List<Cart> getCartProducts(int cid) 
	{
		return customerdao.getCartProducts(cid);
	}



	@Override
	public double addBalance(int cid, double amount) 
	{
		return customerdao.addBalance(cid, amount);
	}



	@Override
	public int searchCustomer(int cid) 
	{
		return customerdao.searchCustomer(cid);
	}



	@Override
	public double getBalance(int cid) 
	{
		return customerdao.getBalance(cid);
	}



	@Override
	public void changePassword(int cid, String newpassword, String confirmpassword) 
	{
		customerdao.changePassword(cid, newpassword, confirmpassword);	
	}



	@Override
	public double generateBill(int cid) 
	{
		return customerdao.generateBill(cid);
	}



	@Override
	public void payBill(int cid, double amount) 
	{
		customerdao.payBill(cid, amount);
		
	}
}
