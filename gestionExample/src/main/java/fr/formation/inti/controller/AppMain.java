package fr.formation.inti.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.inti.config.AppConfigurations;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.IEmployeeService;

public class AppMain {

	private static final Log log = LogFactory.getLog(AppMain.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigurations.class);
		
		IEmployeeService service = context.getBean("employeeService", EmployeeService.class);
		log.info("------ BeanService" +service);
		List<Employee> employees = service.findAll();
		
		for(Employee e : employees)
			log.info("------" +e);
	}

}
