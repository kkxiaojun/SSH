package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.entity.Department;
import com.entity.Employee;
/**
 * 员工实现的Dao类
 * @author hope
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	/**
	 * Dao中根据用户名和密码查询
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username=? and password=?";
		List<Employee> employeeList = this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(employeeList.size()>0){
			// 查到数据返回第一个
			System.out.println(employeeList.get(0).getEname()+"查找成功");
			return employeeList.get(0);
		}
		return null;
	}

	@Override
	/**
	 * Dao层查询总员工数的方法
	 */
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	/**
	 * Dao中查询指定页的方法
	 */
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	/**
	 * Dao 层添加员工的保存方法
	 */
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
	}

	@Override
	/**
	 * Dao中根据id查询员工
	 */
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee em =this.getHibernateTemplate().get(Employee.class, eid);
		System.out.println("特定员工："+em);
		return em;
	}
	@Override
	/**
	 * Dao层编辑员工
	 */
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("name: "+employee.getEname());
		System.out.println("sex: "+employee.getSex());
		this.getHibernateTemplate().update(employee);
	}

	@Override
	/**
	 * Dao层删除方法
	 */
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}
}
