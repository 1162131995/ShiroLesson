package cn.et.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.DeptMapper;
import cn.et.student.entity.Dept;
import cn.et.student.entity.DeptExample;
import cn.et.student.entity.Emp;
import cn.et.student.entity.TreeNode;

@Service
public class DeptService {
	@Autowired
	DeptMapper mapper;
	
	public List<TreeNode> selectDeptByPid(Integer pid){
		DeptExample example = new DeptExample();
		example.createCriteria().andPidEqualTo(pid);
		List<Dept> list = mapper.selectByExample(example);
		
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (Dept dept : list) {
			TreeNode node = new TreeNode();
			node.setId(dept.getDeptid());
			node.setText(dept.getDname());
			
			if(selectDeptByPid(dept.getDeptid()).size() == 0){
				node.setState("open");
			}
			
			nodeList.add(node);
		}
		return nodeList;
	}
}
