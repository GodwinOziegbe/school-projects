package uppgift1;

import java.util.Scanner;

public class SvenskaAlfabetet {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a senctence in Swedish up to 100 characters:");
		
		String sentence= input.nextLine();
		char[] mychar= sentence.toCharArray();
		System.out.println("your sentence:");
		System.out.print("\"");
		
		for (int k=0; k< mychar.length; k++) {
			System.out.print(mychar[k]);
			
		}
		System.out.print("\"");
		System.out.println();
		
		int vocal =0;
		int konsonant =0;
		
		for (int j=0; j< mychar.length; j++) {
			if (Character.toLowerCase(mychar[j])=='a'||
			    Character.toLowerCase(mychar[j])=='e'||
				Character.toLowerCase(mychar[j])=='i'||
				Character.toLowerCase(mychar[j])=='o'||
				Character.toLowerCase(mychar[j])=='u'||
				Character.toLowerCase(mychar[j])=='y'||
				Character.toLowerCase(mychar[j])=='å'||
				Character.toLowerCase(mychar[j])=='ä'||
				Character.toLowerCase(mychar[j])=='ö') {
				
			
			vocal++	;
			
			}
			
			if 
				   (Character.toLowerCase(mychar[j])=='b'||
				    Character.toLowerCase(mychar[j])=='c'||
					Character.toLowerCase(mychar[j])=='d'||
					Character.toLowerCase(mychar[j])=='f'||
					Character.toLowerCase(mychar[j])=='g'||
					Character.toLowerCase(mychar[j])=='h'||
					Character.toLowerCase(mychar[j])=='j'||
					Character.toLowerCase(mychar[j])=='k'||
					Character.toLowerCase(mychar[j])=='l'||
					Character.toLowerCase(mychar[j])=='m'||
				    Character.toLowerCase(mychar[j])=='n'||
					Character.toLowerCase(mychar[j])=='p'||
					Character.toLowerCase(mychar[j])=='q'||
					Character.toLowerCase(mychar[j])=='r'||
					Character.toLowerCase(mychar[j])=='s'||
					Character.toLowerCase(mychar[j])=='t'||
					Character.toLowerCase(mychar[j])=='v'||
					Character.toLowerCase(mychar[j])=='x'||
				    Character.toLowerCase(mychar[j])=='z')
			{		
				konsonant++;
				
			}
				
				
			
		}
		System.out.println("contains...");
			System.out.println(vocal+ " vowels");
			System.out.println(konsonant+" consonants");
					
		
	input.close();		
	}
}


