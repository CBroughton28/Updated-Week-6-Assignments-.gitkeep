package src;
import java.util.Scanner;
import java.util.regex.Pattern;
import src.RationalNumber.Rational;
	

	public class RationalNumberCalculator
	{
		private static Scanner input;

		public static void main(String[] args)
		{
			input = new Scanner(System.in);
			
			System.out.println("Accepted operands:   +   -   *   \\");
			System.out.println("Use '/' to denote rational, e.g. 3/4");
			System.out.println("Use '\\' for dividing, e.g. 3/4 \\ 1/2\r\n");
			System.out.print("Enter rational calculation: ");
			
			String operation = input.nextLine();
			
			char operand = getOperand(operation);
			Rational r1 = getRational1(operation, operand);
			Rational r2 = getRational2(operation, operand);
	

			System.out.println(operation + " = " + getResult(r1, r2, operand));
		}
	
		public static Rational getRational1(String operation, char operand)
		{
	
			String[] parts = operation.split(Pattern.quote("/"));
			
			int numerator = Integer.parseInt(parts[0]);
			
			parts[1] = removeOperand1(parts[1], operand);	
			int denominator = Integer.parseInt(parts[1]);
			
			Rational rationalTemp = new Rational(numerator, denominator);
			return rationalTemp;
		}
		
		public static Rational getRational2(String operation, char operand)
		{
		
			String[] parts = operation.split(Pattern.quote("/"));
			
			parts[1] = removeOperand2(parts[1], operand);
			int numerator = Integer.parseInt(parts[1]);
			
			int denominator = Integer.parseInt(parts[2]);
			
			Rational rationalTemp = new Rational(numerator, denominator);
			return rationalTemp;
		}
	

		public static String removeOperand1(String string, char operand)
		{
		
			String newString = string.substring(0, string.indexOf(operand) - 1);
	
			newString = newString.trim();
	

			return newString;
		}
	

		public static String removeOperand2(String string, char operand)
		{
		
			String newString = string.substring(string.indexOf(operand) + 1, string.length());
	
			newString = newString.trim();
			
			return newString;
		}
		
		public static char getOperand(String operation)
		{
			String[] parts = operation.split(Pattern.quote("/"));
			
			if (parts[1].contains("+"))
			{
				return '+';
			}
			else if (parts[1].contains("-"))
			{
				return '-';
			}
			else if (parts[1].contains("*"))
			{
				return '*';
			}
			else if (parts[1].contains("\\"))
			{
				return '\\';
			}
			else
			{
				return ' ';	
			}
		}
		
		public static Rational getResult(Rational r1, Rational r2, char operand)
		{
			Rational rational = new Rational();
			switch (operand)
			{
			case '+':
				rational = r1.add(r2);
				break;
			case '-':
				rational = r1.subtract(r2);
				break;
			case '*':
				rational = r1.multiply(r2);
				break;	
			case '\\':
				rational = r1.divide(r2);
			}
			return rational;
		}
	

	}

