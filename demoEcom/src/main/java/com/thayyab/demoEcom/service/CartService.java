package com.thayyab.demoEcom.service;

import com.thayyab.demoEcom.model.Cart;
import com.thayyab.demoEcom.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;
    public List<Cart> getCart() {
        return  cartRepo.findAll();
    }

    public Cart putCart(Cart cartItem) {
        if(cartRepo.existsById(cartItem.getProduct_id())){
            Cart tempcart= cartRepo.findById(cartItem.getProduct_id()).orElse(null);
            Long Quantity= tempcart.getQuantity() ;
            Quantity++;
            cartItem.setQuantity(Quantity);
        }
        else {
            cartItem.setQuantity(1L);
        }
        return cartRepo.save(cartItem);
    }
    public Cart getCartItemById(Long id){
        return cartRepo.findById(id).orElse(null);
    }

    public Cart updateCartItem(Cart cartItem, Long id) {
        cartItem.setProduct_id(id);
        return cartRepo.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartRepo.deleteById(id);
    }
}
