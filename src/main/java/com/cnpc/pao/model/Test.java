package com.cnpc.pao.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.jboss.errai.common.client.api.annotations.Portable;
@Portable
@Entity(name="tbl_test")
@AttributeOverrides( { @AttributeOverride(name = "id", column = @Column(name = "test_id")) })
@NamedQueries({@NamedQuery(name = "findAllTests", query = "SELECT test FROM com.cnpc.pao.model.Test test ")})

public class Test extends BaseModel{

	private static final long serialVersionUID = -2342341L;
	
	@Column
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
}
