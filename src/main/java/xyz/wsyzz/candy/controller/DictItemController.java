package xyz.wsyzz.candy.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.model.DictItem;
import xyz.wsyzz.candy.service.DictItemService;
import xyz.wsyzz.candy.util.ResultDataUtils;

import java.util.List;

/**
 * Created by xucan on 2022/3/27.
 */

@RestController
@RequestMapping("dictitem")
@Api(description = "字典子项服务", tags = {"DictItemController"})
public class DictItemController {

    @Autowired
    private DictItemService dictItemService;

    @PostMapping("list")
    public ResultData list(DictItem dictItemt) {
        if (dictItemt == null) {
            dictItemt = new DictItem();
        }
        List<DictItem> list = dictItemService.getListByEntity(dictItemt);
        return ResultDataUtils.success(list);
    }

}
