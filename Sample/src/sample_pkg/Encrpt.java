package sample_pkg;
public class Encrpt {
	public static void main(String[] args) 
	{
		int key = 5 ;
		
		String text1 = "Hey , we will make it real soon?";
		System.out.println(" Original Text  : " + text1);
		char [] chars = text1.toCharArray();
		System.out.print(" Encrypted Text : ");
		for(char c1: chars)
		{
			c1 += key;
			System.out.print(c1);
		}
		
		
		System.out.println("\n");
		
		String text2 = "Mj~%1%|j%|nqq%rfpj%ny%wjfq%xttsD";
		System.out.println(" Encrypted Text : " + text2);
		char [] chars2 = text2.toCharArray();
		System.out.print(" Decrypted Text : ");
		for(char c2: chars2)
		{
			c2 -= key;
			System.out.print(c2);
		}
		
	}
}