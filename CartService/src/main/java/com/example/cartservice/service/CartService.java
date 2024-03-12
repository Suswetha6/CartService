package com.example.cartservice.service;

import com.example.cartservice.dto.CartDto;
import com.example.cartservice.models.cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service

public class CartService {
    private static RestTemplate restTemplate = new RestTemplate();

    public static CartDto getSingleCart(Long id) {
        CartDto cartDto = restTemplate.getForObject("https://fakestoreapi.com/carts/" + id, CartDto.class);
        return cartDto;

    }

    public CartDto[] getAllCarts() {
        ResponseEntity<CartDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts/", CartDto[].class);
        CartDto[] allcarts = response.getBody();
        return allcarts;
    }

//    public CartDto updateCart(Long id){
//        CartDto newCart = restTemplate.patchForObject("https://fakestoreapi.com/carts/"+id,)
//    }

    public CartDto[] getUserCart(Long id) {
        ResponseEntity<CartDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts/user/" + id, CartDto[].class);
        CartDto[] allUserCarts = response.getBody();
        return allUserCarts;
    }

    public CartDto postCart(CartDto a){
        CartDto newCart = new CartDto();
        newCart.setId(a.getId());
        newCart.setUserId(a.getUserId());
        newCart.setProducts(a.getProducts());
        newCart.setDate(a.getDate());
        restTemplate.postForObject("https://fakestoreapi.com/carts/",newCart,CartDto.class);
        return a;
    }

    public static CartDto deleteCart(Long id){
        CartDto delCart=getSingleCart(id);
        restTemplate.delete("https://fakestoreapi.com/carts/user/" + id);
        return delCart;
    }

}
