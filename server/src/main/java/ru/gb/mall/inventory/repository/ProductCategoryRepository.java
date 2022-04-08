package ru.gb.mall.inventory.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.mall.inventory.entity.ProductCategory;
@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {

}