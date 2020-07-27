package com.dxc.services;


import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class AdminServiceImpl implements IAdminService
{
 AdminDaoImpl admindao=new AdminDaoImpl();
 
 
 @Override
 public void createAdmin(Admin a) 
 {
	 System.out.println("service method create");
     admindao.createAdmin(a);	
 }
 
 
 
 @Override
 public int adminLogin(int aid, String apassword) 
 {
 	return admindao.adminLogin(aid, apassword);
 }
 
 
 
 
 @Override
 public int searchProduct(int pid, String pname) 
 {
 	return admindao.searchProduct(pid, pname);
 }


 
 
@Override
public void addProduct(Product p) 
{
    admindao.addProduct(p);	
}


@Override
public List<Product> getProductList() 
{	
    return admindao.getProductList();
}



@Override
public void addCustomer(Customer c) 
{
	admindao.addCustomer(c);	
}



@Override
public int searchCustomer(int cid) 
{	
    return admindao.searchCustomer(cid);
}




@Override
public void removeCustomer(int cid) 
{
     admindao.removeCustomer(cid);
}




@Override
public List<Customer> getCustomerList() 
{
     return admindao.getCustomerList();
}



@Override
public int searchProd(int pid, String pname) 
{
	return admindao.searchProd(pid, pname);
}



@Override
public void addProductQuantity(int pid, int pquantity) 
{
	admindao.addProductQuantity(pid, pquantity);
}
}
