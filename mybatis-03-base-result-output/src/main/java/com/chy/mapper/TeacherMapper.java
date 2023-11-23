package com.chy.mapper;

import com.chy.pojo.Teacher;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 10:50
 * @Description:
 */

public interface TeacherMapper {

    int insertTeacher(Teacher teacher);

    Teacher queryById(String tId);

}
