package com.cnpc.pao.faces;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cnpc.pao.model.Test;
import com.cnpc.pao.service.TestService;

@Named("testBean")
@SessionScoped
public class TestBean implements Serializable {

	private static final long serialVersionUID = -122344L;
	
	@Inject
	TestService testService;
	
	 public List<Test> getTestMessages(){
		 
		return testService.getAllTests();
	}

}
