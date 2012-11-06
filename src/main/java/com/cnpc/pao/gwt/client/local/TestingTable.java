package com.cnpc.pao.gwt.client.local;

import java.util.List;

import com.cnpc.pao.model.Test;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;

public class TestingTable extends FlexTable{

	private RowOperationHandler<com.cnpc.pao.model.Test> deleteHandler;
	
	public TestingTable(){
		addStyleName("personTable");
		ColumnFormatter columnFormatter = getColumnFormatter();
		columnFormatter.setStyleName(4, "deleteButton");
		columnFormatter.setStyleName(5, "editButton");
	}
	
	public void addAll(List<Test> Tests){
		for(Test test : Tests){
			add(test);
		}
	}
	public void add(final Test test){
		
		
		Button deleteButton = new Button("删除...");
		deleteButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				if(deleteHandler != null){
					deleteHandler.handle(test);
				}
			}
		});
		
		int row = getRowCount();
	    insertRow(row);
	    insertCells(row, 0,4);
	    setText(row, 0, (test.getId()== null? "*" : test.getId().toString()));
	    setText(row, 1, test.getMessage()== null? "*" : test.getMessage());
	    setWidget(row, 2, deleteButton);
	}
	
	public void setDeleteHandler(RowOperationHandler<Test> handler) {
		deleteHandler = handler;
	}

}
