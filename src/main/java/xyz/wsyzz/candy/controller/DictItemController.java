package xyz.wsyzz.candy.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xucan on 2022/3/27.
 */

@RestController
@RequestMapping("dict")
@Api(description = "字典子项服务", tags = {"DictItemController"})
public class DictItemController {
}
