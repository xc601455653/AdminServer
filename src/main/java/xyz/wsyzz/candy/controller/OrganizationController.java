package xyz.wsyzz.candy.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.model.Organization;
import xyz.wsyzz.candy.service.OrganizationService;
import xyz.wsyzz.candy.util.ResultDataUtils;

import java.util.List;

/**
 * Created by xucan on 2022/5/15.
 */
@RestController
@RequestMapping("organization")
@Api(description = "组织管理服务", tags = {"OrganizationController"})
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("list")
    public ResultData list(Organization organization) {
        if (organization == null) {
            organization = new Organization();
        }
        List<Organization> list = organizationService.getListByEntity(organization);
        return ResultDataUtils.success(list);
    }
}
