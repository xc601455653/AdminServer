package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.mapper.AttendanceZrMapper;
import xyz.wsyzz.candy.service.AttendanceZrService;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class AttendanceZrServiceImpl implements AttendanceZrService {

    @Autowired
    private AttendanceZrMapper attendanceZrMapper;


}
