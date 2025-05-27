package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Role;
import vn.group27.buildingManagement.entity.User;
import vn.group27.buildingManagement.entity.UsersRole;
import vn.group27.buildingManagement.entity.UsersRoleId;

import java.util.List;

@Repository
public interface UsersRoleRepository extends JpaRepository<UsersRole, UsersRoleId> {
    List<UsersRole> findByUser(User user);
    List<UsersRole> findByRole(Role role);
}