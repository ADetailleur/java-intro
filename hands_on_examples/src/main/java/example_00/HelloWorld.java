package example_00;

import java.io.File;

class HelloWorld {
	
	public static void main(String[] args) {
		System.out.println("Hello "+ "world".toUpperCase());

		String greeting = new String("Hello");
		System.out.println(greeting);

		Double piApproximation = new Double(3.14159276);
		System.out.println(piApproximation);

		File textFile = new File("myTextfile.txt");

	}

	static class MySampleClass {

	}
	
}
