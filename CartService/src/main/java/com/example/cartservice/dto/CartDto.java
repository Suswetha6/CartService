package com.example.cartservice.dto;

import com.example.cartservice.models.product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class CartDto {
    Long id;
    int userId;
    Date date;
    List<product> products;
}
