package generator.mapper;

import generator.com.chy.pojo.User;

/**
* @author Mayn
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-11-23 20:14:22
* @Entity generator.com.chy.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
