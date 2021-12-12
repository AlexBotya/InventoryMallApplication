package ru.gb.mall.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    @Column(unique = true)
    private String email;
    @Column()
    private String password;

    private String firstName;

    private String secondName;
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "user_id")
    )
    private Collection<Role> roles;


}
