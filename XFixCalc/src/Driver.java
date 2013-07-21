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
		
		test = "4 2  +  ";
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
		
		test = "4 2+ 4 4-*";
		test1 = new PostFix(test);
		System.out.println(test1.answer());
		
		
		test = "/-42 02 2";
		PreFix test2 = new PreFix(test);
		System.out.println(test2.answer());
		
		
		test = "(7+3)/4";
		InFix test3 = new InFix(test);
		System.out.println(test3.answer());
		
		
	}

}
