import java.util.Scanner;

import java.util.*;
public class solution {

	public static int maximumProfit(int budget[]) {
        Arrays.sort(budget);
        int cost[]=new int [budget.length];
        for (int i=0;i<budget.length ;i++ )
            cost[i]=budget[i]*(budget.length-i);
        int max=Integer.MIN_VALUE;
        for(int i:cost)
        {
            if(i>max)
            max=i;
        }
        return max;
	}

}
public class runner {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i=0;i<n;i++)
			input[i] = s.nextInt();
		
		System.out.println(solution.maximumProfit(input));
	}

}
