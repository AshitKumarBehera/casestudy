package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class CustomerDaoImpl implements ICustomerDao
{
private static SessionFactory sessionFactory;
	
	static
	{
		Configuration configuration=new Configuration().configure();
	    sessionFactory=configuration.buildSessionFactory();
	}
	
	

	@Override
	public int customerLogin(int cid, String cpassword) 
	{
		int flag=0;
		System.out.println(cid+" "+cpassword);
		Session session=sessionFactory.openSession();
	       Query query=session.createQuery("from Customer");
	       List<Customer> list=query.getResultList();
	       for(Customer l : list)
	       { 
	    	   if(cid==(l.getCid()) && cpassword.equals(l.getCpassword()))
	    	   {
	    		   System.out.println(l.getCid()+" "+l.getCpassword());
	    		   flag=1;
	    		   break;
	    	   }
	       }
		return flag;
	}
	
	
	
	
	@Override
	public List<Product> getProductList() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		return query.getResultList();
	}
	
	
	
	
	@Override
	public int searchProduct(int pid) 
	{
		System.out.println(pid);
		int flag1=0;
		Product p=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		List<Product> pr=query.getResultList();
		try 
		{
			p=pr.get(0);
			System.out.println(p.getPid());
			if(p.getPid()==pid)
				flag1=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}	
		return flag1;
	}



	@Override
	public int checkQuantity(int pid, int pquantity) 
	{
		System.out.println(pid+" "+pquantity);
		int flag2=0;
		Product p=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		List<Product> pr=query.getResultList();
		try 
		{
			p=pr.get(0);
			System.out.println(p.getPid());
			if((p.getPid()==pid) && (p.getPquantity()>=pquantity) )
				flag2=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}	
		return flag2;
	}



	@Override
	public void addProducts(int cid, int pid, Product p, Cart c) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		List<Product> list=query.getResultList();
		System.out.println(list);
		Product p1=list.get(0);
		double totalamount=c.getPquantity()*p1.getPprice();
		double payableamount=((100-p1.getPdiscount())*totalamount)/100;
		double discount=totalamount-payableamount;
	    	
		c.setSno(c.getSno());
		c.setCid(cid);
		c.setPid(pid);
		c.setPname(p1.getPname());
		c.setPquantity(c.getPquantity());
		c.setTotalamount(totalamount);
		c.setDiscount(discount);
		c.setPayableamount(payableamount);
		
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		session1.save(c);
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		Query query1=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		List<Product> list1=query.getResultList();
		Product p2=list1.get(0);
		int pquantity=p2.getPquantity()-c.getPquantity();
		System.out.println(p2.getPquantity());
		System.out.println(c.getPquantity());
		System.out.println(pquantity);
		Query query2 = session.createQuery("update Product set pquantity=:pquantity where pid=:pid");
		query2.setParameter("pid", pid);
		query2.setParameter("pquantity", pquantity);
		query2.executeUpdate();
		session.getTransaction().commit();
		session1.getTransaction().commit();
		session2.getTransaction().commit();
		session.close();
		session1.close();
		session2.close();
	}




	@Override
	public List<Cart> getCartProducts(int cid) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where cid=:cid");
		query.setParameter("cid", cid);
		return query.getResultList();
	}




	@Override
	public double addBalance(int cid, double amount) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	    Query query=session.createQuery("from Customer where cid=:cid");
	    query.setParameter("cid", cid);
		List<Customer> list=query.getResultList();
		Customer c=list.get(0);
		System.out.println(c.getCbalance());
		System.out.println(amount);
		double balance=c.getCbalance()+amount;
		System.out.println(balance);
		Query query1 = session.createQuery("update Customer set cbalance=:balance where cid=:cid");
		query1.setParameter("cid", cid);
		query1.setParameter("balance", balance);
		query1.executeUpdate();
		session.getTransaction().commit();
		session.close();
	    return balance;
	}




	@Override
	public int searchCustomer(int cid) 
	{
		System.out.println(cid);
		int flag=0;
		Customer c=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer where cid=:cid");
		query.setParameter("cid", cid);
		List<Customer> cust=query.getResultList();
		try 
		{
			c=cust.get(0);
			System.out.println(c.getCid());
			if(c.getCid()==cid)
				flag=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}	
		return flag;
	}




	@Override
	public double getBalance(int cid) 
	{
		System.out.println(cid);
		double balance=0.0;
		Customer c=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer where cid=:cid");
		query.setParameter("cid", cid);
		List<Customer> cust=query.getResultList();
		c=cust.get(0);
		balance=c.getCbalance();
		System.out.println(balance);
		session.close();
		return balance;
	}




	@Override
	public void changePassword(int cid, String newpassword, String confirmpassword) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	    Query query=session.createQuery("from Customer where cid=:cid");
	    query.setParameter("cid", cid);
		List<Customer> list=query.getResultList();
		Customer c=list.get(0);
		System.out.println(c.getCpassword());
		Query query1 = session.createQuery("update Customer set cpassword=:newpassword where cid=:cid");
		query1.setParameter("cid", cid);
		query1.setParameter("newpassword", newpassword);
		query1.executeUpdate();
		session.getTransaction().commit();
		session.close(); 
	}




	@Override
	public double generateBill(int cid) 
	{
		double amount=0.0;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Cart where cid=:cid");
		query.setParameter("cid", cid);
		
		List<Cart> list = query.getResultList();
		for(Cart c:list) 
		{
		 amount=amount+c.getPayableamount();
		}
		System.out.println(amount);
		session.getTransaction().commit();
		session.close();
		return amount;
	}




	@Override
	public void payBill(int cid, double amount) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	    Query query=session.createQuery("from Customer where cid=:cid");
	    query.setParameter("cid", cid);
		List<Customer> list=query.getResultList();
		Customer c=list.get(0);
		System.out.println(c.getCbalance());
		System.out.println(amount);
		double balance=c.getCbalance()-amount;
		System.out.println(balance);
		Query query1 = session.createQuery("update Customer set cbalance=:balance where cid=:cid");
		query1.setParameter("cid", cid);
		query1.setParameter("balance", balance);
		query1.executeUpdate();
		session.getTransaction().commit();
		session.close();
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
        Query query2=session1.createQuery("delete from Cart where cid=:cid");
	    query2.setParameter("cid",cid);
	    query2.executeUpdate();
        session1.getTransaction().commit();
		session1.close();
	}
}
