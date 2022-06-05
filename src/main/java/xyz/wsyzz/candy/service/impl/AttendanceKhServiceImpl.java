package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.mapper.AttendanceKhMapper;
import xyz.wsyzz.candy.service.AttendanceKhService;

/**
 * Created by xucan on 2022/6/5.
 */
@Service
public class AttendanceKhServiceImpl implements AttendanceKhService {

    @Autowired
    private AttendanceKhMapper attendanceKhMapper;


}
