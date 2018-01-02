package cn.et.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.EmpMapper;
import cn.et.student.entity.Emp;
import cn.et.student.entity.EmpExample;

@Service
public class EmpService {
	@Autowired
	EmpMapper mapper;
	
	public List<Emp> selectEmpByDeptId(Integer deptId){
		EmpExample example = new EmpExample();
		if(deptId != null)
			example.createCriteria().andDeptidEqualTo(deptId);
		List<Emp> list = mapper.selectByExample(example);
		return list;
	}
}
