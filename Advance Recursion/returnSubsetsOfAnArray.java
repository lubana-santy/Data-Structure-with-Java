import java.util.Scanner;
public class solution {

	// Return a 2D array that contains all the subsets
    public static int[][] helper(int input[],int start)
    {
        if(start == input.length)
        {
            int[][] output = new int[1][0];
            return output;
        }
        int[][] small = helper(input , start+1);
        int[][] output = new int[2*small.length][];
        int k=0;
        for(int i=0;i<small.length;i++)
        {
            output[k] = new int[small[i].length];
            for(int j=0;j<small[i].length;j++)
            {
                output[k][j] = small[i][j];
            }
            k++;
        }
        for(int i=0;i<small.length;i++)
        {
            output[k] = new int[small[i].length+1];
            output[k][0] = input[start];
            for(int j=1;j<=small[i].length;j++)
            {
                output[k][j] = small[i][j-1];
            }
            k++;
        }
        return output;
    }
	public static int[][] subsets(int input[]) {
		// Write your code here
        return helper(input , 0);
	}
}

public class runner {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int output[][] = solution.subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
}
