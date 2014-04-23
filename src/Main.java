import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
				String strs[] = br.readLine().split(" ");
				int n = Integer.parseInt(strs[0]);
				int h = Integer.parseInt(strs[1]);
				if(n == 0) return;
				
				boolean ana[][][] = new boolean[n][n][n];
				int answer = n * n * n;
				
				for(int i = 0; i < h; i++){
					strs = br.readLine().split(" ");
					int arg1 = Integer.parseInt(strs[1]) - 1;
					int arg2 = Integer.parseInt(strs[2]) - 1;
					if(strs[0].equals("xy")){
						// xy
						for(int j = 0; j < n; j++){
							if(ana[arg1][arg2][j]) continue;
							ana[arg1][arg2][j] = true;
							answer--;
						}
					}else if(strs[0].equals("xz")){
						// xz
						for(int j = 0; j < n; j++){
							if(ana[arg1][j][arg2]) continue;
							ana[arg1][j][arg2] = true;
							answer--;
						}
					}else{
						// yz
						for(int j = 0; j < n; j++){
							if(ana[j][arg1][arg2]) continue;
							ana[j][arg1][arg2] = true;
							answer--;
						}
					}
				}
				
				System.out.println(answer);
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
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