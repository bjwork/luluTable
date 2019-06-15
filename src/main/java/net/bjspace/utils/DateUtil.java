package net.bjspace.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DateUtil {
	

	public static void main(String[] args) throws ParseException {

		// System.out.println(getNowDate());
//		List<String> list = new ArrayList<>();
//		for (int i = -4; i < 64; i++) {
//			System.out.println(getOneDay("2019-01-02", i));
//			list.add(getOneDay("2019-01-02", i));
//		}
//		System.out.println(list.toString());
//		
//		String tString = "1540010001";
//		System.out.println(tString.substring(0, 6));
//		
//		String ir = "00";
//		System.out.println(getDayDiff("2019-04-01","2019-04-30"));

//		Timestamp t = new Timestamp(System.currentTimeMillis());
//		System.out.println(t);
		//Date d = new Date(t.getTime());
//		long diffstr = DateUtil.getDayDiff("1991-01-20", "2017-07-26");
//		System.out.println(diffstr);
		// String a=DateToStr(d);
		// System.out.println(a);
		//
		// Date date = new Date();
		// System.out.println("日期转字符串：" + DateUtil.DateToStr(date));
		// System.out.println("字符串转日期：" +
		// DateUtil.StrToDate(DateUtil.DateToStr(date)));
		// dataAdd("20110823");

		//
		// String a=DateToStr2("20110823");
		//
		// System.out.println(a);
//		System.out.println(getCurrentTimeBeforeFive());
//		System.out.println(getCurrentTimeAfterFive());
//		System.err.println(getCurrentTimeToInt());
//		String week = getWeek();
//		System.out.println(week);
//		
//		System.err.println(getCurrentTimeBeforeFive());
//		System.err.println(getCurrentTimeNow());

	}
	
	

	/**
	 * 获取系统时间并以yyyy-MM-dd格式返回
	 * 
	 * @return
	 */
	public static String getCurDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = simpledateformat.format(calendar.getTime());
		return strDate;
	}

	/**
	 * 判断字符串是否为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 返回当前日期时间字符串<br>
	 * 默认格式:yyyy-mm-dd hh:mm:ss
	 * 
	 * @return String 返回当前字符串型日期时间
	 */
	public static String getCurrentTime() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}
	

	/**
	 * 返回当前日期时间字符串<br>
	 * 默认格式:yyyymmddhhmmss
	 * 
	 * @return String 返回当前字符串型日期时间
	 */
	public static BigDecimal getCurrentTimeAsNumber() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		returnStr = f.format(date);
		return new BigDecimal(returnStr);
	}

	/**
	 * 返回自定义格式的当前日期时间字符串
	 * 
	 * @param format
	 *            格式规则
	 * @return String 返回当前字符串型日期时间
	 */
	public static String getCurrentTime(String format) {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat(format);
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}

	/**
	 * 返回当前字符串型日期
	 * 
	 * @param format
	 *            格式规则
	 * 
	 * @return String 返回的字符串型日期
	 */
	public static String getCurDate(String format) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpledateformat = new SimpleDateFormat(format);
		String strDate = simpledateformat.format(calendar.getTime());
		return strDate;
	}

	/**
	 * 将字符串型日期转换为日期型
	 * 
	 * @param strDate
	 *            字符串型日期
	 * @param srcDateFormat
	 *            源日期格式
	 * @param dstDateFormat
	 *            目标日期格式
	 * @return Date 返回的util.Date型日期
	 */
	public static Date stringToDate(String strDate, String srcDateFormat,
			String dstDateFormat) {
		Date rtDate = null;
		Date tmpDate = (new SimpleDateFormat(srcDateFormat)).parse(strDate,
				new ParsePosition(0));
		String tmpString = null;
		if (tmpDate != null)
			tmpString = (new SimpleDateFormat(dstDateFormat)).format(tmpDate);
		if (tmpString != null)
			rtDate = (new SimpleDateFormat(dstDateFormat)).parse(tmpString,
					new ParsePosition(0));
		return rtDate;
	}

	/**
	 * 获取当前时间,并以 yyyy-MM-dd HH:mm:ss字符串格式输出
	 * 
	 * @author:mazhen
	 */
	public static String getNowDateAsStr() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return str
	 */
	public static String DateToStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);
		return str;
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return str
	 * @throws ParseException
	 */
	public static String dataAdd1(String date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		// System.out.println(sdf.format(rightNow.getTime()));
		// rightNow.add(Calendar.YEAR, -1);// 日期减1年
		// System.out.println(sdf.format(rightNow.getTime()));

		// rightNow.add(Calendar.MONTH, 3);// 日期加3个月
		// System.out.println(sdf.format(rightNow.getTime()));
		rightNow.add(Calendar.DAY_OF_YEAR, 1);// 日期加10天
		// System.out.println(sdf.format(rightNow.getTime()));
		return sdf.format(rightNow.getTime());

	}

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return str
	 * @throws ParseException
	 */
	public static String dataAdd2(String date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		// System.out.println(sdf.format(rightNow.getTime()));
		// rightNow.add(Calendar.YEAR, -1);// 日期减1年
		// System.out.println(sdf.format(rightNow.getTime()));

		// rightNow.add(Calendar.MONTH, 3);// 日期加3个月
		// System.out.println(sdf.format(rightNow.getTime()));
		rightNow.add(Calendar.DAY_OF_YEAR, 1);// 日期加10天
		// System.out.println(sdf.format(rightNow.getTime()));
		return sdf.format(rightNow.getTime());

	}

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return str
	 * @throws ParseException
	 */
	public static String dataAdd(String date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		// System.out.println(sdf.format(rightNow.getTime()));
		// rightNow.add(Calendar.YEAR, -1);// 日期减1年
		// System.out.println(sdf.format(rightNow.getTime()));

		// rightNow.add(Calendar.MONTH, 3);// 日期加3个月
		// System.out.println(sdf.format(rightNow.getTime()));
		rightNow.add(Calendar.DAY_OF_YEAR, 1);// 日期加10天
		// System.out.println(sdf.format(rightNow.getTime()));
		return sdf.format(rightNow.getTime());

	}

	public static String dateCha(Date start_time, Date end_time) {
		String datestr = "";
		try {
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// java.util.Date now = df.parse(start_time);
			// java.util.Date date=df.parse(end_time);
			// long l=now.getTime()-date.getTime();
			long l = end_time.getTime() - start_time.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			datestr = "" + day + "天" + hour + "小时" + min + "分" + s + "秒";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return datestr;
		// System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
	}

	public static boolean isDateBefore(Date date2) {
		Date date1 = new Date();// 当前时间
		return date2.before(date1);
	}

	public static Date isDateBefore(Date date1, Date date2) {
		return date1.before(date2) == true ? date1 : date2;
	}

	public static Date isDateAfter(Date date1, Date date2) {
		return date1.before(date2) == true ? date2 : date1;
	}

	/**
	 * 获取最小的时间
	 * 
	 * @return
	 */
	public static Date minTime_date(String start_time, String func_start_time) {
		Date start_time_date = getDateByString(start_time);
		Date func_start_time_date = getDateByString(func_start_time);
		return isDateBefore(start_time_date, func_start_time_date);
	}

	/**
	 * 获取最小的时间
	 * 
	 * @return
	 */
	public static Date maxTime_date(String start_time, String func_start_time) {
		Date start_time_date = getDateByString(start_time);
		Date func_start_time_date = getDateByString(func_start_time);
		return isDateAfter(start_time_date, func_start_time_date);
	}

	/**
	 * 获取最小的时间
	 * 
	 * @return
	 */
	public static Date minTime_date(Date start_time, Date func_start_time) {
		return isDateBefore(start_time, func_start_time);
	}

	/**
	 * 获取最小的时间
	 * 
	 * @return
	 */
	public static Date maxTime_date(Date start_time, Date func_start_time) {
		return isDateAfter(start_time, func_start_time);
	}

	public static Date DateByTimestamp(Timestamp t) {
		Date d = new Date(t.getTime());
		return d;
	}

	public static Date getDateByString(String dateString) {
		// String dateString = "2012-12-06 ";
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return date;
	}

	/**
	 * 输入两个日期相差的天数
	 * 
	 * 
	 * @return String 返回当前字符串型日期时间
	 */
	public static long getDayDiff(String beginDay, String endDay) {
		long diffDay = -1;

		if (beginDay == null || beginDay.equals("")) {
			return diffDay;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = sdf.parse(beginDay);
			endDate = sdf.parse(endDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long diffTime = endDate.getTime() - beginDate.getTime();
		long nd = 1000 * 24 * 60 * 60;
		diffDay = diffTime / nd;
		// double age = diffDay/365.0;

		return diffDay;
	}

	/**
	 * 去掉日期里的 空格-:
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateNoSign(String date) {
		String time = date;
		time = time.replace("-", " ");
		time = time.replace(":", " ");
		time = time.replace(" ", "");
		return time;
	}

	/**
	 * 将毫秒转换成日期格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param millisecond
	 * @return
	 */
	public static String milliSecondToDate(long millisecond) {
		// long millisecond = 1483159625851l;
		Date date = new Date(millisecond);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}

	/**
	 * 将日期格式yyyy-MM-dd HH:mm:ss转换成毫秒
	 * 
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static long dateToMilliSecond(String dateTime) throws ParseException {
		// String dateTime = "2016-12-31 12:30:45";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.parse(dateTime));
		return calendar.getTimeInMillis();
	}
	

	/**
	 * 获取当前时间String类型返回：HH:mm:ss
	 * @return
	 */
	public static String getCurrentTimeToInt() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}
	
	
	/**
	 * 获取当前周几String类型返回：星期*
	 * @return
	 */
	public static String getWeek() {
		Date date=new Date();
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		String format = dateFm.format(date);
		return format;
	}
	
	/**
	 * 获取当前几号int类型返回：dd
	 * @return
	 */
	public static int getTodayDay() {
		//int y,m,d,h,mi,s;    
		int d;    
		Calendar cal=Calendar.getInstance();    
		//y=cal.get(Calendar.YEAR);    
		//m=cal.get(Calendar.MONTH);    
		d=cal.get(Calendar.DATE);    
		//h=cal.get(Calendar.HOUR_OF_DAY);    
		//mi=cal.get(Calendar.MINUTE);    
		//s=cal.get(Calendar.SECOND);    
		//System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒"); 
		return d;
	}
	
	/**
	* 获取当前时间前5分钟,返回int类型HHmmss
	* @param stuff
	* @return
	*/
	public static int getCurrentTimeBeforeFive(){
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Calendar beforeTime = Calendar.getInstance();
		beforeTime.add(Calendar.MINUTE, -5);// 5分钟之前的时间
		Date beforeD = beforeTime.getTime();
		String time = sdf.format(beforeD);
		return Integer.valueOf(time); 
	}
	
	/**
	 * 获取当前时间,返回int类型HHmmss
	 * @param stuff
	 * @return
	 */
	public static int getCurrentTimeNow(){
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String time = sdf.format(new Date());
		return Integer.valueOf(time); 
	}
	
	/**
	 * 获取当前时间后5分钟,返回int类型HHmmss
	 * @param stuff
	 * @return
	 */
	public static int getCurrentTimeAfterFive(){
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Calendar afterTime = Calendar.getInstance();
		afterTime.add(Calendar.MINUTE, 5);// 5分钟之后的时间
		Date beforeD = afterTime.getTime();
		String time = sdf.format(beforeD);
		return Integer.valueOf(time); 
	}
	
	
	public static LinkedList<String> getNowadayYear() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("MM");
		String strDate = simpledateformat.format(calendar.getTime());
		Integer month = Integer.valueOf(strDate);
		LinkedList<String> months = new LinkedList<String>();
		for (int i = 0; i < month; i++) {
			calendar.setTime(new Date());  
			calendar.add(Calendar.MONTH, -(month-i-1));  
			Date date = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String string = sdf.format(date);
			months.add(string);
		}
		return months;
	}
	
	public static LinkedList<String> getNowadayMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd");
		String strDate = simpledateformat.format(calendar.getTime());
		Integer day = Integer.valueOf(strDate);
		LinkedList<String> days = new LinkedList<String>();
		for (int i = 0; i < day; i++) {
			calendar.setTime(new Date());  
			calendar.add(Calendar.DATE, -(day-i-1));  
			Date date = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String string = sdf.format(date);
			days.add(string);
		}
		return days;
	}
	
	public static Map<String, Object> getNowadayWeek() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
		LinkedList<String> days = new LinkedList<String>();
		LinkedList<String> weeks = new LinkedList<String>();
		for (int i = 0; i < week; i++) {
			calendar.setTime(new Date());  
			calendar.add(Calendar.DATE, -(week-i-1));  
			Date date = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String string = sdf.format(date);
			days.add(string);
			weeks.add(weekDays[i]);
		}
		map.put("days", days);
		map.put("weeks", weeks);
		return map;
	}
	
	/**
	 * MODULE   : 获取今天前多少天的日期
	 * ABSTRACT : 
	 * @param num 可以是正数和负数
	 * @return yyyy-MM-dd
	 * @note    : 
	 */
	public static String getOneDay(int num) {
		Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE, num);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String date=sp.format(d);
        return date;
	}	
	
	/**
	 * MODULE   : 获取某天前多少天的日期
	 * ABSTRACT : 
	 * @param day yyyy-MM-dd
	 * @param num 可以是正数和负数
	 * @return yyyy-MM-dd
	 * @throws ParseException 
	 * @note    : 
	 */
	public static String getOneDay(String day, int num) throws ParseException {
		Calendar cal=Calendar.getInstance();
		long milliSecond = dateToMilliSecond(day + " 00:00:00");
		cal.setTimeInMillis(milliSecond);
		//Date d=new Date(milliSecond + 1000*60*60*24*num);
		cal.add(Calendar.DATE, num);
        Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		String date = sp.format(d);
		return date;
	}	
	
	/**
	 * MODULE   : 获取日期前多少小时的时间
	 * ABSTRACT : 
	 * @param dateTime yyyy-MM-dd HH:mm:ss
	 * @param num 可以是正数和负数
	 * @return yyyy-MM-dd HH:mm:ss
	 * @throws ParseException 
	 * @note    : 
	 */
	public static String getOneTime(String dateTime, int num) throws ParseException {
		Calendar cal=Calendar.getInstance();
		long milliSecond = dateToMilliSecond(dateTime);
		cal.setTimeInMillis(milliSecond);
		cal.add(Calendar.HOUR, num);
        Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sp.format(d);
		return date;
	}	
	
}
