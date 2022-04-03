package ru.gb.mall.inventory.repository;

import org.springframework.stereotype.Repository;
import ru.gb.mall.inventory.entity.Product;

import java.util.HashMap;
import java.util.Optional;
@Repository
public abstract class ProxyCacheProductRepository implements ProductRepository{
    private final HashMap<Long, Product> productCache = new HashMap<>();
    private final ProductRepository productRepository;

    ProxyCacheProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        if (productCache.containsKey(id)){
            Optional<Product> optional = Optional.empty();
            return Optional.of(productCache.get(id));
        }
        Optional<Product> currentProduct = productRepository.findById(id);
        currentProduct.ifPresent(product -> productCache.put(id, product));
                return currentProduct;
    }

}
