package com.example.cartservice.controllers;

import com.example.cartservice.dto.CartDto;
import com.example.cartservice.models.cart;
import com.example.cartservice.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CartController {
    private CartService cartService;
    public CartController(CartService cartService){this.cartService = cartService;}

    @GetMapping("/carts/{id}")
    public CartDto getSingleCart (@PathVariable("id")Long id) {
        return cartService.getSingleCart(id);
    }

    @GetMapping("/carts")
    public CartDto[] getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/carts/user/{id}")
    public CartDto[] getAllUserCarts(@PathVariable("id")Long id){
        return cartService.getUserCart(id);
    }
    @PostMapping("/carts/")
   public CartDto postCart(@RequestBody CartDto a){
        return cartService.postCart(a);
    }

    @DeleteMapping("/carts/{id}")
    public CartDto deleteCart(@PathVariable("id")Long id){
        return CartService.deleteCart(id);
    }

}
