package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Cart;
import com.dxc.pojos.Product;

public interface ICustomerDao 
{
	public int customerLogin(int cid, String cpassword);
	
	public List<Product> getProductList();
	
	public int searchProduct(int pid);
	
	public int checkQuantity(int pid, int pquantity);
	
	public void addProducts(int cid, int pid, Product p, Cart c);
	
	public List<Cart> getCartProducts(int cid);
	
	public double addBalance(int cid, double amount);
	
	public int searchCustomer(int cid);
	
	public double getBalance(int cid);
	
	public void changePassword(int cid, String newpassword, String confirmpassword);
	
	public double generateBill(int cid);
	
	public void payBill(int cid, double amount);
}
