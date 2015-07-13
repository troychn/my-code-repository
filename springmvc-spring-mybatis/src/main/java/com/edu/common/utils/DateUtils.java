/*
 *  Copyright 2014-2015 snakerflow.com
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */
package com.edu.common.utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * Created by lc on 2015/6/4.
 *
 */
public class DateUtils {
	public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";
	public static final String DATE__YMD = "yyyy年MM月dd日";
	public static final String DATE_FORMAT_YM="yyyy-MM";
	public static final String DATE_YM="yyyy年MM月";
	
	public static String getCurrentTime() {
		return new DateTime().toString(DATE_FORMAT_DEFAULT);
	}
	
	public static String getCurrentDay() {
		return new DateTime().toString(DATE_FORMAT_YMD);
	}
	public static String getCurrentDay2() {
		return new DateTime().toString(DATE__YMD);
	}
	
	public static String getCurrentMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_YM);
		return df.format(c.getTime());
	}
	
	public static String getLastMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH,-1);
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_YM);
		return df.format(c.getTime());
	}
	public static String getLastMonth2() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH,-1);
		SimpleDateFormat df = new SimpleDateFormat(DATE_YM);
		return df.format(c.getTime());
	}
	
	public static String parseDate(Date datetime) {
		SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT_DEFAULT);
		return sdf.format(datetime);
	}
	

	public static String getCurrentMonth2() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		SimpleDateFormat df = new SimpleDateFormat(DATE_YM);
		return df.format(c.getTime());
	}
	public static void main(String[] args) {
		
		
		System.out.println(DateUtils.getCurrentMonth());
	}
}
