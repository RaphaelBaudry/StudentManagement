package com.management.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.management.dao.StudentDao;
import com.management.model.Database;
import com.management.model.Student;
import com.management.utils.HibernateUtils;
import com.management.utils.MySQLDatabase;
import com.management.utils.ServletUtils;


@Controller
@RequestMapping(value={"", "/", "/StudentManagement"})
public class ManagementController {
	private StudentDao personnes = new StudentDao();
	private ModelAndView modelAndView = new ModelAndView();
	//private Database database = new Database("management");
	
	/**
	 * Fill with all databases available
	 * @return
	 */
	private List<String> filldata() {
		MySQLDatabase.listDatabases();
		
		List<String> listData = new ArrayList<String>();
		
		for (Database database : MySQLDatabase.databases) {
			if (database.getName().equals("management"))
				listData.add(database.getName() + " (default)");
			else 
				listData.add(database.getName());
		}
		
		return listData;
	}
	
	@GetMapping(value={"", "/", "/StudentManagement","home"})
    public ModelAndView handleRedirect() {
		modelAndView.setViewName("index");
		HibernateUtils.setup("management");
		
		modelAndView.addObject("databases", filldata());

		return modelAndView;
    }
	
	@GetMapping("/listDatabases")
	public ModelAndView getDatabases() {
		modelAndView.setViewName("index");
		
		modelAndView.addObject("databases", filldata());

		return modelAndView;
		
	}
	
	@GetMapping("/okay")
	public ModelAndView selectValues(@RequestParam(name = "visitor_option_database") String database) {
		modelAndView.setViewName("index");
		
		modelAndView.addObject("databases", filldata());
		
		return modelAndView;
	}
	
	@GetMapping("/database")
    public ModelAndView setup() {
		modelAndView.setViewName("index");

        return modelAndView;
    }
	
	@GetMapping("/fillPerson")
	public ModelAndView fillPerson(@RequestParam(name = "visitor_firstname") String firstname, 
    		@RequestParam(name = "visitor_lastname") String lastname,
    		@RequestParam(name = "visitor_email") String email,
    		@RequestParam(name = "visitor_age") int age) {
		modelAndView.setViewName("index");
		Student p = new Student(firstname, lastname, age, email);
		
		personnes.save(p);
	    return modelAndView;
	}
	
	@GetMapping("/removeAll")
	public ModelAndView removeAll() {
		modelAndView.setViewName("listPersons");
		
		personnes.deleteAll();
		modelAndView.addObject("personnes", personnes.getAll());
		
		return modelAndView;
	}
	
	@GetMapping("/remove")
	public ModelAndView remove(@RequestParam(name = "index") String index) {
		modelAndView.setViewName("listPersons");
		
		Optional<Student> p = personnes.get(Integer.parseInt(ServletUtils.getNbr(index)));
		
		personnes.delete(p.get());
		modelAndView.addObject("personnes", personnes.getAll());
		
		return modelAndView;
	}
	
	@GetMapping("/listPersons")
	public ModelAndView listPersons() {
		modelAndView.setViewName("listPersons");
		
		modelAndView.addObject("personnes", personnes.getAll());
		
		return modelAndView;
	}	
}
