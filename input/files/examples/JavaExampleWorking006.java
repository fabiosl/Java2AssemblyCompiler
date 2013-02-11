package examples;

public class JavaExampleWorking006 {
	public static void main(String[] args) {
		recursiveMethod(10);
	}
	public static void recursiveMethod(int num){
		if (num == 0){
			return ;
		}
		System.out.println(num);
		num = num - 1;
		recursiveMethod(num);
		
	}
}