package com.example.cartservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class cart {
    Long id;
    int userId;
    Date date;
    List<product> products;

}
