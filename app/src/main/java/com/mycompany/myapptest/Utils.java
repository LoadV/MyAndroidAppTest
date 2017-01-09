package com.mycompany.myapptest;
import java.text.*;
import java.util.*;

public class Utils
{
	public static String getLogTime()
	{
		StringBuilder sb = new StringBuilder("");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sb.append( formatter.format(System.currentTimeMillis()));
		return sb.toString();
	}
}
