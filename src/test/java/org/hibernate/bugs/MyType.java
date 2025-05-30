package org.hibernate.bugs;

import java.io.Serializable;
import java.util.stream.Stream;

public class MyType implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final MyType TYPE_01 = new MyType(1, "my-type-01");
	public static final MyType TYPE_02 = new MyType(2, "my-type-02");

	private final int id;
	private final String value;

	public MyType(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public static MyType of(int id) {
		return Stream.of(TYPE_01, TYPE_02).filter(type -> type.id == id).findFirst().orElseThrow();
	}

	public static MyType of(String value) {
		return Stream.of(TYPE_01, TYPE_02).filter(type -> type.value.equals(value)).findFirst().orElseThrow();
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}
