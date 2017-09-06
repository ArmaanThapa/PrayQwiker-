package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.Cartdao;
import com.qwikr.webapi.domain.Cart;
import com.qwikr.webapi.domain.CartStatus;
import java.io.PrintStream;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCartdao
  implements Cartdao
{
  @Autowired
  SessionFactory session;
  
  public void addCart(Cart cart)
  {
    this.session.getCurrentSession().save(cart);
  }
  
  public Cart getCart(long id)
  {
    return (Cart)this.session.getCurrentSession().get(Cart.class, Long.valueOf(id));
  }
  
  public void deleteCart(Cart cart)
  {
    this.session.getCurrentSession().delete(cart);
  }
  
  public void deleteAllCartItems(long userId, long productId)
  {
    System.out.println("in deleteallCartItems DAO ..");
    
    String hql = "delete from Cart WHERE userId = :uid and productid = :pid";
    Query query = this.session.getCurrentSession().createQuery(hql);
    query.setParameter("uid", Long.valueOf(userId));
    query.setParameter("pid", Long.valueOf(productId));
    int result = query.executeUpdate();
    System.out.println("Deleted Cart Items: " + result);
  }
  
  public void updateCart(Cart cart)
  {
    this.session.getCurrentSession().update(cart);
  }
  
  public List<Cart> getAllCart()
  {
    return this.session.getCurrentSession().createQuery("FROM Cart").list();
  }
  
  public List<Cart> getCartByUIdAndPIdAndStatus(long uId, long pId, CartStatus status)
  {
    return this.session.getCurrentSession().createQuery("from Cart where userId=" + uId + "  and productid=" + pId + " and status='" + status + "'").list();
  }
  
  public List<Cart> getAllCartProduct(long userId)
  {
    return this.session.getCurrentSession().createQuery("from Cart where userId=" + userId).list();
  }
}