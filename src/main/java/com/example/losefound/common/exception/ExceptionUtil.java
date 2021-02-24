package com.example.losefound.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	public static String exceptionMessageGet(Exception exception) {
		  StringWriter sw = new StringWriter();
          PrintWriter pw = new PrintWriter(sw);
          exception.printStackTrace(pw);
		// TODO Auto-generated method stub
		return sw.toString();
	}

}
