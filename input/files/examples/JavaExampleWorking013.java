package examples;

public class JavaExampleWorking013 {
	private static String method1(){
		return "a";
	}
	private static String method2(){
		return "b";
	}
	private static boolean method3(){
		return 1==2;
	}
	public static void main(String[] args) {
		String string = method3() ? method1() : method2(); 
		System.out.println(string);
	}
}