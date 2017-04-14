package com.action;

import com.entity.Department;
import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DepartmentService;
/**
 * 部门管理的action
 * 采用模型驱动注入
 * @author hope
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	// 模型驱动
    private Department department = new Department();
    
    private DepartmentService departmentService;
	@Override
	// 模型驱动
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	// 注入部门管理service
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	// 当前页数
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 分页查询部门
	 * @return
	 */
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		// 使用的是模型驱动，把部门信息放入值栈中，采可以使用OGNL表达是获取
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 跳转到添加部门的方法
	 * @return
	 */
	public String goAddDepartment(){
		return "goAddDepartment";
	}
	/**
	 * 添加部门的执行方法
	 */
	public String saveDepartment(){
		departmentService.save(department);
		return "addSuccess";
	}
	/**
	 * 根据ID查询部门的方法
	 */
	public String findById(){
		department = departmentService.findById(department.getDid());
		return "goEditDepartment";
	}
	/**
	 * 编辑部门的执行方法
	 */
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	/**
	 * web层部门删除的方法
	 * @return
	 */
	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
