package net.cs.jimisthebest.t4rge7.xfixcalc;
/**
 * 
 * @author James Roberts jpr242
 *
 */
public class PostFix {

	private String input;
	private LinkedStack<Double> stack;
	private LinkedQueue<Integer> queue;
	private LinkedQueue<Character> buffer;
	private double answer;
	
	public PostFix(String in) throws IllegalInputException {
		this.input = in;
		this.stack = new LinkedStack<Double>();
		this.queue = new LinkedQueue<Integer>();
		this.buffer = new LinkedQueue<Character>();
		this.answer = 0;
		this.calculate();
	}
	
	public double answer() {
		return this.answer;
	}
	
	private void calculate() throws IllegalInputException {

		for(int i = 0; i < this.input.length(); i++) {
			char read = this.input.charAt(i);
			if((read <= 57 && read >= 48) || read == ' ' || read == '-' || read == '+' || read == '*' || read == '/' || read == '.') {
				this.buffer.add(read);
			} else {
				throw new IllegalArgumentException();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!num1done && head <= 57 && head >= 48) {
				num += head;
			} else if(head == '.') {
				if(!num1dbl) {
					num += head;
					num1dbl = true;
				} else {
					//invalid number
				}
			} else if(head == ' ' && num.length() >= 1) {
				this.stack.push(Double.parseDouble(num));
				num = "";
				num1dbl = false;
			} else if(head == '+' || head == '-' || head == '*' || head == '/') {
				if(num.length() >= 1) {
					this.stack.push(Double.parseDouble(num));
					num = "";
					num1dbl = false;
				}
				if(this.stack.size() > 1) {
					double one = 0, two = 0;
					try {
						two = this.stack.pop();
						one = this.stack.pop();
					} catch (EmptyListException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					switch(head) {
					case '+':	this.stack.push(one + two);
					break;
					case '-':	this.stack.push(one - two);
					break;
					case '*':	this.stack.push(one * two);
					break;
					case '/':	this.stack.push(one / two);
					break;
					}
				} else {
					throw new IllegalInputException();
				}
			}
			
		}
		try {
			this.answer = this.stack.pop();
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
