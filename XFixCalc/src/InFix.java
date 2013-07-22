
/**
 * 
 * @author James Roberts jpr242
 *
 */
public class InFix {

	private String input;
//	private LinkedStack<Double> stack;
	private LinkedStack<Character> opr;
//	private LinkedQueue<Integer> queue;
	private LinkedQueue<Character> buffer;
	private double answer;
	
	public InFix(String in) throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {
		this.input = in;
		while(this.input.contains("  ")) {
			this.input = this.input.replaceFirst(" ", "");
		}
//		this.stack = new LinkedStack<Double>();
//		this.queue = new LinkedQueue<Integer>();
		this.buffer = new LinkedQueue<Character>();
		this.answer = 0;
		this.opr = new LinkedStack<Character>();
		this.calculate();
	}
	
	private void calculate() throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {
		String postFix = "";
		for(int i = 0; i < this.input.length(); i++) {
			char read = this.input.charAt(i);
			if((read <= 57 && read >= 48) || read == '-' || read == '+' || read == '*' || read == '/' || read == '.' || read == '(' || read == ')') {
				this.buffer.add(read);
			} else {
				System.err.println("infix line 32");
				throw new IllegalInputException("InFix ERROR: Invalid Character for InFix: " + read);
			}
		}
		
		String num = "";
		boolean numDecimal = false;
		while(!this.buffer.isEmpty()) {
			char head = '\0';
			try {
				head = this.buffer.poll();
			} catch (EmptyListException e) {
				System.err.println("infix line 44");
//				throw new IllegalInputException();
			}
			if(head <= 57 && head >= 48) {
				num += head;
			} else if(head == '.' && !numDecimal) {
				numDecimal = true;
				num += head;
			} else if(head == '+' || head == '-' || head == '*' || head == '/' || head == '(') {
				postFix += num + " ";
				num = "";
				boolean found = false;
				while(!this.opr.isEmpty() && !found) {
					try {
						if (this.opr.top() != '(' && this.priorityOf(this.opr.top()) > this
								.priorityOf(head)) {
							postFix += this.opr.pop();
						} else {
							found = true;
						}
					} catch (EmptyListException e) {
						System.err.println("infix line 65");
					}
				}
				this.opr.push(head);
			} else if(head == ')') {
				postFix += num + " ";
				num = "";
				boolean found = false;
				while(!found) {
					try {
						if (this.opr.top() != '(') {
							postFix += this.opr.pop();
						} else {
							found = true;
							this.opr.pop();
						}
					} catch (EmptyListException e) {
						System.err.println("infix line 82");
						throw new IllegalInputException("InFix ERROR: Missing '('");
					}
				}
			}
		}
		postFix += num;
		while (!this.opr.isEmpty()) {
			try {
				char top = this.opr.pop();
				if (top != '(' && top != ')') {
					postFix += top;
				}
			} catch (EmptyListException e) {
				System.err.println("infix line 96");
			}
		}
//		System.out.println(postFix);
		if (postFix.length() > 0) {
			try {
			while (postFix.charAt(0) == ' ') {
				postFix = postFix.substring(1);
				// System.out.println(true);
			}
			while (postFix.charAt(postFix.length() - 1) == ' ') {
				postFix = postFix.substring(0, postFix.length() - 1);
			}
			while (postFix.contains("  ")) {
				postFix = postFix.replaceFirst("  ", " ");
			}
			// System.out.println(postFix);
			} catch (StringIndexOutOfBoundsException e) {
				throw new IllegalInputException("InFix ERROR: Cannot Convert, Invalid Expression");
			}
		}
		PostFix temp = new PostFix(postFix);
		this.answer = temp.answer();
	}
	
	private int priorityOf(char c) {
		if(c == '*' || c == '/') {
			return 2;
		} else if(c == '+' || c == '-') {
			return 1;
		} else if(c == '(') {
			return 3;
		}
		return -1;
	}
	
	public double answer() {
		return this.answer;
	}

}
