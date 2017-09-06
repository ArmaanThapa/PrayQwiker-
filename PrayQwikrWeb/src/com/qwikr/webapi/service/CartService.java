package com.qwikr.webapi.service;

import com.qwikr.webapi.domain.Cart;
import com.qwikr.webapi.domain.CartStatus;
import java.util.List;

public abstract interface CartService
{
  public abstract void addCart(Cart paramCart);
  
  public abstract Cart getCart(long paramLong);
  
  public abstract void deleteCart(Cart paramCart);
  
  public abstract void updateCart(Cart paramCart);
  
  public abstract List<Cart> getAllCart();
  
  public abstract List<Cart> getCartByUIdAndPIdAndStatus(long paramLong1, long paramLong2, CartStatus paramCartStatus);
  
  public abstract List<Cart> getAllCartProduct(long paramLong);
  
  public abstract void deleteAllCartItems(long paramLong1, long paramLong2);
}
