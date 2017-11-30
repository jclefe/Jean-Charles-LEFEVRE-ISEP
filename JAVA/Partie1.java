import java.util.Scanner;
public class Partie1 {
	public static void main(String[] args) {
		System.out.print("Veuillez saisir votre phrase : ");
		Scanner scan = new Scanner(System.in);
		String saisie = scan.nextLine();
		String saisieCorrigee = saisie.replaceAll("\\W",""); //supprime ts les caracteres non alphanumériques dans la phrase
		System.out.print("Tapez 1 si vous souhaitez la méthode récursive ou 2 si vous voulez la méthode itérative: ");
		int a = scan.nextInt();
		if (a==1) {
			PalindromeRecursif(saisieCorrigee);
		}
		if (a==2) {
			PalindromeIteratif(saisieCorrigee);
		}
	}
	
	public static boolean PalindromeIteratif(String phrase) {
		/*	String phrase = " le TP de java "; //phrase qu'on veut tester
		String trime = phrase.trim(); //permet de supprimer les espaces avt et apres la phrase s'il y en a
		String[] Tableau_mots = trime.split(" "); //met dans un tableau chaque mot séparé par un espace d'ou le " "
		int a = Tableau_mots.length;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < a; i++) {
			sb.append(Tableau_mots[i]);
		}
		System.out.print(sb.toString()); */ //methode compliquée pour retirer les espaces, utiliser les espaces c mieux


		int a = phrase.length(); //donne la longueur de la chaine de caracteres
		String [] Tab = new String [a]; //creation d un tableau de la taille de la ch de caracteres
		for (int i=0;i<a;i++) {
			Tab[i] = phrase.substring(i,i+1); //on met chaque lettre dans une case du tableau
		} 
		
		for (int j=0;j<(a/2);j++) {
			if(!(Tab[j].equals(Tab[a-1-j]))) {
				System.out.println("ce n'est pas un palindrome");
				return false;
			}
		}
		System.out.println("c'est un palindrome");
		return true;
	}
	
	public static boolean PalindromeRecursif(String phrase) {
		String phraseRaccourcie;
		if (phrase.length()<=1) {
			System.out.println("Il s'agit d'un palindrome");
			return true;
		}
		if (!(phrase.startsWith(phrase.substring(phrase.length()-1,phrase.length())))) { //substring(a,b) part de a et s'arrete au caractere b-1
			System.out.println("Il ne s'agit pas d'un palindrome");
			return false;
		}
		phraseRaccourcie = phrase.substring(1,phrase.length() - 1);
		return PalindromeRecursif(phraseRaccourcie);
	}

}
