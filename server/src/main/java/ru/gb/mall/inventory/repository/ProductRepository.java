package ru.gb.mall.inventory.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.mall.inventory.entity.Product;
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
