package fr.formation.inti.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{
	private static final Log log = LogFactory.getLog(EmployeeService.class);
	
	//@Autowired  //injection par setter
	private IEmployeeDao dao;
	
	private String message;
	
	public EmployeeService() {
		log.info("------> new EmployeeService()");
		//dao = new EmployeeDao();	
	}
	
	@Autowired   //injection par constructeur
	public EmployeeService(IEmployeeDao dao) {
		log.info("------> new EmployeeService(dao)");
		this.dao = dao;
		//dao = new EmployeeDao();
		
	}

	@Override
	public Integer save(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		dao.update(employee);
		
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

	public void setDao2(IEmployeeDao dao) {
		log.info("------> SetDao");
		this.dao = dao;
	}

	public void setMessage(String message) {
		log.info(message);
		this.message = message;
	}
	
	@PostConstruct
	private void postConstruct() {
		log.info("-------> init service:postConstruct");
		
	}
	@PreDestroy
	private void preDestroy() {
		log.info("-------> destroy service");
		if(dao != null) {
			log.info("-------> service : @PreDestroy close sessionFactory");
		}
	}
	
	

	
}
