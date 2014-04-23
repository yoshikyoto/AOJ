import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			while(true){
				String strs[] = br.readLine().split(" ");
				int an = Integer.parseInt(strs[0]);
				int bn = Integer.parseInt(strs[1]);
				if(an == 0 && bn == 0) return;
				int r = Integer.parseInt(strs[2]);
				
				int a[][] = new int[an][2];
				for(int i = 0; i < an; i++){
					strs = br.readLine().split(" ");
					a[i][0] = Integer.parseInt(strs[0]);
					a[i][1] = Integer.parseInt(strs[1]);
				}
				
				int b[][] = new int[bn][2];
				for(int i = 0; i < bn; i++){
					strs = br.readLine().split(" ");
					b[i][0] = Integer.parseInt(strs[0]);
					b[i][1] = Integer.parseInt(strs[1]);
				}
				
				int sum = 0;
				for(int i = 0; i < an; i++){
					for(int j = 0; j < bn; j++){
						if(distance(a[i], b[i]) <= 4 * r) sum++;
					}
				}
				System.out.println(sum);
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static double distance(int a[], int b[]){
		double distance = Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2);
		return Math.sqrt(distance);
	}
	
	public static void printArray(int array[]){
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + "\t");
		System.out.println();
	}

	public static void printArray(boolean array[]){
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + "\t");
		System.out.println();
	}
	
	public static void printMatrix(int matrix[][]){
		for(int i = 0; i < matrix.length; i++){
			printArray(matrix[i]);
		}
	}
	
	public static void printMatrix(boolean matrix[][]){
		for(int i = 0; i < matrix.length; i++){
			printArray(matrix[i]);
		}
	}
}