package com.action;

import java.util.ArrayList;
import java.util.List;

import com.entity.Department;
import com.entity.Employee;
import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DepartmentService;
import com.service.EmployeeService;
/**
 * 员工管理web层
 * 采用模型驱动
 * @author hope
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	// 模型驱动使用的对象，自动注入employee的数据 
    private Employee employee = new Employee();
    // struts2整合spring,注入业务层
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Employee getModel(){
		return employee;
	}
	/**
	 * 员工登陆
	 * @return
	 */
	public String login(){
		System.out.println("action.login方法执行");
		// 调用业务层方法
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee==null){
			// 登陆失败
			this.addActionError("用户名或密码错误！");
			System.out.println("action查找失败");
			return "INPUT";
		}else{
			// 登录成功
			System.out.println("Action查找成功");
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return "SUCCESS";
		}
	}
	
	// 当前页数
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * 分页查询员工
	 * @return
	 */
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 使用的是模型驱动，把部门信息放入值栈中，采可以使用OGNL表达是获取
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 跳转到添加员工的方法
	 * @return
	 */
	public String goAddEmployee(){
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		// 把部门信息放入值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		return "goAddEmployee";
	}
	/**
	 * web层添加员工方法
	 */
	public String save(){
		employeeService.save(employee);
		return "addSuccess";
	}
	
	/**
	 * 根据id查询员工
	 * @return
	 */
	public String findById(){
		employee = employeeService.findById(employee.getEid());
		System.out.print("所属部门："+employee.getEname());
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		// 把部门信息放入值栈中
		System.out.print("所有部门："+list.size());
		ActionContext.getContext().getValueStack().set("list", list);	
		return "goEditEmployee";
	}
	
	/**
	 * web层编辑员工方法
	 */
	public String edit(){
		employeeService.update(employee);
		return "editSuccess";
	}
	/**
	 * web层实现删除的方法
	 */
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
