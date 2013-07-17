

public class Driver {
	
	public static void main(String[] args) throws Exception{
		
		String testing = "15 8*6 2+5-/";
		
		LinkedStack<Character> stack = new LinkedStack<Character>();
		for(int i = 0; i < testing.length(); i++) {
			stack.push(testing.charAt(testing.length() - (i + 1)));
		}
	//	System.out.println(stack.contains('2'));
		run(testing);
		
	}
	
	public static void run(String input) throws Exception{
		if(input.charAt(input.length() - 1) == '+' || input.charAt(input.length() - 1) == '-' || input.charAt(input.length() - 1) == '*' || input.charAt(input.length() - 1) == '/' ) {
			//postfix
			PrefixCalc temp = new PrefixCalc(input);
			System.out.println(temp.calc());
		} else if(input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*' || input.charAt(0) == '/') {
			//prefix
		} else {
			
		}
	}
	
}
