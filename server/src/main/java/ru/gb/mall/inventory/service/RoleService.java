package ru.gb.mall.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.mall.inventory.entity.Role;
import ru.gb.mall.inventory.exception.EntityNotFoundException;
import ru.gb.mall.inventory.repository.RoleRepository;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public Collection<Role> findAll() {
        return StreamSupport.stream(roleRepository.findAll().spliterator(), true).toList();
    }

    public Role findById(long id) {
        try {
            return roleRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Roles entity no found by id: " + id, e);
        }
    }

    public boolean deleteById(Long roleId) {
        try {
            roleRepository.deleteById(roleId);
            return true;
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Roles entity no found by id: " + roleId, e);
        }
    }

   /* public void saveOrUpdate(UserRole role) {
        try {
            roleRepository.save(role);
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Users role entity no found: " + role, e);
        }
    }

    public boolean saveOrUpdate(Long rolesId) {
        UserRole role = findById(rolesId);
        if (role == null) {
            return false;
        }
        saveOrUpdate(role);
        return true;
    }*/
}