package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.model.Organization;
import xyz.wsyzz.candy.mapper.OrganizationMapper;
import xyz.wsyzz.candy.service.OrganizationService;

import java.util.List;

/**
 * Created by xucan on 2022/5/15.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public List<Organization> getListByEntity(Organization organization) {
        Example example = new Example(Organization.class);
        example.and()
                .andEqualTo("id", organization.getId())
                .andEqualTo("parentId", organization.getParentId())
                .andEqualTo("name", organization.getName());
        List<Organization> list = organizationMapper.selectByExample(example);
        return list;
    }
}
