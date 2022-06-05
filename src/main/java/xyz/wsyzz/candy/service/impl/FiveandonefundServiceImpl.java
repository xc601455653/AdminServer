package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.mapper.FiveandonefundMapper;
import xyz.wsyzz.candy.service.FiveandonefundService;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class FiveandonefundServiceImpl implements FiveandonefundService {

    @Autowired
    private FiveandonefundMapper fiveandonefundMapper;
}
