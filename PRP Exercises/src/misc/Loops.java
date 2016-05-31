package misc;
import java.util.Arrays;


public class Loops {

	public static void main(String[] args) {
		
		int[] data = new int[11];
		
		// Is there any common pattern? Nope. Instantiate from outset.
		//2 3 10 15 11 22 13 100 -5
		int [] data2 = {2, 3, 10, 15, 11, 23, 13, 100, -5};
		
		// No Common pattern... just initialise. 
		//0 0 0 0 0 0 0 0 0 0
		int[] Data = new int[10];
				
		//1 2 3 4 5 6 7 8 9 10
		// Work out relationship between content of array and loop index
		for (int i = 0; i < 10; i++) {
			data[i] = i + 1;
		}
		
		//0 2 4 6 8 10 12 14 16 18
		// Work out relationship between array and index of loop
		for (int i = 0; i < 10; i++) {
			data[i] = i * 2;
		}
		
		//1 4 9 16 25 36 49 64 81 100
		// Again, connection between values in loop and content of
		// array
		for (int i = 0; i <= 10; i++) { // i = 1
			data[i] = (i+1) * (i+1); //i * i
		}	
		
		//Fibonnaci:
		// 0 1 1 2 3 5 8 13 21 34
		// Using the content of the array more
		// Change start of array;
		// Pattern only starts at position 2 - change start.
		// Start off with initial values and work from there
		data[0] = 0;
		data[1] = 1;
		for (int i = 2; i < 10; i++) {
			data[i] = data[i-2] + data[i-1];
		}
		
		// 1 -1 2 -2 3 -3 4 -4 5 -5
		// - Imagine '-' wasn't there: things don't change each time, but every two. 
		// So change increment to every two.
		// - However now we reduce the relationship between the loop
		// values and the information we want in the array;
		// no real relationship between array positions (loop
		// values) and content of array (could do if start at 2)
		// - Maintain a separate number for the content
		// - Increment that separate number by itself - because
		// loop increment changed
		int z=1;
		for (int i = 0; i < 10; i+=2) { // i=2
			data[i] = (i+1)/2;
			data[i+1] = -((i+1)/2);
			z++;
		}
		
		System.out.println(Arrays.toString(data));
		
		int data3[][] = new int[5][5];
		
		// Reiterate how inner loop works: All iterations of inner loop
		// for one of outer.
		// 1 -> 5
		//   1 -> 5 (15 times of inner)
		
		// 1. Draw out as Matrix first to determine bounds of loop
		// Outerloop controls left of matrix; inner top.
		// Write out parts of loop next matrix
		// 2. Work out how information from row or column can be used
		// 2.1 Where to start - working out the 'plus bit'
		// Doesn't actually use j, except for index
		// 1 1 1 1 1, 2 2 2 2 2, 3 3 3 3 3, 4 4 4 4 4, 5 5 5 5 5
		for (int i = 0; i < 5; i++) { // i = 1
			for (int j = 0; j < 5; j++) {
				data3[i][j] = i + 1; // i
			}
		}
		
		// 2 4 6 8 10, 3 6 9 12 15, 4 8 12 16 20, 5 10 15 20 25, 6 12 28 24 30
		// Connection between first number and outer loop
		// Two times table
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				data3[i][j] = (i+2)*(j+1);
			}
		}
				
		// 1 2 3 4 5, 6 7 8 9 10, 11 12 13 14 15, 16 17 18 19 20, 21 22 23 24 25
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				data3[i][j] = (i*5)+(j+1); // j (j+1) increments each time; i*5 sets 'base'
			}
		}
		
		
		
		// How do we turn something negative? Multiply by -1
		int sign = 1;
		
		// 1 2 3 4 5, -6 -7 -8 -9 -10, 11 12 13 14 15, -16 -17 -18 -19 -20, 21 22 23 24 25
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				data3[i][j] = (i*5)+(j+1) * sign;
			}
			// Something happens after each loop i.e. changing sign
			sign = sign *(-1);
		}
			
		// 2 4 6 8 10, 3 6 9 12 15, 4 8 12 16 20, 5 10 15 20 25, 6 12 28 24 30
		// Connection between first number and outer loop
		// Two times table
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				data3[i][j] = (i+2)*(j+1);
			}
			sign = sign *(-1);
		}
		
		// No need for brackets
		System.out.println(5*-1);
		System.out.println(5*(-1));
		
		for (int[] data4 : data3) {
			System.out.println(Arrays.toString(data4));
		}
	}
	
}
