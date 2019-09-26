import java.util.Scanner;

public class solution {

	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		
        char a=source;
        char b=auxiliary;
        char c=destination;
       if (disks == 0) 
        { 
        	return; 
        } 
        towerOfHanoi(disks-1, a, c, b); 
        System.out.println(a + " " +c); 
        towerOfHanoi(disks-1, b, a, c); 
	}
}


public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		solution.towerOfHanoi(n, 'a', 'b', 'c');
	}
}
