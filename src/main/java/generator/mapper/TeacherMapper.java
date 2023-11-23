package generator.mapper;

import generator.com.chy.pojo.Teacher;

/**
* @author Mayn
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2023-11-23 20:14:22
* @Entity generator.com.chy.pojo.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
