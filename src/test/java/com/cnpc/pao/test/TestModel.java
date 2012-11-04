package com.cnpc.pao.test;


import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.solder.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cnpc.pao.dao.TestDAO;




@RunWith(Arquillian.class)
public class TestModel {

	
	@Inject
	TestDAO testDAO;
	
	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addPackage(com.cnpc.pao.model.Test.class.getPackage())
				.addPackage(TestDAO.class.getPackage())
				.addPackage(Logger.class.getPackage())
				.addClasses(TestDAO.class)
				.addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml")
				.addAsManifestResource("persistence.xml", "persistence.xml");
		
	}
	
	@Test
	public void test(){
	    List<com.cnpc.pao.model.Test> temp= testDAO.findAllTests();
		System.out.println("测试：：：：：：：：：：：： " + temp);
	}
}
