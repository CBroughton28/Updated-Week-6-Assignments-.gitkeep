package src;
import java.text.DateFormatSymbols;
import java.time.YearMonth;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


class Calendar {
	
		private static final String MONTH = null;
		private static final String YEAR = null;
		private static Scanner input;


		public static void main(String[] args)
	{
			input = new Scanner(System.in);
		
			System.out.print("Enter full year (e.g., 2012), -1 to skip: ");
			int year = input.nextInt();
		

			
			System.out.print("Enter month as a number between 1 and 12, -1 to skip: ");
			int month = input.nextInt();
		

			if (year == -1)
	{
			year = getCurrentYear();
	}
			if (month == -1)
	{
			month = getCurrentMonth();
	}
		

		GregorianCalendar gCalendar = new GregorianCalendar(year, month - 1, 1);
		

			printMonth(gCalendar);
	}
		

		public static int getCurrentMonth()
	{
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
		
		return calendar.get(Calendar.MONTH) + 1;
	}
		

		private int get(String month2) {
			return 0;
		
		}


		private static Calendar getInstance() {
		
			return null;
		}


		private void setTime(Date date) {
		
			
		}


		public static int getCurrentYear()
	{
		
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
		

		return calendar.get(Calendar.YEAR);
	}
		

		
		public static void printMonth(GregorianCalendar gCalendar)
	{
				
			printMonthTitle(gCalendar);
		
			printMonthBody(gCalendar);
	}
		
		public static void printMonthTitle(GregorianCalendar gCalendar)
	{
			System.out.println(" " + getMonthName(gCalendar) + " " + gCalendar.get(GregorianCalendar.YEAR));
			System.out.println("-----------------------------");
			System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
		
		public static String getMonthName(GregorianCalendar gCalendar)
	{
			String monthName = new DateFormatSymbols().getMonths()[gCalendar.get(GregorianCalendar.MONTH)];
		

			return monthName;
	}
		

	
		public static void printMonthBody(GregorianCalendar gCalendar)
	{
			
			int startDay = getStartDay(gCalendar);
		

		int numberOfDaysInMonth = getNumberOfDaysInMonth(gCalendar);
		

		int i = 0;
		for (i = 0; i < startDay; i++)
			System.out.print("    ");
		

		for (i = 1; i <= numberOfDaysInMonth; i++)
	{
		System.out.printf("%4d", i);
		

		if ((i + startDay) % 7 == 0)
		System.out.println();
	}
		

		System.out.println();
	}
		

		
		public static int getStartDay(GregorianCalendar gCalendar)
	{
		YearMonth yearMonth = YearMonth.of(gCalendar.get(GregorianCalendar.YEAR),
			gCalendar.get(GregorianCalendar.MONTH) + 1);
		int startDay = yearMonth.atDay(1).getDayOfWeek().getValue();
				
		if (startDay == 7)
			startDay = 0;
				
		return startDay;
	}
		

		public static int getNumberOfDaysInMonth(GregorianCalendar gCalendar)
	{
		return gCalendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	}
		

		public static boolean isLeapYear(GregorianCalendar gCalendar)
	{
		return gCalendar.isLeapYear(gCalendar.get(GregorianCalendar.YEAR));
	}
}