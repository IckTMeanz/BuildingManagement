package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.group27.buildingManagement.Entity.Role;
import vn.group27.buildingManagement.Entity.User;
import vn.group27.buildingManagement.Repo.RoleRepository;
import vn.group27.buildingManagement.Repo.UserRepo;


import java.util.*;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null && userRepo.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username đã tồn tại: " + user.getUsername());
        }

        Set<Role> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
            Role existingRole = roleRepository.findById(role.getId())
                    .orElseThrow(() -> new RuntimeException("Role không tồn tại với id: " + role.getId()));
            roles.add(existingRole);
        }
        user.setRoles(roles);

        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
