package com.thayyab.demoEcom.controller;

import com.thayyab.demoEcom.model.Cart;
import com.thayyab.demoEcom.repo.CartRepo;
import com.thayyab.demoEcom.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:3000")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping()
    public List<Cart> getCart(){
            return cartService.getCart();
    }

    @PostMapping("/create")
    public  Cart  putCartItem(@RequestBody Cart cartItem){
        return cartService.putCart(cartItem);
    }
    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Long id){
         cartService.deleteCartItem(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCartItem(@RequestBody Cart cartItem,@PathVariable Long id ){

        Cart tempCartItem=cartService.getCartItemById(id);
         if(tempCartItem!=null){
             tempCartItem= cartService.updateCartItem(cartItem,id);
             return new ResponseEntity<>(tempCartItem, HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
}
