package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Role;
import vn.group27.buildingManagement.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    
    private final RoleRepository roleRepository;
    
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    public Optional<Role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }
    
    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
    
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
    
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}