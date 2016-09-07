package com.mytools.base;

public abstract class ToolsBase {

	public static boolean isNull(Object o) {

		if (null == o || "".equals(o))
			return true;
		else
			return false;
	}
}
