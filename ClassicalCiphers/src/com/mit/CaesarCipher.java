package com.mit;


import java.util.Scanner;

public class CaesarCipher {
	static int mod;
	static int temp;
	static int quotient;

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("Press 1.Plain text to cipher text || 2.cipher text to plain text|| 3.Brute force");
		int c = k.nextInt();
		switch (c) {
		case 1: {
			System.out.println("Enter The Plain text:");
			String a = k.next();
			System.out.println("Enter The key value:");
			int key = k.nextInt();
			int b = 26;
			try {
				String ciphertext = "";
				for (int i = 0; i < a.length(); i++) {
					int n = 0;
					char decrpt = 0;
					int m = a.charAt(i);
					if (m > 96 && m < 123) {

						n = m - 97;
					}
					if (m > 64 && m < 91) {

						n = m - 65;
					}
					int mod = mod(n + key, b);
					if (m > 96 && m < 123) {
						decrpt = (char) (mod + 97);
						ciphertext += decrpt;
					}
					if (m > 64 && m < 91) {
						decrpt = (char) (mod + 65);
						ciphertext += decrpt;
					}

				}
				System.out.println("cipher text is " + ciphertext);
			} catch (ArithmeticException e) {
				System.out.println(e);

			}
			break;
		}
		case 2: {
			System.out.println("Enter The cipher text:");
			String a = k.next();
			System.out.println("Enter The key value:");
			int key = k.nextInt();
			int b = 26;
			try {
				String plaintext = "";
				for (int i = 0; i < a.length(); i++) {
					int n = 0;
					char decrpt = 0;
					int m = a.charAt(i);
					if (m > 96 && m < 123) {

						n = m - 97;
					}
					if (m > 64 && m < 91) {

						n = m - 65;
					}
					int mod = mod(n - key, b);
					if (m > 96 && m < 123) {
						decrpt = (char) (mod + 97);
						plaintext += decrpt;
					}
					if (m > 64 && m < 91) {
						decrpt = (char) (mod + 65);
						plaintext += decrpt;
					}

				}
				System.out.println("plain text is " + plaintext);
			} catch (ArithmeticException e) {
				System.out.println(e);

			}
			break;
		}
		case 3: {
			System.out.println("Enter The cipher text:");
			String a = k.next();
			int b = 26;

			try {
				for (int key = 0; key < 26; key++) {
					String plaintext = "";
					for (int i = 0; i < a.length(); i++) {
						int n = 0;
						char decrpt = 0;
						int m = a.charAt(i);
						if (m > 96 && m < 123) {

							n = m - 97;
						}
						if (m > 64 && m < 91) {

							n = m - 65;
						}
						int mod = mod(n - key, b);
						if (m > 96 && m < 123) {
							decrpt = (char) (mod + 97);
							plaintext += decrpt;
						}
						if (m > 64 && m < 91) {
							decrpt = (char) (mod + 65);
							plaintext += decrpt;
						}

					}
					System.out.println("plain text for key " + key + " is: " + plaintext);
				}
			} catch (ArithmeticException e) {
				System.out.println(e);

			}
			break;
		}
		}
	}

	static int mod(int a, int n) {
		int mod = 0;
		if (a >= 0) { // To find mod for positive integer
			mod = a % n;
		} else { // To find mod for negative integer
			mod = (n + (a % n)) % n;
		}
		return mod;
	}
}