package com.jxust.svsh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jxust.svsh.entity.Person;
import com.jxust.svsh.service.PersonService;



/**
 * controller
 * @author //标识它是一个控制器
 * @Date2016年12月9日上午11:25:40
 */
@SessionAttributes(value = "username")
@Controller    //使用该注解标志它是一个控制器
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	public PersonService personService;

	/**
	 * 登录请求，失败返回error.jsp
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String dologin(String username, String password, Map<String, Object> map) {
		if (username.equals("admin") && password.equals("admin")) {
			map.put("username", username);//存放在request请求域中
			/**
			 * 类上加上@SessionAttributes({"username"}) 同时也会存放在 session域中
			 * @SessionAttributes 除了可以通过属性名指定需要存放到会话中的属性外(使用的是value属性值)
			 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是types属性值),
			 */
			return "frame";
		}
		return "error";
	}

	/**
	 * 保存添加的数据
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/saveperson")
	public String saveperson(Person person) {
		personService.addPerson(person);
		return "redirect:main";
	}

	/**
	 * 跳转到添加页面
	 * savepage.jsp
	 * @return
	 */
	@RequestMapping(value = "/addperson")
	public String saveperson() {

		return "savepage";
	}

	/**
	 * 删除一条数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePersonById")
	public String deletePersonById(@RequestParam(value = "id") String id) {
		System.out.println("删除单个");
		personService.deletePersonById(id);
		return "redirect:main";
	}

	/**
	 * 跳转到更新页面，回显数据
	 * editpage.jsp
	 * @param id
	 * @param model 使用的Model保存回显数据
	 * @return
	 */
	@RequestMapping(value = "/doupdate")
	public String doupdate(@RequestParam(value = "id") String id, Model model) {
		model.addAttribute("person", personService.getPersonById(id));
		return "editpage";
	}

	/**
	 * 更新数据
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/updateperson")
	public String updateperson(Person person) {
		System.out.println(person.toString());
		personService.updatePerson(person);
		return "redirect:main";
	}

	/**
	 * 查询所有人员信息
	 * 
	 * @param map 使用的是map保存回显数据
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String mian(Map<String, Object> map) {
		map.put("personlist", personService.getPersons());
		/*遍历集合，查看查询到的数据
		 * List<Person> lists = personService.getPersons(); 
		 * Iterator<Person> it = lists.iterator(); 
		 * while(it.hasNext()){ 
		 * 		Person p =it.next();
		 *	 	System.out.println(p.toString());
		 *  }
		 */
		return "main";
	}
}
