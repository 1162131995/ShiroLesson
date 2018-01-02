package cn.et.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.StudentMapper;
import cn.et.student.entity.Student;
import cn.et.student.utils.PageTools;

@Service
public class StudentService {
	@Autowired
	StudentMapper mapper;
	
	public PageTools selectStudent(String sname, Integer page, Integer rows){
		if(sname == null){
			sname = "";
		}
		int total = getStudentCount(sname);
		PageTools pt = new PageTools(page, rows, total);
		pt.setRows(mapper.selectStudent(sname, pt.getStartIndex(), pt.getEndIndex()));
		return pt;
	}
	public int getStudentCount(String sname){
		return mapper.getStudentCount(sname);
	}
	
	public void updateStudent(Student student){
		mapper.updateByPrimaryKey(student);
	}
	public void deleteStudent(Integer sid){
		mapper.deleteByPrimaryKey(sid);
	}
	public void insertStudent(Student student){
		mapper.insert(student);
	}
}
