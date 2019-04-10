package in.co.bytehub.snomed.searchapi.commons;

import java.util.HashMap;

public enum EnumTypeId {

	FSN("900000000000003001"),
	SYNONYM("900000000000013009");

	private String value;
	
	private static HashMap<String, EnumTypeId> enumMap =new HashMap<>();
	
	static {
		for(EnumTypeId entry : EnumTypeId.values())
			enumMap.put(entry.value, entry);
		}
	
	private EnumTypeId(String value) {
		this.value=value;
	}
	
	public static EnumTypeId getEnumTypeId(String val)
	{
		return enumMap.get(val);
	}
	
}
