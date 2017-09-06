package com.qwikr.webapi.service.impl;


import com.qwikr.webapi.dao.Cartdao;
import com.qwikr.webapi.domain.Cart;
import com.qwikr.webapi.domain.CartStatus;
import com.qwikr.webapi.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImp
  implements CartService
{
  @Autowired
  Cartdao dao;
  
  @Transactional
  public void addCart(Cart cart)
  {
    this.dao.addCart(cart);
  }
  
  @Transactional
  public Cart getCart(long id)
  {
    return this.dao.getCart(id);
  }
  
  @Transactional
  public void deleteCart(Cart cart)
  {
    this.dao.deleteCart(cart);
  }
  
  @Transactional
  public void deleteAllCartItems(long userId, long productId)
  {
    this.dao.deleteAllCartItems(userId, productId);
  }
  
  @Transactional
  public void updateCart(Cart cart)
  {
    this.dao.updateCart(cart);
  }
  
  @Transactional
  public List<Cart> getAllCart()
  {
    return this.dao.getAllCart();
  }
  
  @Transactional
  public List<Cart> getCartByUIdAndPIdAndStatus(long uId, long pId, CartStatus status)
  {
    return this.dao.getCartByUIdAndPIdAndStatus(uId, pId, status);
  }
  
  @Transactional
  public List<Cart> getAllCartProduct(long userId)
  {
    return this.dao.getAllCartProduct(userId);
  }
}