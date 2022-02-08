package fr.formation.inti.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.inti.config.AppConfigurations;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.IEmployeeService;

public class AppMain {

	private static final Log log = LogFactory.getLog(AppMain.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfigurations.class);  //Pour les annotations
		//ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //pour fichier XML
		log.info("----- getBean");
		IEmployeeService service = context.getBean("employeeService", EmployeeService.class);
		log.info("------ BeanService" +service);
		List<Employee> employees = service.findAll();
		employees.forEach(log::info);
		for(Employee e : employees)
			log.info("------" +e);
		
		context.close();
	}
}
