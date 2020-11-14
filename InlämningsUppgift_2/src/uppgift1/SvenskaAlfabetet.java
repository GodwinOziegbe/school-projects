package uppgift1;

import java.util.Scanner;

public class SvenskaAlfabetet {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a senctence in Swedish up to 100 characters:");

		String sentence = input.nextLine();
		char[] mychar = sentence.toCharArray();
		System.out.println("your sentence:");
		System.out.print("\"");

		for (int k = 0; k < mychar.length; k++) {
			System.out.print(mychar[k]);

		}
		System.out.print("\"");
		System.out.println();

		int vocal = 0;
		int konsonant = 0;

		for (int j = 0; j < mychar.length; j++) {
			
			switch (mychar[j]) {
				case 'a':
				case 'A':
				case 'e':
				case 'E':
				case 'ä':
				case 'Ä':
				case 'ö':
				case 'Ö':
				case 'å':
				case 'Å':
				case 'y':
				case 'Y':
				case 'i':
				case 'I':
				case 'o':
				case 'O':
				case 'u':
				case 'U': vocal++ ; break;
				
				case 'b':
				case 'B':
				case 'c':
				case 'C':
				case 'D':
				case 'd':
				case 'f':
				case 'F':
				case 'j':
				case 'J':
				case 'k':
				case 'K':
				case 'L':
				case 'l':
				case 'M':
				case 'm':
				case 'n':
				case 'N':
				case 'r':
				case 'R':
				case 'p':
				case 'P':
				case 'q':
				case 'Q':
				case 's':
				case 'S':
				case 't':
				case 'T':
				case 'x':
				case 'X':
				case 'z':
				case 'Z':
				case 'h':
				case 'H':
				case 'v':
				case 'V':konsonant++;
					
				
			}
			

		}
		System.out.println("contains...");
		System.out.println(vocal + " vowels");
		System.out.println(konsonant + " consonants");

		input.close();
	}
}
