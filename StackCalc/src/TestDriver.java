/**
 * 
 * @author JamesRoberts jpr242
 *
 * 
 */
public class TestDriver {

	public static void main(String[] args) {
		
		LinkedStack<Character> test = new LinkedStack<Character>();
	
		test.push('h');
		test.push('e');
		
		System.out.println(test.pop());
		System.out.println(test.peek());
		System.out.println(test.pop());
		
	}
	
}
