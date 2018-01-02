package cn.et.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.student.entity.Emp;
import cn.et.student.entity.Result;
import cn.et.student.entity.Student;
import cn.et.student.service.EmpService;
import cn.et.student.utils.PageTools;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@ResponseBody
	@RequestMapping(value="/selectEmp",method=RequestMethod.GET)
	//required=false:允许参数为空
	public List<Emp> selectEmpByDeptId(@RequestParam(required=false) Integer id, Integer page, Integer rows){
		
		return service.selectEmpByDeptId(id);
	}
	
	
}
