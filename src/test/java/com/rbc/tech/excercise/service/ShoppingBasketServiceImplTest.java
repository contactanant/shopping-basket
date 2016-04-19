package com.rbc.tech.excercise.service;

import com.rbc.tech.excercise.domain.Basket;
import com.rbc.tech.excercise.domain.Fruit;
import com.rbc.tech.excercise.domain.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.rbc.tech.excercise.domain.Fruit.*;
import static com.rbc.tech.excercise.domain.Item.createItem;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingBasketServiceImplTest {

    @Mock
    private PricingService pricingService;

    private ShoppingBasketService shoppingBasketService;

    @Before
    public void setUp() throws Exception {
        shoppingBasketService = new ShoppingBasketServiceImpl(pricingService);

        // initialize prices
        when(pricingService.getItemCostInPence(Fruit.APPLE.getCode())).thenReturn(50);
        when(pricingService.getItemCostInPence(Fruit.BANANA.getCode())).thenReturn(20);
        when(pricingService.getItemCostInPence(Fruit.ORANGE.getCode())).thenReturn(30);
        when(pricingService.getItemCostInPence(Fruit.LEMON.getCode())).thenReturn(10);
        when(pricingService.getItemCostInPence(Fruit.PEACHES.getCode())).thenReturn(40);
    }

    @Test
    public void shouldReturnCorrectTotalCostForGivenBasket() throws Exception {

        // given
        Basket<Item> basket = new Basket<>();
        basket.add(createItem(APPLE));
        basket.add(createItem(BANANA));
        basket.add(createItem(ORANGE));
        basket.add(createItem(LEMON));
        basket.add(createItem(PEACHES));

        // when
        double basketTotalCostInPounds = shoppingBasketService.getBasketTotalCost(basket);

        // then
        assertThat(basketTotalCostInPounds, equalTo(1.50));
    }

    @Test
    public void shouldReturnCorrectTotalCostWhenBasketHasMoreThanOneItemsOfSameType() throws Exception {

        // given
        Basket<Item> basket = new Basket<>();
        basket.add(createItem(APPLE, 2));
        basket.add(createItem(BANANA));

        // when
        double basketTotalCostInPounds = shoppingBasketService.getBasketTotalCost(basket);

        // then
        assertThat(basketTotalCostInPounds, equalTo(1.20));
    }

    @Test
    public void shouldReturnZeroCostWhenNoItemInBasket() throws Exception {
        // given
        Basket<Item> basket = new Basket<>();

        // when
        double basketTotalCostInPounds = shoppingBasketService.getBasketTotalCost(basket);

        // then
        assertThat(basketTotalCostInPounds, equalTo(0.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasketIsNull() throws Exception {

        shoppingBasketService.getBasketTotalCost(null);
    }

}