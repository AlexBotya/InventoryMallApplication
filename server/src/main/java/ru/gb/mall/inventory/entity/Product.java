package ru.gb.mall.inventory.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Table(name = "PRODUCTS")
@Entity
@Data
public class Product {
    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "manufacturer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_MANUFACTURER_PRODUCT_ID_RELATION")
    )
    private ProductManufacturer productManufacturer;

    @ManyToMany
    @JoinTable(
            name = "PRODUCT_CATEGORY_RELATION",
            joinColumns = @JoinColumn(
                    name = "PRODUCT_ID",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "FK_PRODUCT_CATEGORY_PRODUCT_ID_RELATION",
                            foreignKeyDefinition = "FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE NO ACTION ON UPDATE NO ACTION"
                    )

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "CATEGORY_ID",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "FK_PRODUCT_CATEGORY_CATEGORY_ID_RELATION",
                            foreignKeyDefinition = "FOREIGN KEY (category_id) REFERENCES product_categories(id) ON DELETE NO ACTION ON UPDATE NO ACTION"
                    )

            )
    )
    private List<ProductCategory> category;

    @ManyToOne
    @JoinColumn(
            name = "price_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_PRICE_PRODUCT_ID_RELATION")
    )
    private ProductPrice price;

    @ManyToOne
    @JoinColumn(
            name = "discount_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_DISCOUNT_PRODUCT_ID_RELATION")
    )
    private ProductDiscount discount;

    private Product(Builder builder) {
        setName(builder.name);
        setCategory(builder.category);
        setPrice(builder.price);
        setDiscount(builder.discount);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private List<ProductCategory> category;
        private ProductPrice price;
        private ProductDiscount discount;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withCategory(List<ProductCategory> val) {
            category = val;
            return this;
        }

        public Builder withPrice(ProductPrice val) {
            price = val;
            return this;
        }

        public Builder withDiscount(ProductDiscount val) {
            discount = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
