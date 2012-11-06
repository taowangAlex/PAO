package com.cnpc.pao.gwt.server;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.solder.logging.Logger;

import com.cnpc.pao.gwt.client.shared.qualifier.Delete;
import com.cnpc.pao.model.GetTestListMessage;
import com.cnpc.pao.model.Test;
import com.cnpc.pao.model.TestList;
import com.cnpc.pao.service.TestService;

@ApplicationScoped
public class TestingErraiService {
	@Inject
	private TestService testService;
	
	@Inject 
	private Event<TestList> testListEvent;
	
	Logger logger = Logger.getLogger(TestingErraiService.class);

	public void handleGetPersonListMessage(@Observes GetTestListMessage event) {
		logger.info("~~~~~~~~~~~~~~" + event.getMessage());
		List<Test> tests = new ArrayList<Test>();
		tests = testService.getAllTests();

		TestList testList = new TestList();
		testList.setTestList(tests);
		testListEvent.fire(testList);
	}
	
	 public void handleDeletePerson(@Observes @Delete Test test){
		 logger.info("接受到鼠标点击事件");
		  testService.deleteTest(test.getId());
		  logger.info("$$$$$$$$$$$$$$ " +  "删除person成功");
	  }
	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public Event<TestList> getTestListEvent() {
		return testListEvent;
	}
	public void setTestListEvent(Event<TestList> testListEvent) {
		this.testListEvent = testListEvent;
	}
}
