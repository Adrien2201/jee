package fr.formation.inti.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import fr.formation.inti.controller.AppMain;
import fr.formation.inti.entity.Employee;

@Repository
public class EmployeeDao extends GenericDaoHibernate<Employee, Integer> implements IEmployeeDao {

	private static final Log log = LogFactory.getLog(EmployeeDao.class);
	private IEmployeeDao dao;
	
	public EmployeeDao() {
		log.info("2 --------------- create new EmployeeDao()");
	}
	
	@PostConstruct
	private void postConstruct() {
		log.info("-------> init dao:postConstruct");
		
	}
	@PreDestroy
	private void preDestroy() {
		log.info("-------> destroy dao ");
		if(dao != null) {
			log.info("-------> dao : @PreDestroy close sessionFactory");
		}
			
	}
	
	
	
	/*
	public static EmployeeDao createInstance(){
		log.info("1 -----------> create new EmployeeDao by Factory method");
		if(dao == null)
			dao = new EmployeeDao();
		return dao;
	}*/
}