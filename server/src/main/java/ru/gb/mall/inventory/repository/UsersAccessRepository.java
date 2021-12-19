package ru.gb.mall.inventory.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.gb.mall.inventory.entity.UserAccess;

import java.util.Optional;

public interface UsersAccessRepository extends PagingAndSortingRepository <UserAccess, Long> {
    Optional<UserAccess> findByEmail(@Param("email") String email);
}