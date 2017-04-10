package src;

public class Octagon {

	
			public static void main(String[] args)
			{

				Octagon octagon1 = new Octagon(5);
		
				System.out.println("Size of sides: " + octagon1.getSideSize());
				System.out.println("Area: " + octagon1.getArea());
				System.out.println("Perimeter: " + octagon1.getPerimeter());
		

				Octagon octagon2 = (Octagon)octagon1.clone();
				
				System.out.println("octagon1 compared to octagon2: " + octagon1.compareTo(octagon2));
			}

			private double sideSize;
		

			public Octagon()
			{
				sideSize = 0;
			}
		

			public Octagon(double Side)
			{
				sideSize = Side;
			}
		

			public double getSideSize()
			{
				return sideSize;
			}
		

			public double getArea()
			{
				return (2 + 4 / Math.sqrt(2)) * sideSize * sideSize;
			}
		

			public double getPerimeter()
			{
				return sideSize * 8;
			}
			
			public int compareTo(Octagon o)
			{
				if (getArea() > o.getArea())
					return 1;
				else if (getArea() < o.getArea())
					return -1;
				else
					return 0;
			}
		
		
			public Object clone()
			{
				try
				{
					Octagon octagonClone = (Octagon)super.clone();
					return octagonClone;
				}
				catch (CloneNotSupportedException ex)
				{
					return null;
				}
			}
	}

