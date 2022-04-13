package ru.gb.mall.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductManufacturer {

   @Id
   long id;

   @Column(name = "NAME", nullable = false, unique = true, length = 50)
   private String name;

   @Column(name = "COUNTRY", nullable = false, unique = false, length = 50)
   private String country;

   @Column(name = "ZIPCODE", nullable = false, unique = false, length = 50)
   private int zipCode;

}
