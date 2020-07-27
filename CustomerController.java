package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.services.CustomerServiceImpl;
import com.dxc.services.ICustomerService;

@Controller
@RequestMapping("/views")
public class CustomerController 
{
	
	ICustomerService custservice=new CustomerServiceImpl();
	String msg =" ";
	
	@RequestMapping("/customerlogin")
	public String customerLogin(@RequestParam int cid, @RequestParam String cpassword, Model m )
	{
		int flag=0;
	    flag=custservice.customerLogin(cid, cpassword);
		if(flag==1)
		{
		    System.out.println("Login successful");
		    return "customermenu";
		}
		else
		{
			msg = "Incorrect login credentials";
			m.addAttribute("msg",msg);
			return "message";
		}
	}
	
	
	
	@RequestMapping("/cdisplayproducts")
	public String getProductList(Model m)
	{
		List<Product> list=custservice.getProductList();
		m.addAttribute("list", list);
		return "cdisplayproducts";
	}
	
	
	@RequestMapping("/addproducts")
	public String addProducts(@RequestParam int cid,@RequestParam int pid, @ModelAttribute Product p, @ModelAttribute Cart c, Model m)
	{
		int flag1=0;
		int flag2=0;
        flag1=custservice.searchProduct(pid);
        if(flag1==1)
        	System.out.println("product available");
        if(flag1==1)
        {
        flag2=custservice.checkQuantity(pid, c.getPquantity());
        }
        else
        {
        msg="Product not available.";
        m.addAttribute("msg", msg);
        return "message";
        }
        if(flag1==1 && flag2==1)
        {
	    custservice.addProducts(cid, pid, p, c);
		msg="Product added to cart.";
		m.addAttribute("msg", msg);
		return "message";
        }
        else
        {
        msg="Product stock not available.";
        m.addAttribute("msg", msg);
        return "message";
        }
	}
	
	
	
	@RequestMapping("/displaycustomercart")
	public String getCartProducts(@RequestParam int cid, Model m)
	{
		List<Cart> list=custservice.getCartProducts(cid);
		m.addAttribute("list", list);
		return "displaycart";
	}	
	
	
	
	
	
	@RequestMapping("/paybill")
	public String payBill(@RequestParam int cid, Model m)
	{
		System.out.println(cid);
		int flag=0;
		flag=custservice.searchCustomer(cid);
		if(flag==1)
		{
		double amount=custservice.generateBill(cid);
		double balance=custservice.getBalance(cid);
		if(balance>=amount)
		{
		custservice.payBill(cid, amount);
		msg="Bill paid successfully.";
		m.addAttribute("msg", msg);
		return "message";
		}
		else
		{
		msg="Insufficient balance in wallet.";
		m.addAttribute("msg", msg);
		return "message";
		}
		}
		else
		{
		msg="Customer account not found.";
		m.addAttribute("msg", msg);
		return "message";
		}
	}
	
	
	
	
	@RequestMapping("/getbalance")
	public String getBalance(@RequestParam int cid, Model m)
	{
		int flag=0;
		flag=custservice.searchCustomer(cid);
		if(flag==1)
		{
		double balance=custservice.getBalance(cid);
		msg="Your wallet balance is =Rs "+balance+"/";
		m.addAttribute("msg", msg);
		return "message";
		}
		else
		{
		msg="Customer account not found.";
		m.addAttribute("msg", msg);
		return "message";
		}
	}
	
	
	
	
	@RequestMapping("/addbalance")
	public String addBalance(@RequestParam int cid, @RequestParam double amount, Model m)
	{
		int flag=0;
		flag=custservice.searchCustomer(cid);
		if(flag==1)
		{
		double balance=custservice.addBalance(cid, amount);
		msg="Your wallet balance is =Rs "+balance+"/";
		m.addAttribute("msg", msg);
		return "message";
		}
		else
		{
		msg="Customer account not found.";
		m.addAttribute("msg", msg);
		return "message";
		}
	}
	
	
	
	
	
	@RequestMapping("/changepassword")
	public String payBill(@RequestParam int cid, @RequestParam String cpassword, @RequestParam String newpassword, @RequestParam String confirmpassword, Model m)
	{
		if(newpassword.equals(confirmpassword))
		{
		int flag=0;
		flag=custservice.customerLogin(cid, cpassword);
		if(flag==1)
		{
		custservice.changePassword(cid, newpassword, confirmpassword);
		msg="Your password has been reset.";
		m.addAttribute("msg", msg);
		return "message";
	    }
		else
		{
		msg="Incorrect login credentials.";
		m.addAttribute("msg", msg);
		return "message";
		}
		}
		else
		{
		msg="Password mismatch.";
		m.addAttribute("msg", msg);
		return "message";
		}
    }
}

