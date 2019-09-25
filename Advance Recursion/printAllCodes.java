import java.util.Scanner;
public class solution 
{
	public static void printAllPossibleCodes(String input) 
    {
        printCodes(input, "");
	}
    
    public static void printCodes(String str, String ans) 
    {
        if (str.length() == 0) 
        {
            System.out.println(ans);
            return;
        }
        String ch1 = str.substring(0, 1);
        String restOfTheString1 = str.substring(1);
        if (Integer.parseInt(ch1, 10) > 0) 
        {
            char code = (char) (Integer.parseInt(ch1, 10) + 'a' - 1);
            printCodes(restOfTheString1, ans + code);
        }
        if (str.length() >= 2) 
        {
            String ch12 = str.substring(0, 2);
            String ros2 = str.substring(2);
            if (Integer.parseInt(ch12, 10) > 0 && Integer.parseInt(ch12) <= 26) 
            {
                char code = (char) (Integer.parseInt(ch12, 10) + 'a' - 1);
                printCodes(ros2, ans + code);
            }
            if (Integer.parseInt(ch12, 10) == 0) 
            {
                printCodes(ros2, ans);
            }
        }
    }
}
public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		solution.printAllPossibleCodes(input);
	}
}
