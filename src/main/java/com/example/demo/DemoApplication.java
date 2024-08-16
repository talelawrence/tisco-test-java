package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		test1();
		test2();
	}

	public static void test1(){
		String inputA = "9876543";
		List<String> inputBList = Arrays.asList("3467985", "7865439", "8743956", "3456789");

		for (String inputB : inputBList) {
			if (isValid(inputA, inputB)) {
				System.out.println(inputB + " : Valid");
			} else {
				System.out.println(inputB + " : Invalid");
			}
		}
	}

	//test 1
	public static boolean isValid(String inputA, String inputB) {
		for (int i = 0; i < inputA.length(); i++) {
			if (inputA.charAt(i) == inputB.charAt(i)) {
				return false;
			}
		}
		return true;
	}


	public static void test2() {
		int[] numbers = {15, 18, 6};

		for (int number : numbers) {
			String classification = classifyNumber(number);
			System.out.println(number + " is " + classification);
		}
	}

	public static String classifyNumber(int number) {
		int sumOfDivisors = sumProperDivisors(number);

		if (sumOfDivisors < number) {
			return "deficient";
		} else if (sumOfDivisors > number) {
			return "abundant";
		} else {
			return "perfect";
		}
	}

	public static int sumProperDivisors(int number) {
		int sum = 0;

		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}

		return sum;
	}

}
