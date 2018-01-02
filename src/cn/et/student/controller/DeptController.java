package cn.et.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.student.entity.Dept;
import cn.et.student.entity.TreeNode;
import cn.et.student.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService service;
	
	@ResponseBody
	@RequestMapping(value="/selectDept")
	//required=false:允许参数为空
	public List<TreeNode> selectDeptByDeptId(@RequestParam(required=false) Integer id, Integer page, Integer rows){
		if(id == null){
			id = 0;
		}
		return service.selectDeptByPid(id);
	}
	
	
}
