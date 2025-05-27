package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Role;
import vn.group27.buildingManagement.entity.User;
import vn.group27.buildingManagement.entity.UsersRole;
import vn.group27.buildingManagement.entity.UsersRoleId;
import vn.group27.buildingManagement.repository.UsersRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersRoleService {
    
    private final UsersRoleRepository usersRoleRepository;
    
    @Autowired
    public UsersRoleService(UsersRoleRepository usersRoleRepository) {
        this.usersRoleRepository = usersRoleRepository;
    }
    
    public List<UsersRole> getAllUsersRoles() {
        return usersRoleRepository.findAll();
    }
    
    public Optional<UsersRole> getUsersRoleById(UsersRoleId id) {
        return usersRoleRepository.findById(id);
    }
    
    public List<UsersRole> getUsersRolesByUser(User user) {
        return usersRoleRepository.findByUser(user);
    }
    
    public List<UsersRole> getUsersRolesByRole(Role role) {
        return usersRoleRepository.findByRole(role);
    }
    
    public UsersRole saveUsersRole(UsersRole usersRole) {
        return usersRoleRepository.save(usersRole);
    }
    
    public void deleteUsersRole(UsersRoleId id) {
        usersRoleRepository.deleteById(id);
    }
}