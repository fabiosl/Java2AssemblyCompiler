package examples;

public class JavaExampleWorking10 {
	public static void main(String[] args) {
		System.out.println(method());
	}
	public static String method(){
		String string = "";
		for (int i = 0; i < 100; i++) {
			string = string + " " +  i;
		}
		return string;
	}
}