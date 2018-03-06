package com.my.color.base.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 不要日期的时间格式
	private final static SimpleDateFormat noDateTime = new SimpleDateFormat("HH:mm:ss");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	 * 日期比较，如果s>=e 返回true 否则返回false
	 */
	public static boolean compareDate(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() >= fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期 只需要日期
	 * @return
	 */
	public static Date fomatDateForSimple(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期 只需要时间
	 * 
	 * @return
	 */
	public static Date fomatDateForTime(String date) {
		DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		String date1 = date;
		if (date.length() > 10) {
			date1 = date.substring(10);
		}
		try {
			return fmt.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期字符串
	 * 
	 * @return
	 */
	public static String fomatDate(Date date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fmt.format(date);
	}

	/**
	 * 格式化日期字符串(只取年月日)
	 * 
	 * @return
	 */
	public static String simplefomatDate(Date date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(date);
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	/**
	 * 得到相隔几年
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
					/ 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * <li>功能描述：时间相减得到天数(参数为日期)
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(Date beginDateStr, Date endDateStr) {
		long day = 0;
//		day = (endDateStr.getTime() - beginDateStr.getTime()) / (24 * 60 * 60 * 1000);
		day = (endDateStr.getDate() - beginDateStr.getDate()) ;
		return day;
	}

	/**
	 * 根据起止时间得到间隔天数数组
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return
	 */
	public static ArrayList<String> getDaysByTime(String beginDateStr, String endDateStr) {
		long days = getDaySub(beginDateStr, endDateStr);
		// 开始计时日期
		Date startDate = DateUtils.fomatDateForSimple(beginDateStr);
		Date date = null;
		Calendar curr = Calendar.getInstance();
		ArrayList<String> dayGroup = new ArrayList<>();
		curr.setTime(startDate);

		for (int i = 0; i < days - 1; i++) {
			curr.add(Calendar.DATE, 1);
			date = curr.getTime();
			dayGroup.add(DateUtils.simplefomatDate(date));
		}
		return dayGroup;
	}

	/**
	 * 根据起止时间得到间隔天数数组
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return
	 */
	public static ArrayList<String> getDaysByTime(Date beginDateStr, Date endDateStr) {
		long days = getDaySub(beginDateStr, endDateStr);
		Date date = null;
		Calendar curr = Calendar.getInstance();
		ArrayList<String> dayGroup = new ArrayList<>();
		curr.setTime(beginDateStr);

		for (int i = 0; i < days -1; i++) {
			curr.add(Calendar.DATE, 1);
			date = curr.getTime();
			dayGroup.add(DateUtils.simplefomatDate(date));
		}
		return dayGroup;
	}

	/**
	 * 时间相减得到分钟数
	 * 
	 * @param 开始时间
	 *            结束时间 输入格式为"yyyy-MM-dd HH:mm:ss"
	 * @return 相差分钟数
	 * @throws ParseException
	 */
	public static long getMinutes(String starttime, String endtime) throws ParseException {
		Date start = sdfTime.parse(starttime);
		Date end = sdfTime.parse(endtime);
		// 将时间转成秒 相减除以六十
		long seconds = end.getTime() - start.getTime();
		long num = seconds / (60 * 1000);
		return num;
	}

	/**
	 * 得到相隔几小时
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getDiffHour(String startTime, String endTime) throws ParseException {
		Date start = noDateTime.parse(startTime);
		Date end = noDateTime.parse(endTime);
		// 将时间转成秒 相减除以六十
		long seconds = end.getTime() - start.getTime();
		long num = seconds % (60 * 60 * 1000);
		return num;
	}

	/**
	 * 得到相隔几小时
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDiffHour(Date startTime, Date endTime) throws ParseException {
		int start = startTime.getHours();
		int end = endTime.getHours();
		int minuteDifference = endTime.getMinutes() - startTime.getMinutes();
		
		if(minuteDifference>=0){
			return end - start;	
		}else{
			return end - start - 1;	
		}				
	}

	/**
	 * 获取当前时间之前或之后几分钟 minute
	 */
	public static String getTimeByMinute(int minute) {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MINUTE, minute);

		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 根据输入参数获取指定日期指定几年 几月 几周 几天 后的日期
	 * 
	 * @param number
	 *            递增数量
	 * @param type
	 *            递增类型 周期类型 1,年 2,月 3,周 4,日
	 * @param startDate
	 *            起始日期 格式为"yyyy-MM-dd"
	 * @return
	 * @throws Exception
	 */
	public static String getDayByCondition(String Startdate, Integer number, Integer type) throws Exception {
		Date Startdate1 = DateUtils.fomatDateForSimple(Startdate);
		Calendar curr = Calendar.getInstance();
		curr.setTime(Startdate1);
		Date date = null;
		switch (type) {
		case 1:
			curr.add(Calendar.YEAR, number);
			date = curr.getTime();
			break;
		case 2:
			curr.add(Calendar.MONTH, number);
			date = curr.getTime();
			break;
		case 3:
			curr.add(Calendar.DATE, number * 7);
			date = curr.getTime();
			break;
		case 4:
			curr.add(Calendar.DATE, number);
			date = curr.getTime();
			break;
		default:
			throw new Exception("请输入指定周期类型: 1,年 2,月 3,周 4,日");
		}
		return DateUtils.simplefomatDate(date);
	}

	/**
	 * 获取当前日期指定几年 几月 几周 几天 后的日期
	 * 
	 * @param number
	 *            递增数量
	 * @param type
	 *            递增类型 周期类型 1,年 2,月 3,周 4,日
	 * @return
	 * @throws Exception
	 */
	public static String getDayByCondition(Integer number, Integer type) throws Exception {
		Calendar curr = Calendar.getInstance();
		Date date = null;
		switch (type) {
		case 1:
			curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + number);
			date = curr.getTime();
			break;
		case 2:
			curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + number);
			date = curr.getTime();
			break;
		case 3:
			curr.set(Calendar.DAY_OF_MONTH, curr.get(Calendar.DAY_OF_MONTH) + number * 7);
			date = curr.getTime();
			break;
		case 4:
			curr.set(Calendar.DATE, curr.get(Calendar.DATE) + number);
			date = curr.getTime();
			break;
		default:
			throw new Exception("请输入指定周期类型: 1,年 2,月 3,周 4,日");
		}
		return DateUtils.simplefomatDate(date);

	}

	/**
	 * 
	 * @param 得到一个随机的id
	 * @return
	 */
	public static String getRandomId() {
		Long companyOrgId1 = new Date().getTime();
		String companyOrgId2 = companyOrgId1.toString().substring(7);
		Double double1 = 100 * Math.random();
		return companyOrgId2 + double1.intValue();
	}

	/**
	 * 得到n天之前的日期
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public static String getBeforeDayDate(String afterDay, Integer days) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(afterDay);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// Calendar canlendar = Calendar.getInstance(); // java.util包
		calendar.add(Calendar.DATE, -days); // 日期减 如果不够减会将月变动
		Date beforeDate = calendar.getTime();
		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(beforeDate);

		return dateStr;
	}

	/**
	 * 获取当年的第一天
	 * 
	 * @param year
	 * @return
	 */
	public static String thisYearFirst() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return simplefomatDate(calendar.getTime());
	}

	/**
	 * 获取当年的最后一天
	 * 
	 * @param year
	 * @return
	 */
	public static String thisYearLast() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		return simplefomatDate(calendar.getTime());
	}

	/**
	 * 两个日期之间相差 计算相差时以各自单位为准，例如2014年12月31日与2015年1月1日之间相差的年数是1
	 * 
	 * @param fromDate
	 *            开始日期
	 * @param toDate
	 *            结束日期
	 * @param unit
	 *            单位：Calendar.YEAR,MONTH,DATE,HOUR,MINUTE,SECOND,MILLISECOND
	 * @return 根据单位计算得到相差的数量，如果开始日期晚于结束日期返回负数
	 */
	public static int between(Calendar from, Calendar to, int unit) {
		int fromInt, toInt;
		switch (unit) {
		case Calendar.YEAR:
			return to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
		case Calendar.MONTH:
			int year = to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
			int month = to.get(Calendar.MONTH) - from.get(Calendar.MONTH);
			return year * 12 + month;
		case Calendar.DATE:
			fromInt = (int) (from.getTimeInMillis() / (24 * 60 * 60 * 1000L));
			toInt = (int) (to.getTimeInMillis() / (24 * 60 * 60 * 1000L));
			return toInt - fromInt;
		case Calendar.HOUR:
		case Calendar.HOUR_OF_DAY:
			fromInt = (int) (from.getTimeInMillis() / (60 * 60 * 1000L));
			toInt = (int) (to.getTimeInMillis() / (60 * 60 * 1000L));
			return toInt - fromInt;
		case Calendar.MINUTE:
			fromInt = (int) (from.getTimeInMillis() / (60 * 1000L));
			toInt = (int) (to.getTimeInMillis() / (60 * 1000L));
			return toInt - fromInt;
		case Calendar.SECOND:
			fromInt = (int) (from.getTimeInMillis() / (60 * 1000L));
			toInt = (int) (to.getTimeInMillis() / (60 * 1000L));
			return toInt - fromInt;
		case Calendar.MILLISECOND:
			return (int) (to.getTimeInMillis() - from.getTimeInMillis());
		default:
			throw new IllegalArgumentException("Unknown Date Unit: " + unit);
		}
	}

	/**
	 * 两个日期之间相差 计算相差时以各自单位为准，例如2014年12月31日与2015年1月1日之间相差的年数是1
	 * 
	 * @param fromDate
	 *            开始日期
	 * @param toDate
	 *            结束日期
	 * @param unit
	 *            单位：Calendar.YEAR,MONTH,DATE,HOUR,MINUTE,SECOND,MILLISECOND
	 * @return 根据单位计算得到相差的数量，如果开始日期晚于结束日期返回负数
	 */
	public static int between(Date fromDate, Date toDate, int unit) {
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.setTime(fromDate);
		to.setTime(toDate);
		return between(from, to, unit);
	}

	public static void main(String[] args) throws ParseException {

		/*
		 * long i = getDiffHour("2017-5-18 12:19:58", "2017-5-20 16:20:00");
		 * Date am = DateUtils.fomatDateForTime("11:10:10"); Date halfTime =
		 * DateUtils.fomatDateForTime("12:12:13"); long e = getDiffHour(am,
		 * halfTime); System.out.println(e);
		 * System.out.println(am.before(halfTime));
		 */
		//String newPassWord = PasswordUtils.SHA1("123456", "18155555555");
		
		BigDecimal a = new BigDecimal(33322.34);
		BigDecimal b = new BigDecimal(5490);
		System.out.println(a.compareTo(b));
	}

}