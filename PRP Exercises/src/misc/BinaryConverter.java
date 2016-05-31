package misc;

public class BinaryConverter {

	public static void main(String[] args) {
		
		int decimal = 265;
		String binaryResult = "";
		
		for ( int d = decimal ; d > 0 ; d = d / 2 )
        {
			System.out.println("Component value: " + d + ". Remainder divided by 2 = " + (d % 2));
			binaryResult = d % 2 + binaryResult;
        }
		
		System.out.println(binaryResult);

	}

}
