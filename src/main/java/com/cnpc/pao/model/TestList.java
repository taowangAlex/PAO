package com.cnpc.pao.model;


import java.io.Serializable;
import java.util.List;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.enterprise.client.cdi.api.Conversational;


@Portable
@Conversational
public class TestList implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Test> testList;

	public List<Test> getTestList() {
		return testList;
	}

	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}

	public TestList() {
	}


	
}
