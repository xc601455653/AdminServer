package xyz.wsyzz.candy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.service.WorkdateService;

/**
 * Created by xucan on 2022/6/5.
 */
@RestController
@RequestMapping("workdate")
public class WorkdateController {

    @Autowired
    private WorkdateService workdateService;


}
