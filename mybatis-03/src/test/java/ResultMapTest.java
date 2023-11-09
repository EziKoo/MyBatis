import com.chy.mybatis.mapper.EmpMapper;
import com.chy.mybatis.pojo.Emp;
import com.chy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况
     *      a>为字段起别名，保持和属性名一致
     *      b>设置全局配置，将下划线自动映射为驼峰
     *      <setting name="mapUnderscoreToCamelCase" value="true"/>
     *      c>通过resultMap设置自定义的映射关系
     *          <resultMap id="empResultMap" type="Emp">
     *              <id property="eid" column="eid"></id>
     *              <result property="empName" column="emp_name"></result>
     *              <result property="age" column="age"></result>
     *              <result property="sex" column="sex"></result>
     *              <result property="email" column="email"></result>
     *          </resultMap>
     *处理多对一的映射关系：
     *      a>级联属性赋值
     *      b>association标签
     *      c>分布查询
     */

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }


    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(2);
        System.out.println(emp);
    }


    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp);
    }

}
