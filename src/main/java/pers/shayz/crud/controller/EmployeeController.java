package pers.shayz.crud.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.shayz.crud.bean.Employee;
import pers.shayz.crud.bean.Msg;
import pers.shayz.crud.service.EmployeeService;

import java.util.List;

/**
 * @author ZhouXiaoyu
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Msg.success();
    }


    /**
     * 新的方法 with json
     * @param pn
     * @return
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(
            @RequestParam(value = "pn", defaultValue = "1")Integer pn){
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();
        PageInfo pageInfo = new PageInfo(emps, 5);

        return Msg.success().add("pageInfo", pageInfo);
    }

/**
 * 旧的返回数据的方法
 */
    //@RequestMapping("/emps")
//    public String getEmps(@RequestParam(value = "pn", defaultValue = "1")Integer pn, Model model){
//
//        PageHelper.startPage(pn, 5);
//        List<Employee> emps = employeeService.getAll();
//        PageInfo pageInfo = new PageInfo(emps, 5);
//        model.addAttribute("pageInfo", pageInfo);
//        return "list";
//    }
}
