package examples;


//This is a Comment
public class JavaExampleWorking005 {
	
	/*This is another comment*/
	public static void main(String[] args) {
		method();
	}
	
	/**
	 * This is another comment
	 */
	public static void /*comment within method declaration*/ method(){ //This might not be treated by the grammar provided by Daniel.
		System.out.println("Hi");
		
	}
}