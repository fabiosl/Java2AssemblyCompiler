package examples;

public class JavaExampleWorking009 {
	public static void main(String[] args) {
		String string = "";
		System.out.println(method(string,100));
	}
	public static String method(String string, int num){
		while (num > 0) {
			string = string + " " + num;
			num = num - 1;
		}
		return string;
	}
}