package com.rbc.tech.excercise.service;

import com.rbc.tech.excercise.domain.Basket;
import com.rbc.tech.excercise.domain.Item;

public interface ShoppingBasketService {

    double getBasketTotalCost(Basket<Item> basket);
}
