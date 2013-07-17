
public class PrefixCalc {

	private String str;
	private LinkedStack<Character> stack;
	
	public PrefixCalc(String str) {
		this.str = str;
		this.stack = new LinkedStack<Character>();
		for(int i = 0; i < str.length(); i++) {
			this.stack.push(this.str.charAt(str.length() - (i + 1)));
		}
		System.out.println(this.stack.toString());
	}
	
	public Integer calc() throws Exception{
		int toReturn = 0;
		
		while(!this.stack.isEmpty() && (this.stack.contains('+') || this.stack.contains('-') || this.stack.contains('*') || this.stack.contains('/'))) {
			int one = 0;
			int two = 0;
			char opp = '\0';
			int toAdd = 0;
			char out = '\0';
			
			System.out.println("Stack " + this.stack.toString());
			String single = "";
			while(out != '+' && out != '-' && out != '*' && out != '/' && !this.stack.isEmpty()) {
				System.out.println("Popped");
				out = this.stack.pop();
				single += out;
			}
			single = single.replaceAll("  ", " ");
			System.out.println("Single: " + single);
			//single = this.reverse(single);
			if(single.charAt(single.length() - 1) != '+' && single.charAt(single.length() - 1) != '-' && single.charAt(single.length() - 1) != '*' && single.charAt(single.length() - 1) != '/') {
				throw new Exception("Not postfix");
			}
			if(single.contains(" ")) {
				System.out.println(single.split(" ").length);
				for(int i = 0; i < single.split(" ").length; i++) {
					System.out.println(single.split(" ")[i]);
				}
				if (single.split(" ").length != 2) {
					throw new Exception("Invalid Input");
				}
				System.out.println("Single: " + single);
				opp = single.charAt(single.length() - 1);
				single = single.substring(0, single.length() -1 );
				one = Integer.parseInt(single.split(" ")[0]);
				two = Integer.parseInt(single.split(" ")[1]);
				System.out.println(one);
				System.out.println(two);
			} else if(single.length() == 3 ) {
				char first = single.charAt(0);
				char second = single.charAt(1);
				opp = single.charAt(2);
				
				if(first >= 48 && first <= 57) {
					one = first - 48;
				} else {
					throw new Exception("Invalid input");
				}
				
				if(second >= 48 && second <= 57) {
					two = second - 48;
				} else {
					throw new Exception("Invalid input");
				}
				
			} else {
				System.out.println(single);
				throw new Exception("Invalid input");
			}
			
			switch(opp) {
			case '+': toAdd = one + two;
				break;
			case '-': toAdd = one - two;
				break;
			case '*': toAdd = one * two;
				break;
			case '/': toAdd = one / two;
				break;
			default: throw new Exception("Invalid input");
			}
			System.out.println("To add: " + toAdd);
			String toPutBackIn = this.reverse(toAdd + " ");
			toPutBackIn = " " + toPutBackIn;
			for(int i = 0; i < toPutBackIn.length(); i++) {
				this.stack.push(toPutBackIn.charAt(i));
			}
			System.out.println("Stack:: " + this.stack.toString());
		}
		String ending = "";
		while(!this.stack.isEmpty()) {
			ending = this.stack.pop() + ending;
		}
		toReturn = Integer.parseInt(this.reverse(ending.replaceAll(" ", "")));
		return toReturn;
	}
	
	public String reverse(String in) {
		String toReturn = "";
		
		for(int i = in.length() - 1; i >= 0; i--) {
			toReturn += in.charAt(i);
		}
		
		return toReturn;
	}
	
}
