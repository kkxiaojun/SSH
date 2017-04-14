package com.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.DepartmentDao;
import com.entity.Department;
import com.entity.PageBean;
import com.service.DepartmentService;
/**
 * 部门管理的业务层实现类
 * @author hope
 */

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	// 注入serviceDao
    private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	/**
	 * 分页查询部门的方法
	 */
	public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        // 封装当前页数
        pageBean.setCurrPage(currPage);
        // 封装每页记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // 封装总记录数
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 封装页数
        int totalPage;
        if(totalCount%pageSize == 0){
        	totalPage = totalCount/pageSize;
        }else{
        	totalPage = totalCount/pageSize+1; 
        }
        pageBean.setTotalPage(totalPage);
        // 封装当前页记录
        int begin= (currPage - 1)*pageSize;
        List<Department> list = departmentDao.findByPage(begin, pageSize);
        pageBean.setList(list);
		return pageBean;
	}

	@Override
	/**
	 * 添加部门的业务层实现
	 */
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	/**
	 * 根据id查询部门的业务层实现
	 */
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}
	
	@Override
	/**
	 * 更新部门的业务层实现
	 */
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	@Override
	/**
	 * 删除部门的业务层实现
	 */
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}

	@Override
	/**
	 * 业务层查询所有部门
	 */
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	

}
