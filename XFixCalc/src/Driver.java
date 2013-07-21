/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Driver {
	
	public static void main(String[] args) throws IllegalInputException, OperandsException, OperationsException, ZeroDivisionException {
		String test = "4 2 + 3 5 1-*+";
		PostFix test1 = new PostFix(test);
		System.out.println(test1.answer());
		
		test = "4 2+";
		test1 = new PostFix(test);
		System.out.println(test1.answer());
		
		test = "4 2-";
		test1 = new PostFix(test);
		System.out.println(test1.answer());
		
		test = "4 2*";
		test1 = new PostFix(test);
		System.out.println(test1.answer());
		
		test = "4 2/";
		test1 = new PostFix(test);
		System.out.println(test1.answer());
		
		test = "4 0/";
		test1 = new PostFix(test);
		System.out.println(test1.answer());
		
		
	}

}
