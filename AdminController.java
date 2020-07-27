package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.services.AdminServiceImpl;
import com.dxc.services.IAdminService;


	@Controller
	@RequestMapping("/views")
	public class AdminController 
	{
		
		IAdminService admservice=new AdminServiceImpl();
		String msg =" ";
		
		@RequestMapping("/create")
		public String createAdmin(@ModelAttribute Admin a, Model m)
		{
			System.out.println("method create");
			admservice.createAdmin(a);
			msg="Admin created successfully.";
			m.addAttribute("msg", msg);
			return "message";
		}
		
		@RequestMapping("/adminlogin")
		public String adminLogin(@RequestParam int aid, @RequestParam String apassword, Model m )
		{
			int flag=0;
		    flag=admservice.adminLogin(aid, apassword);
			if(flag==1)
			{
			System.out.println("Login successful");
			return "adminmenu";
			}
			else
			{
				msg = "Incorrect login credentials";
				m.addAttribute("msg",msg);
				return "message";
			}
		}
		
		@RequestMapping("/addproduct")
		public String addProduct(@RequestParam int pid,@RequestParam String pname, @ModelAttribute Product p, Model m)
		{
			int flag=0;
			flag=admservice.searchProduct(pid, pname);
			if(flag==1)
			{
			msg="Product id repeated or product already exists.";
			m.addAttribute("msg", msg);
			return "message";
			}
			else
			{
			admservice.addProduct(p);
			msg="Product added to list.";
			m.addAttribute("msg", msg);
			return "message";
			}
		}
		
		
		
		
		@RequestMapping("/addproductquantity")
		public String addProductQuantity(@RequestParam int pid, @RequestParam String pname, @RequestParam int pquantity, Model m)
		{
			int flag=0;
			flag=admservice.searchProd(pid, pname);
			if(flag==1) 
			{
				admservice.addProductQuantity(pid, pquantity);
				msg="Product quantity added.";
				m.addAttribute("msg", msg);
				return "message";	
			}
			else
			{
				msg="Product with matching parameters not available.";
				m.addAttribute("msg", msg);
				return "message";
			}
		}
		
		
		
		@RequestMapping("/adisplayproducts")
		public String getProductList(Model m)
		{
			List<Product> list=admservice.getProductList();
			m.addAttribute("list", list);
			return "adisplayproducts";
		}
		
		
		@RequestMapping("/addcustomer")
		public String addCustomer(@ModelAttribute Customer c, Model m)
		{
			admservice.addCustomer(c);
			msg="Customer added successfully.";
			m.addAttribute("msg", msg);
			return "message";
		}
		
		@RequestMapping("/searchcustomer")
		public String searchCustomer(@RequestParam int cid, Model m)
		{
		    int flag=0;
			flag=admservice.searchCustomer(cid);
			String msg;
			if(flag==1)
			{
				msg="Customer account found.";
				m.addAttribute("msg", msg);
				return "message";	
			}
			else 
			{
				msg="Customer not found.";
				m.addAttribute("msg", msg);
				return "message";
			}
		}
		
		
	    @RequestMapping("/removecustomer")
		public String removeCustomer(@RequestParam int cid, Model m)
		{
	    	int flag=0;
			flag=admservice.searchCustomer(cid);
			String msg;
			if(flag==1)
			{
			   admservice.removeCustomer(cid);
			   msg="Customer removed successfully.";
			   m.addAttribute("msg",msg);
			}
			else
			{
				msg="Customer not found.";
				m.addAttribute("msg", msg);
			}
			return "message";
		}
		
		
		@RequestMapping("/displaycustomers")
		public String getCustomerList(Model m)
		{
			List<Customer> list=admservice.getCustomerList();
			m.addAttribute("list", list);
			return "displaycustomers";
		}
}
