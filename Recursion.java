//Ian McCray (im3vy)
//17 April 2018
//HW7

import java.awt.Color;

public class Recursion {
	
	/*reverseString, places last character at beginning and reduces 
	 * string by character
	 */
	public static String reverseString(String s) {
		if(s.length() == 0)
			return s;
		return s.charAt(s.length()-1) + reverseString(s.substring(0, s.length()-1));
	}
	
	/*countWays, splits up number of steps into subtrees to determine
	 * how many steps there are
	 */
	public static int countWays(int numStairs) {
		
		if(numStairs == 0)
			return 0;
		
		if(numStairs == 1)
			return 1;
		
		if(numStairs == 2)
			return 2;
		

		return countWays(numStairs-2) + countWays(numStairs-1);
	}

	/*Ackermann, performs the Ackermann function on two ints
	 * m and n
	 */
	public static int Ackermann(int m, int n) {
		if(m == 0)
		    return n+1;
		else if(m > 0 && n == 0)
			return Ackermann(m-1, 1);
		else if(m > 0 && n >0)
			return Ackermann(m-1, Ackermann(m, n-1));
		else
			return -1;
	}
	
	/*handShakes, finds total int of hand shakes given n people
	 * if they shake every other person's hand
	 */
	public static int handShakes(int n) {
		if(n == 2)
			return 1;
		return (n-1) + handShakes(n-1);
	}
	
	/*helper method for squareRoot, given a double x find its
	 * square root by incrementing closer and closer to a better
	 * guess
	 */
	public static double squareRootGuess(double x, double g) { //TA helped me write this method
		
		final double restraint = .0001;
		
		if(Math.abs(x-g*g) < restraint)
			return g;
		else
			return squareRootGuess(x, (0.5 * (g+x/g)));
	}
	
	/*implements squareRootGuess
	 */
	public static double squareRoot(double x) {
		return squareRootGuess(x, 5);
	}
	

	/*given a Turtle of specified depth and size, draw a snowflake 
	 * go forward if there is no more depth to obtain
	 * divide size by 3 and turn in increments of 60 and 120
	 * to draw a smaller triangle on the sides of the previous
	 * larger triangle and repeat
	 */
	public static void drawSnowflake(Turtle t, int depth, double size){ //TA helped me write this method
		if(depth == 0)
			t.forward(size);
		else {
			
			drawSnowflake(t, depth-1, size/3);
			t.left(60);
			drawSnowflake(t, depth-1, size/3);
			t.right(120);
			drawSnowflake(t, depth-1, size/3);
			t.left(60);
			drawSnowflake(t, depth-1, size/3);
			
		}
	}
	
	/*implements drawSnowflake three times for each side
	 * of the triangle
	 */
	public static void snowflake(Turtle t, int depth, double size) {	
			for(int i=0; i<3; i++) {
				drawSnowflake(t, depth, size);
				t.right(120);
			}
		}
					
	
	public static void main(String[] args) {
		//Expected: "olleh". Actual: "olleh".
		System.out.println(reverseString("hello"));
		
		//Expected: "ih". Actual: "ih".
		System.out.println(reverseString("hi"));
		
		//Expected: 3. Actual: 3.
		System.out.println(countWays(3));
		
		//Expected: 8. Actual: 8.
		System.out.println(countWays(5));
		
		//Expected: 3. Actual: 3.
		System.out.println(Ackermann(1,1));
		
		//Expected: 11. Actual: 11.
		System.out.println(Ackermann(0,10));
		
		//Expected: 2. Actual: 2.
		System.out.println(handShakes(3));
		
		//Expected: 3. Actual: 3.
		System.out.println(handShakes(3));
		
		//Expected: 10. Actual: 10.
		System.out.println(handShakes(5));
		
		//Expected: 3. Actual: 3.
		System.out.println(squareRoot(9));
		
		//Expected: 5. Actual: 5.
		System.out.println(squareRoot(25));
		
		//Draws a small snowflake
		World myWorld = new World(900,900,Color.WHITE);
		Turtle bob = new Turtle(myWorld);
		bob.setDelay(0);
		snowflake(bob, 4, 100);
		
		//Draws a large snowflake
		World yourWorld = new World(900,900,Color.WHITE);
		Turtle richard = new Turtle(yourWorld);
		bob.setDelay(0);
		snowflake(bob, 4, 300);
		
	}
	
	
}
