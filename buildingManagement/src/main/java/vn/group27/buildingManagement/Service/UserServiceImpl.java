package vn.group27.buildingManagement.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.User;
import vn.group27.buildingManagement.Entity.Role;
import vn.group27.buildingManagement.Repo.UserRepo;

import java.util.Collection;
import java.util.stream.Collectors;


@Service

public class UserServiceImpl implements UserService{


    private UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    @Override
    public User findByUsername(String name){
        return userRepo.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name){
        User user= userRepo.findByUsername(name);
        if(user==null){
            throw new UsernameNotFoundException("invalid user");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public User save(User u){
        return this.userRepo.save(u);
    }

}
