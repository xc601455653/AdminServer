package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.mapper.AttendanceZzMapper;
import xyz.wsyzz.candy.service.AttendanceZzService;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class AttendanceZzServiceImpl implements AttendanceZzService {

    @Autowired
    private AttendanceZzMapper attendanceZzMapper;

}
