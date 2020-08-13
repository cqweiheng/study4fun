package com.study07Collection;

public enum WeekdayEnum {

	MONDAY("星期一", 1),TUESDAY("星期二",2)
	,WEDNESDAY("星期三", 3),THURSDAY("星期四", 4)
	,FRIDAY("星期五", 5),SATUARDAY("星期六", 6)
	,SUNDAY("星期日", 0);

	private String name;

	private int index;

	WeekdayEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
