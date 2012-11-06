package com.cnpc.pao.gwt.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import com.cnpc.pao.gwt.client.shared.qualifier.Delete;
import com.cnpc.pao.model.GetTestListMessage;
import com.cnpc.pao.model.Test;
import com.cnpc.pao.model.TestList;
/**
 * Main application entry point.
 */
@EntryPoint
public class TestingErrai {


	@Inject @Delete
	private Event<Test> deleteTestEvent;
	@Inject
	private Event<GetTestListMessage> getTestListEvent;
	
	private TestingTable testingWidget = new TestingTable();

	@PostConstruct
	public void buildUI() {
		Window.alert("testing");
		initTestingUI();

	}

	private void initTestingUI() {
		
		refreshUI();
		
		testingWidget.setDeleteHandler(new RowOperationHandler<Test>() {

			@Override
			public void handle(Test test) {
				Window.alert("...点击鼠标，test值类型为"+test.getId());
				deleteTestEvent.fire(test);
				refreshUI();
			}
		});


		RootPanel.get("content").add(testingWidget);
	}

	private void refreshUI() {
		Window.alert("成功");
		getTestListEvent.fire(new GetTestListMessage("get data from database"));
	}

	
	public void recieveTestsHandle(@Observes TestList event){
		testingWidget.removeAllRows();
		testingWidget.addAll(event.getTestList());
	}

	public Event<Test> getDeletePersonEvent() {
		return deleteTestEvent;
	}

	public void setDeletePersonEvent(
			Event<Test> deletePersonEvent) {
		this.deleteTestEvent = deletePersonEvent;
	}

	public Event<GetTestListMessage> getGetTestListEvent() {
		return getTestListEvent;
	}

	public void setGetTestListEvent(Event<GetTestListMessage> getTestListEvent) {
		this.getTestListEvent = getTestListEvent;
	}

	public TestingTable getTestingWidget() {
		return testingWidget;
	}

	public void setTestingWidget(TestingTable testingWidget) {
		this.testingWidget = testingWidget;
	}

}