package com.mycompany.myapptest;
import java.text.*;
import java.util.*;
import java.io.FileOutputStream;
import java.io.File;
import android.util.Log;

public class Utils
{
	public static String getLogTime()
	{
		StringBuilder sb = new StringBuilder("");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sb.append( formatter.format(System.currentTimeMillis()));
		return sb.toString();
	}
	public static void log2File(String log)
	{
		try{
			FileOutputStream fos = new FileOutputStream(new File("/sdcard/myLog.log"),true);
			fos.write((Utils.getLogTime()+ ":"+log+"\n").getBytes());
			fos.close();}
		catch(Exception e)
		{
			Log.i("E",e.toString());
		}
	}
}
