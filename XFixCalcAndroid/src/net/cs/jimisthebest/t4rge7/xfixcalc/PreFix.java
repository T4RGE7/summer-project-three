package net.cs.jimisthebest.t4rge7.xfixcalc;
/**
 * 
 * @author James Roberts jpr242
 *
 */
public class PreFix {

	private String input;
	private LinkedStack<Double> stack;
//	private LinkedQueue<Integer> queue;
	private LinkedQueue<Character> buffer;
	private double answer;
	
	public PreFix(String in) throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {
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
	
	public double answer() {
		return this.answer;
	}
	
	private void calculate() throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {

		for(int i = this.input.length() - 1; i >= 0; i--) {
			char read = this.input.charAt(i);
			if((read <= 57 && read >= 48) || read == ' ' || read == '-' || read == '+' || read == '*' || read == '/' || read == '.') {
				this.buffer.add(read);
			} else {
				System.err.println("prefix line 38");
				throw new IllegalInputException("PreFix ERROR: Invalid Character for PreFix: " + read);
			}
		}
		boolean num1done = false;
		boolean num1dbl = false;
		String num = "";
		while(!this.buffer.isEmpty()) {
			char head = '\0';
			try {
				head = this.buffer.poll();
			} catch (EmptyListException e) {
				System.err.println("prefix line 49");

			}
			if(!num1done && head <= 57 && head >= 48) {
				num = head + num;
			} else if(head == '.') {
				if(!num1dbl) {
					num = head + num;
					num1dbl = true;
				} else {
					//invalid number
					System.err.println("prefix line 59");
					throw new IllegalInputException("PreFix ERROR: Invalid Number, Too Many Decimals");
				}
			} else if(head == ' ' && num.length() >= 1) {
				try {
					this.stack.push(Double.parseDouble(num));
				} catch (NumberFormatException e) {
					throw new IllegalInputException("PreFix ERROR: Unparsable Number " + num);
				}
				num = "";
				num1dbl = false;
			} else if(head == ' ') {
				continue;
			} else if(head == '+' || head == '-' || head == '*' || head == '/') {
				if(num.length() >= 1) {
					try {
						this.stack.push(Double.parseDouble(num));
					} catch (NumberFormatException e) {
						throw new IllegalInputException("PreFix ERROR: Unparsable Number " + num);
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
						throw new OperationsException("PreFix ERROR: Too Many Operations");
					}
					switch(head) {
					case '+':	this.stack.push(two + one);
					break;
					case '-':	this.stack.push(two - one);
					break;
					case '*':	this.stack.push(two * one);
					break;
					case '/':	if(one == 0) {
							System.err.println("prefix line 90");
							throw new ZeroDivisionException("PreFix ERROR: Division by Zero");
						} else {
							this.stack.push(two / one);
						}
					break;
					}
				} else {
					System.err.println("prefix line 98");
					throw new OperationsException("PreFix ERROR: Too Many Operations");
				}
			}
			
		}
		if(this.stack.size() > 1) {
			System.err.println("prefix line 105");
			throw new OperandsException("PreFix ERROR: Too Many Operands");
		}
		try {
			this.answer = this.stack.pop();
		} catch (EmptyListException e) {
			System.err.println("prefix line 111");
			throw new OperandsException("PreFix Error: Not Enough Operands");
		}
	}
	
}
