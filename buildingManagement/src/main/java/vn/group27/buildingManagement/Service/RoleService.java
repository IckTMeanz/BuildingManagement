package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.Role;
import vn.group27.buildingManagement.Entity.User;
import vn.group27.buildingManagement.Repo.RoleRepo;

@Service
public class RoleService {
    private RoleRepo roleRepo;
    @Autowired
    public RoleService(RoleRepo roleRepo){
        this.roleRepo=roleRepo;
    }

    public Role findByName(String name){
        return this.roleRepo.findByName(name);
    }
}
