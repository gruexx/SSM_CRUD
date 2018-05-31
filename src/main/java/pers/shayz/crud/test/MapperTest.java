package pers.shayz.crud.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.shayz.crud.bean.Department;
import pers.shayz.crud.bean.Employee;
import pers.shayz.crud.dao.DepartmentMapper;
import pers.shayz.crud.dao.EmployeeMapper;

import java.util.UUID;

/**
 * @author ZhouXiaoyu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD() {
        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(
//                new Department(null, "开发部")
//        );
//        departmentMapper.insertSelective(
//                new Department(null, "测试部")
//        );

//        employeeMapper.insertSelective(
//                new Employee(null, "ShayZ", "M", "shayz@qq.com", 1)
//        );

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i=0; i<1000; i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+1;
            mapper.insertSelective(new Employee(null, uid, "M", uid+"@shayz.com", 1));
        }
        System.out.println("insert success");
    }
}
