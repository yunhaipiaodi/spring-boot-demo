package com.lyn.spring.controller;

import com.lyn.spring.dao.DepartmentDao;
import com.lyn.spring.dao.EmployeeDao;
import com.lyn.spring.entities.Department;
import com.lyn.spring.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @author lyn
 * @create 2020-05-07 16:22
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String add(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String submit(Employee employee){
        employeeDao.save(employee);
        //提交后，重定向到list页面
        return "redirect:/emps";
    }
}
