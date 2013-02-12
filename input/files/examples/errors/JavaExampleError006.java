public class JavaExampleError006{
	public static void main (String[] args){
		(int i = 0; 100; i++) { //For statement is missing
			System.out.println("oi");
		}
	}
}