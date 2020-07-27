package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;


public class AdminDaoImpl implements IAdminDao
{
private static SessionFactory sessionFactory;
	
	static
	{
		Configuration configuration=new Configuration().configure();
	    sessionFactory=configuration.buildSessionFactory();
	}
	
	
	
	@Override
	public void createAdmin(Admin a) 
	{
		System.out.println(a.getAid()+" "+a.getApassword());
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();	
	}
	
	
	
	
	@Override
	public int adminLogin(int aid, String apassword) 
	{
		int flag=0;
		System.out.println(aid+" "+apassword);
		Session session=sessionFactory.openSession();
	       Query query=session.createQuery("from Admin");
	       List<Admin> list=query.getResultList();
	       for(Admin l : list)
	       { 
	    	   if((aid==(l.getAid())) && (apassword.equals(l.getApassword())))
	    	   {
	    		   System.out.println(l.getAid()+" "+l.getApassword());
	    		   flag=1;
	    		   break;
	    	   }
	       }
	       return flag;
	}
	
	
	
	
	
	@Override
	public int searchProduct(int pid, String pname) 
	{
		System.out.println(pid+" "+pname);
		int flag=0;
		int a=0;
		int b=0;
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
				a=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}	
		Product p1=null;
		Session session1=sessionFactory.openSession();
		Query query1=session.createQuery("from Product where pname=:pname");
		query1.setParameter("pname", pname);
		List<Product> pro=query1.getResultList();
		try 
		{
			p1=pro.get(0);
			System.out.println(p.getPname());
			if(p.getPname().equals(pname))
				b=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}	
		if(a==1 || b==1)
			flag=1;
		return flag;
	}

	

	
	@Override
	public void addProduct(Product p) 
	{
		System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPprice()+" "+p.getPquantity()+" "+p.getPdiscount());
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	
	
	
	@Override
	public List<Product> getProductList() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		return query.getResultList();	
	}
	
	
	

	@Override
	public void addCustomer(Customer c) 
	{
		System.out.println(c.getCid()+" "+c.getCname()+" "+c.getCpassword()+" "+c.getCbalance());
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();	
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
	public void removeCustomer(int cid) 
	{
		  Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  Query query=session.createQuery("delete from Customer where cid=:cid");
		  query.setParameter("cid",cid);
		  query.executeUpdate();
		  session.getTransaction().commit();	
	}

	
	
	
	
	
	@Override
	public List<Customer> getCustomerList() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer");
		return query.getResultList();	
	}




	@Override
	public int searchProd(int pid, String pname) 
	{
		System.out.println(pid+" "+pname);
		int flag=0;
		Product p=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where pid=:pid and pname=:pname");
		query.setParameter("pid", pid);
		query.setParameter("pname", pname);
		List<Product> pro=query.getResultList();
		System.out.println(pro);
		try 
		{
			p=pro.get(0);
			System.out.println(p.getPid()+p.getPname());
			System.out.println(pname);
			System.out.println(p.getPname());
			if(p.getPid()==pid  && pname.equals(p.getPname()))
				flag=1;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();;
		}	
		return flag;
	}




	@Override
	public void addProductQuantity(int pid, int pquantity) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	    Query query=session.createQuery("from Product where pid=:pid");
	    query.setParameter("pid", pid);
		List<Product> list=query.getResultList();
		Product p=list.get(0);
		System.out.println(pquantity);
		System.out.println(p.getPquantity());
		int quantity=p.getPquantity()+pquantity;
		System.out.println(quantity);
		Query query1 = session.createQuery("update Product set pquantity=:quantity where pid=:pid");
		query1.setParameter("pid", pid);
		query1.setParameter("quantity", quantity);
		query1.executeUpdate();
		session.getTransaction().commit();
		session.close();
    }
}
