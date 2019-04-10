package in.co.bytehub.snomed.searchapi.model;

public abstract class Component {

	protected String effectiveTime;
	protected int active;
	protected String moduleId;
	
	protected Component() {
		
	}
	
	
	protected Component(String effectiveTime2, int active, String moduleId) {
		super();
		this.effectiveTime = effectiveTime2;
		this.active = active;
		this.moduleId = moduleId;
	}
	
	
	public String getEffectiveTime() {
		
		return effectiveTime;
	}
	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

		
	
}
