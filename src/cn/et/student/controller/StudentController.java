package cn.et.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.student.entity.Result;
import cn.et.student.entity.Student;
import cn.et.student.service.StudentService;
import cn.et.student.utils.PageTools;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	@ResponseBody
	@RequestMapping(value="/selectStudent",method=RequestMethod.GET)
	//required=false:允许参数为空
	public PageTools selectStudentBySname(@RequestParam(required=false) String sname, Integer page, Integer rows){
		
		return service.selectStudent(sname,page,rows);
	}
	
	@ResponseBody
	@RequestMapping(value="/student/{sid}",method=RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer sid, Student student, Integer page, Integer rows){
		student.setSid(sid);
		Result result = new Result();
		result.setCode(1);
		try {
			service.updateStudent(student);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/student/{sid}",method=RequestMethod.DELETE)
	public Result deleteStudent(@PathVariable Integer sid, Integer page, Integer rows){
		Result result = new Result();
		result.setCode(1);
		try {
			service.deleteStudent(sid);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public Result insertStudent(Student student, Integer page, Integer rows){
		Result result = new Result();
		result.setCode(1);
		try {
			service.insertStudent(student);
		} catch (Exception e) {
			result.setCode(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
}
