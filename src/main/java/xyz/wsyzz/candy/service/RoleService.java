package xyz.wsyzz.candy.service;

import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.Role;

import java.util.Set;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public interface RoleService {
    Set<Role> getRolesByUserId(Long id);
}
