package com.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.entity.Department;
import com.entity.Employee;
import com.entity.PageBean;
import com.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
   
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	/**
	 * 业务层登录方法
	 */
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee eEmployee = employeeDao.findByUsernameAndPassword(employee);
		return eEmployee;
	}

	@Override
	/**
	 * 业务层查询指定页面方法
	 */
	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		  PageBean<Employee> pageBean = new PageBean<Employee>();
	        // 封装当前页数
	        pageBean.setCurrPage(currPage);
	        // 封装每页记录数
	        int pageSize = 3;
	        pageBean.setPageSize(pageSize);
	        // 封装总记录数
	        int totalCount = employeeDao.findCount();
	        pageBean.setTotalCount(totalCount);
	        // 封装页数
	        int totalPage;
	        if(totalCount%pageSize==0){
	        	totalPage = totalCount/pageSize;
	        }else{
	        	totalPage = totalCount/pageSize + 1; 
	        }
	        pageBean.setTotalPage(totalPage);
	        // 封装当前页记录
	        int begin= (currPage - 1)*pageSize;
	        List<Employee> list = employeeDao.findByPage(begin, pageSize);
	        pageBean.setList(list);
			return pageBean;
	}

	@Override
	/**
	 * 业务层添加员工的方法
	 */
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		
	}

	@Override
	/**
	 * 业务层根据id查询员工的方法
	 */
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}
	
	@Override
	/**
	 * 编辑员工的业务层实现方法
	 */
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);		
	}

	@Override
	/**
	 * 业务层员工删除
	 */
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
