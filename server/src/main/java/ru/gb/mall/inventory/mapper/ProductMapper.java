package com.geekbrains.mapstructtest.mapper;


import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gb.mall.inventory.entity.Product;
import ru.gb.mall.inventory.entity.ProductManufacturer;
import ru.gb.mall.inventory.service.IdSupplier;
import ru.gb.mall.inventory.view.ProductView;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring"
)
public abstract class ProductMapper {

    @Autowired
    private IdSupplier idSupplier;

    public  abstract Product mapView(ProductView productView);

    public  abstract ProductView mapDto(Product product);

    @AfterMapping
    public void afterMapView(ProductView view, @MappingTarget Product product) {
        ProductManufacturer productManufacturer = new ProductManufacturer();
        long id = idSupplier.getNext();
        productManufacturer.setId(id);
        productManufacturer.setName(view.getName());
        productManufacturer.setCountry(view.getManufacturerCountry());
        product.setProductManufacturer(productManufacturer);
    }

    @AfterMapping
    public void afterMapDto(Product product, @MappingTarget ProductView view) {
        view.setManufacturerName(product.getProductManufacturer().getName());
        view.setManufacturerCountry(product.getProductManufacturer().getCountry());
        view.setManufacturerZipCode(product.getProductManufacturer().getZipCode());
    }

}
