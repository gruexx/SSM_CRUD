package pers.shayz.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.shayz.crud.bean.Department;
import pers.shayz.crud.dao.DepartmentMapper;

import java.util.List;

/**
 * @author ZhouXiaoyu
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
