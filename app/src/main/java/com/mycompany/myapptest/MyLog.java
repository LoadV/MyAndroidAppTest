package com.mycompany.myapptest;
import java.io.*;
import android.util.*;

public class MyLog
{
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
