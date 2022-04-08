package ru.gb.mall.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long id;

    @Column(name = "name", unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
}
