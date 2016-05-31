package misc;

public class LabTest {

	public static void main(String[] args) {
		
		for(int i = 10;i < 100;++i)
		{
			if(((i/10)+(i%10))%2 == 1)
			{
				System.out.println(i/10 + " " + i%10);
				System.out.println(i);
			}
		}
		
		// Outer loop controls '10s'
		for(int i = 1;i < 10;++i)
		{
			// Inner loop controls units
			for(int j = 0;j < 10;++j)
			{
				if((i+j) % 2 == 1)
				{
					System.out.println(i+""+j);
				}
			}
		}
		
		//
		// Go through each item from the 'b' times table (i*a), with
		// i controlling the position, and if a number from this table
		// divides wholly into the second number, it is also from the
		// 'a' times table. 
		int b = 6;
		int a = 9;

		for(int i = 1; i <= b; i++) {
		    if(i*a % b == 0) {
		        System.out.println(i*a);
		    	return;
		    }
		}
	
	}
	
}
