package com.cnpc.pao.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.solder.logging.Logger;

import com.cnpc.pao.model.Test;
import com.cnpc.pao.util.LoggingInterceptor;

@Stateless(name="testDAO")
public class TestDAO implements Serializable{
	 
	private static final long serialVersionUID = -34312312L;
	
	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger(TestDAO.class);

	@SuppressWarnings("unchecked")
	@Interceptors(LoggingInterceptor.class)
	public List<Test> findAllTests(){
		 try {
			Query query = em.createNamedQuery("findAllTests");
			return (List<Test>) query.getResultList();
		} catch (Exception e) {
			
			log.info("++++++++类：方法||TestDAO：findAllTests++++信息：出错++++++");
			e.printStackTrace();
		}
		 return null;
	 }
	
}
