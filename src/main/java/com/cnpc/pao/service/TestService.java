package com.cnpc.pao.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.jboss.solder.logging.Logger;

import com.cnpc.pao.dao.TestDAO;
import com.cnpc.pao.model.Test;
import com.cnpc.pao.util.LoggingInterceptor;

@Stateless(name="testService")
public class TestService implements Serializable {

	
	private static final long serialVersionUID = -2213213L;

	@Inject
	private TestDAO testDAO;

	Logger log = Logger.getLogger(TestService.class);
	public TestDAO getTestDAO() {
		return testDAO;
	}

	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}
	
	@Interceptors(LoggingInterceptor.class)
	public List<Test> getAllTests(){
		try {

			return testDAO.findAllTests();	
		} catch (Exception e) {
			log.info("++++++++类：方法||TestService：getAllTests++++信息：出错++++++");
		}
		return null;
	}
	
}
