package xyz.wsyzz.candy.service;

import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.model.Menu;

import java.util.Set;

/**
 * Created by ${XC} on 2019/5/16.
 */
@Service
public interface MenuService {
    Set<Menu> getMenusByRoleId(Long id);
}
