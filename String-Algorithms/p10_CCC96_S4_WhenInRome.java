//Problem Link: https://dmoj.ca/problem/ccc96s4

import java.util.*;

public class p10_CCC96_S4_WhenInRome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // num test cases

		for (int i = 0; i < n; i++) {
			String expression = input.next(); // The expression we want to solve
			String romanA = expression.substring(0, expression.indexOf('+')); // First number
			String romanB = expression.substring(expression.indexOf('+') + 1, expression.indexOf('=')); // Second number

			int ans = numeralToInt(romanA) + numeralToInt(romanB);
			if (ans > 1000) {
				System.out.println(romanA + "+" + romanB + "=CONCORDIA CUM VERITATE");
			} else {
				System.out.println(romanA + "+" + romanB + "=" + intToNumeral(ans));
			}
		}
        input.close();
	}

	public static int numeralToInt(String romanNum) {
		int num = 0;

		// The i variable will keep track of where in the roman numeral we are
		for (int i = 0; i < romanNum.length(); i++) {
			if (romanNum.charAt(i) == 'M') {
				num += 1000; // Check for 1000
			}
			if (romanNum.charAt(i) == 'D') {
				num += 500; // Check for 500
			}
			if (romanNum.charAt(i) == 'C') { // Check for 100, 400, or 900
				// We need to check first if there is a char after it
				if (i + 1 < romanNum.length() && romanNum.charAt(i + 1) == 'M') {
					num += 900;
					i += 1; // Increase one extra since we processed two letters
				} else if (i + 1 < romanNum.length() && romanNum.charAt(i + 1) == 'D') {
					num += 400;
					i += 1; // Increase one extra since we processed two letters
				} else {
					num += 100;
				}
			}
			// =-=-=-=-=-=-=-=-=
			if (romanNum.charAt(i) == 'L') {
				num += 50; // Check for 50
			}
			if (romanNum.charAt(i) == 'X') {
				// We need to check first if there is a char after it
				if (i + 1 < romanNum.length() && romanNum.charAt(i + 1) == 'C') {
					num += 90;
					i += 1; // Increase one extra since we processed two letters
				} else if (i + 1 < romanNum.length() && romanNum.charAt(i + 1) == 'L') {
					num += 40;
					i += 1; // Increase one extra since we processed two letters
				} else {
					num += 10;
				}
			}
			// =-=-=-=-=-=-=-=-=
			if (romanNum.charAt(i) == 'V') {
				num += 5; // Check for 5
			}
			if (romanNum.charAt(i) == 'I') {
				if (i + 1 < romanNum.length() && romanNum.charAt(i + 1) == 'X') {
					num += 9;
					i += 1; // Increase one extra since we processed two letters
				} else if (i + 1 < romanNum.length() && romanNum.charAt(i + 1) == 'V') {
					num += 4;
					i += 1; // Increase one extra since we processed two letters
				} else {
					num += 1;
				}
			}
		}
		return num;
	}

	public static String intToNumeral(int num) {
		String romanNum = "";
		// THOUSANDS DIGITS
		if (num / 1000 >= 1) { // Checking to add 1000
			romanNum += "M";
			num -= 1000;
		}
		// HUNDREDS DIGITS
		if (num / 900 >= 1) { // Checking to add 900
			romanNum += "CM";
			num -= 900;
		}
		if (num / 500 >= 1) { // Checking to add 500
			romanNum += "D";
			num -= 500;
		}
		if (num / 400 >= 1) { // Checking to add 400
			romanNum += "CD";
			num -= 400;
		}
		if (num / 100 >= 1) { // Checking to add 100
			while (num / 100 >= 1) {
				romanNum += "C";
				num -= 100;
			}
		}
		// TENS DIGITS
		if (num / 90 >= 1) { // Checking to add 90
			romanNum += "XC";
			num -= 90;
		}
		if (num / 50 >= 1) { // Checking to add 50
			romanNum += "L";
			num -= 50;
		}
		if (num / 40 >= 1) { // Checking to add 40
			romanNum += "XL";
			num -= 40;
		}
		if (num / 10 >= 1) { // Checking to add 10
			while (num / 10 >= 1) {
				romanNum += "X";
				num -= 10;
			}
		}
		// ONES DIGITS
		if (num / 9 >= 1) { // Checking to add 9
			romanNum += "IX";
			num -= 9;
		}
		if (num / 5 >= 1) { // Checking to add 5
			romanNum += "V";
			num -= 5;
		}
		if (num / 4 >= 1) { // Checking to add 4
			romanNum += "IV";
			num -= 4;
		}
		if (num / 1 >= 1) { // Checking to add 1
			while (num / 1 >= 1) {
				romanNum += "I";
				num -= 1;
			}
		}

		return romanNum;
	}
}