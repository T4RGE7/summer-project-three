/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Driver {
	
	public static void main(String[] args) throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {

		calculate("2 3 + >> 5");
		calculate("3 4 - >> -1");
		calculate("9 4 * >> 36");
		calculate("10 2 / >> 5");
		calculate("2 -3 - >> 5");
		calculate("4 5 7 2 + - * >> -16");
		calculate("3 4 + 2 * 7 / >> 2");
		calculate("5 7 + 6 2 - * >> 48");
		calculate("4 2 + 3 5 1 - * + >> 18");
		calculate("4 5 5 - / >> Zero Division Error");
		calculate("4 5 5 - >> Opperands Error");
		calculate("4 5 5 - * + >> Operators Error");
		calculate("+ 8 9 >> 17");
		calculate("- 5 6 >> -1");
		calculate("* 3 4 >> 12");
		calculate("/ 21 7 >> 3");
		calculate("* -3 6 >> -18");
		calculate("* + 1 2 6 >> 18");
		calculate("/ + 5 7 - 6 2 >> 3");
		calculate("- + / 6 2 4 + 4 2 >> 1");
		calculate("* + - / 4 -2 6 9 3 >> 3");
		calculate("/ 9 - 4 4 >> Zero Division Error");
		calculate("- 5 5 4 >> Opperands Error");
		calculate("- * + 4 5 5 >> Operators Error");
		calculate("3 + 4 >> 7");
		calculate("9 - 10 >> -1");
		calculate("4 * 5 >> 20");
		calculate("8 / 4 >> 2");
		calculate("-4 + 9 >> 5");
		calculate("(5 - 3) * 6 >> 12");
		calculate("(6 - 5) * (7 + 18) >> 25");
		calculate("5 + 3 * 5 >> 20");
		calculate("6 / 3 - 1 >> 1");
		calculate("7 / (5 - 5) >> Zero Division Error");
		calculate("3 4 + 2 * 7 >> Opperands Error");
		calculate("3 + + 4 - 4 >> Operators Error");
		calculate("(10+-9)+4 >> 5");
		
	}
	
	public static void calculate(String in) {
		String toUse = in.split(" >> ")[0];
		String expected = in.split(" >> ")[1];
		boolean postB, preB, inB, auto = true;
		postB = preB = inB = false;
		String tv = "";
		
		String toChange = "";
		String temp = toUse;
		boolean end = true;
//		if(temp.length() == 0) {
//			return;
//		}
		boolean one = false, two = false;
		
		while(temp.length() > 0 && (!one || !two)) {
			if(temp.charAt(0) == ' ') {
				temp = temp.substring(1);
				continue;
			}
			one = true;
			if(temp.charAt(temp.length() - 1) == ' ') {
				temp = temp.substring(0, temp.length() -1);
				continue;
			}
			two = true;
		}
		
//		while(temp.length() > 0 && temp.charAt(0) == ' ') {
//			temp = temp.substring(1);
//	//		System.out.println(true);
//		}
//		while(temp.charAt(temp.length() - 1) == ' ' && temp.length() > 0) {
//			temp = temp.substring(0, temp.length() -1);
//		}
		while(temp.contains("  ")) {
			temp = temp.replaceFirst("  ", " ");
		}
		char zero = '\0', last = '\0';
		try {
			zero = temp.charAt(0); last = temp.charAt(temp.length() - 1);
		} catch(IndexOutOfBoundsException e) {
			return;
		}
		boolean special = false;
		try {
			if(zero == '-') {
				if(temp.charAt(1) >= 48 && temp.charAt(1) <= 57) {
					special = true;
				}
			}
		} catch(IndexOutOfBoundsException e){}
		
		if(auto) {
			if (last == '+' || last == '-' || last == '*' || last == '/') {
				// postfix
				preB = false;
				postB = true;
				inB = false;
				tv = "Auto: Postfix";
			} else if ((zero == '+' || zero == '-' || zero == '*' || zero == '/') && !special) {
				// prefix
				preB = true;
				postB = false;
				inB = false;
				tv = "Auto: Prefix";
			} else {
				// infix
				preB = false;
				postB = false;
				inB = true;
				tv = "Auto: Infix";
			}
		} else {
			if(preB) {
				tv = "Manual: Prefix";
			} else if(postB) {
				tv = "Manual: Postfix";
			} else if(inB) {
				tv = "Manual: Infix";
			}
		}
		
//		if(in) {
//			temp = temp.replaceAll(" ", "");
//		}
		
		tv += " -> " + temp;
		
		String veryTemp = "";
		
		try {
			if (preB) {
				// prefix
				PreFix prefix = new PreFix(temp);
				toChange = " " + prefix.answer();
				end = false;
			} else if (postB) {
				// postfix
				PostFix postfix = new PostFix(temp);
				toChange = postfix.answer() + " ";
			} else if (inB){
				// infix
				InFix infix = new InFix(temp);
				toChange = infix.answer() + "";
				veryTemp = infix.postFixed();
			}
		} catch (IllegalInputException e) {
			toChange = e.getMessage();
		} catch (OperandsException e) {
			toChange = e.getMessage();
		} catch (OperationsException e) {
			toChange = e.getMessage();
		} catch (ZeroDivisionException e) {
			toChange = e.getMessage();
		}
		

		
		if(inB) {
			tv += "\nPostFix -> " + veryTemp;
		}
		
		if(!(temp.contains("+") || temp.contains("-") || temp.contains("*") || temp.contains("/")) && temp.matches("\\s*[\\d]*[\\.]?[\\d]*\\s*")) {
			tv = temp.replaceAll(" ", "");

		}
		System.out.println("Input: " + toUse);
		System.out.println(tv);
		System.out.println("Result: " + toChange);
		System.out.println("Expected: " + expected + "\n");
	}

}
