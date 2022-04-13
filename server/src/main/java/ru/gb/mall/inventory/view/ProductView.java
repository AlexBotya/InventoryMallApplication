package ru.gb.mall.inventory.view;

import lombok.Getter;
import lombok.Setter;
import ru.gb.mall.inventory.entity.ProductCategory;
import ru.gb.mall.inventory.entity.ProductDiscount;
import ru.gb.mall.inventory.entity.ProductPrice;


import java.util.List;
@Getter
@Setter
public class ProductView {
    private long id;
    private String name;
    private List<ProductCategory> category;
    private ProductPrice price;
    private ProductDiscount discount;

    private String manufacturerName;
    private String manufacturerCountry;
    private int manufacturerZipCode;
}

