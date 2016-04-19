package com.rbc.tech.excercise.service;

import com.rbc.tech.excercise.domain.Basket;
import com.rbc.tech.excercise.domain.Item;
import com.rbc.tech.excercise.exception.ShoppingBasketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

public class ShoppingBasketServiceImpl implements ShoppingBasketService {

    private static final int PENCE_IN_ONE_POUND = 100;
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingBasketServiceImpl.class);
    private final PricingService pricingService;

    public ShoppingBasketServiceImpl(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public double getBasketTotalCost(Basket<Item> basket) {

        LOGGER.trace("Getting total cost for basket {} ", basket);

        if (basket == null) {
            throw new IllegalArgumentException("Basket is null ");
        }

        try {

            int totalCostInPence = basket.getItems().stream().collect(
                    Collectors.summingInt(item-> item.getQuantity() * pricingService.getItemCostInPence(item.getCode())));

            double totalCostInPounds = (double) totalCostInPence / PENCE_IN_ONE_POUND;
            return totalCostInPounds;

        } catch (Exception e) {
            LOGGER.error("Unable to calculate basket cost", e);
            throw new ShoppingBasketException("Exception occurred in calculating basket cost", e);
        }
    }

}
