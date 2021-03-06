

/**
 * 
 * @author James Roberts jpr242
 *
 */
public class PostFix {

	private String input;
	private LinkedStack<Double> stack;
//	private LinkedQueue<Integer> queue;
	private LinkedQueue<Character> buffer;
	private double answer;
	
	/**
	 * Creates a new PostFix object and calls calculate to generate the answer to the input String
	 * @param in the postfix String given
	 * @throws IllegalInputException
	 * @throws OperandsException
	 * @throws OperationsException
	 * @throws ZeroDivisionException
	 */
	public PostFix(String in) throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {
		this.input = in;
		while(this.input.contains("  ")) {
			this.input = this.input.replaceFirst("  ", " ");
		}
		this.stack = new LinkedStack<Double>();
//		this.queue = new LinkedQueue<Integer>();
		this.buffer = new LinkedQueue<Character>();
		this.answer = 0;
		this.calculate();
	}
	
	/**
	 * Returns the answer calculated as a double
	 * @return answer
	 */
	public double answer() {
		return this.answer;
	}
	
	/**
	 * Attempts to calculate the answer of given postfix input
	 * @throws IllegalInputException
	 * @throws OperandsException
	 * @throws OperationsException
	 * @throws ZeroDivisionException
	 */
	private void calculate() throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {

		for(int i = 0; i < this.input.length(); i++) {
			char read = this.input.charAt(i);
			if((read <= 57 && read >= 48) || read == ' ' || read == '-' || read == '+' || read == '*' || read == '/' || read == '.') {
				this.buffer.add(read);
			} else {
				System.err.println("postfix line 38");
				throw new IllegalInputException("PostFix ERROR: Invalid Character for PostFix: " + read);
			}
		}
		boolean num1done = false;
		boolean num1dbl = false;
		String num = "";
		while(!this.buffer.isEmpty()) {
			char head = '\0';
			char test = '\0';
			boolean negative = false;
			try {
				head = this.buffer.poll();
			} catch (EmptyListException e) {
				System.err.println("postfix line 49");

			}
			try {
				if(head == '-') {
					test = this.buffer.front();
				}
				if(test == '-' || test == '+' || test == '*' || test == '/') {
					test = '\0';
				}
				if(test > 57 || test < 48) {
					test = '\0';
				}
			} catch (EmptyListException e) {
				
			}
			if (test != ' ' && head == '-' && test != '\0') {
				negative = true;
			}
			if(!num1done && head <= 57 && head >= 48 || negative) {
				num += head;
//				if(negative) {
//					num = '-' + num;
//				}
			} else if(head == '.') {
				if(!num1dbl) {
					num += head;
					num1dbl = true;
				} else {
					//invalid number
					System.err.println("postfix line 60");
					throw new IllegalInputException("PostFix ERROR: Invalid Number, Too Many Decimals");
				}
			} else if(head == ' ' && num.length() >= 1) {
				try {
					this.stack.push(Double.parseDouble(num));
				} catch (NumberFormatException e) {
					throw new IllegalInputException("PostFix ERROR: Unparsable Number " + num);
				}
				num = "";
				num1dbl = false;
			} /*else if(head == ' ') {
				continue;
			}*/ else if(head == '+' || head == '-' || head == '*' || head == '/') {
				if(num.length() >= 1) {
					try {
						this.stack.push(Double.parseDouble(num));
					} catch (NumberFormatException e) {
						throw new IllegalInputException("PostFix ERROR: Unparsable Number " + num);
					}
					num = "";
					num1dbl = false;
				}
				if(this.stack.size() > 1) {
					double one = 0, two = 0;
					try {
						two = this.stack.pop();
						one = this.stack.pop();
					} catch (EmptyListException e) {
						System.err.println("postfix line 81");
						throw new OperationsException("PostFix ERROR: Too Many Operations");
					}
					switch(head) {
					case '+':	this.stack.push(one + two);
					break;
					case '-':	this.stack.push(one - two);
					break;
					case '*':	this.stack.push(one * two);
					break;
					case '/':	if(two == 0) {
						System.err.println("postfix line 92");
							throw new ZeroDivisionException("PostFix ERROR: Division by Zero");
						} else {
							this.stack.push(one / two);
						}
					break;
					}
				} else {
					System.err.println("postfix line 100");
					throw new OperationsException("PostFix ERROR: Too Many Operations");
				}
			}
			
		}
		if(this.stack.size() > 1) {
			System.err.println("postfix line 107");
			throw new OperandsException("PostFix ERROR: Too Many Operands");
		}
		try {
			this.answer = this.stack.pop();
		} catch (EmptyListException e) {
			System.err.println("postfix line 113");
			throw new OperandsException("PostFix ERROR: Not Enough Operands");
		}
	}
	
}
