package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.mapper.WorkdateMapper;
import xyz.wsyzz.candy.service.WorkdateService;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class WorkdateServiceImpl implements WorkdateService {

    @Autowired
    private WorkdateMapper workdateMapper;


}
