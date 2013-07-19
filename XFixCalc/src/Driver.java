/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Driver {
	
	public static void main(String[] args) throws IllegalInputException {
		String test = "10 22+10-";
		PostFix test1 = new PostFix(test);
		System.out.println(test1.answer());
	}

}
