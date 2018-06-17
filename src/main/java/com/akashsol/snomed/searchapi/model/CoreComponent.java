package com.akashsol.snomed.searchapi.model;


import org.springframework.data.annotation.Id;

public abstract class CoreComponent extends Component {

	@Id
	protected String id;

	protected CoreComponent() {
		
	}
	
	protected CoreComponent(String id,String effectiveTime, int active, String moduleId) {
		super(effectiveTime, active, moduleId);
		this.id = id;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
