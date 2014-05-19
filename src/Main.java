import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++){
				String inputs[] = br.readLine().split(" ");
				calc(inputs);
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static void calc(String str[]){
		int index[][] = new int[2][4];
		int num[][] = new int[2][4];
		int result[] = new int[4];
		
		index[0][0] = str[0].indexOf("m");
		index[0][1] = str[0].indexOf("c");
		index[0][2] = str[0].indexOf("x");
		index[0][3] = str[0].indexOf("i");
		index[1][0] = str[1].indexOf("m");
		index[1][1] = str[1].indexOf("c");
		index[1][2] = str[1].indexOf("x");
		index[1][3] = str[1].indexOf("i");
		
		for(int i = 0; i < 2; i++){
			// m
			index[i][0] = str[i].indexOf("m");
			if(index[i][0] == 0){
				num[i][0] = 1;
			}else if(index[i][0] != -1){
				char m = str[i].charAt(index[i][0] - 1);	
				num[i][0] = Integer.parseInt("" + m);
			}
			// System.out.println(num[i][0]);
			
			// x
			index[i][1] = str[i].indexOf("c");
			if(index[i][1] == 0){
				num[i][1] = 1;
			}else if(index[i][1] != -1){
				char x = str[i].charAt(index[i][1] - 1);
				if('2' <= x && x <= '9'){
					num[i][1] = Integer.parseInt("" + x);
				}else{
					num[i][1] = 1;
				}
			}
			// System.out.println(num[i][1]);
			
			// c
			index[i][2] = str[i].indexOf("x");
			if(index[i][2] == 0){
				num[i][2] = 1;
			}else if(index[i][2] != -1){
				char c = str[i].charAt(index[i][2] - 1);
				if('2' <= c && c <= '9'){
					num[i][2] = Integer.parseInt("" + c);
				}else{
					num[i][2] = 1;
				}
			}
			// System.out.println(num[i][2]);
			
			// i
			index[i][3] = str[i].indexOf("i");
			if(index[i][3] == 0){
				num[i][3] = 1;
			}else if(index[i][3] != -1){
				char c = str[i].charAt(index[i][3] - 1);
				if('2' <= c && c <= '9'){
					num[i][3] = Integer.parseInt("" + c);
				}else{
					num[i][3] = 1;
				}
			}
			// System.out.println(num[i][3]);
		}
		
		result[3] = num[0][3] + num[1][3];
		if(result[3] >= 10) result[2]++;
		result[3] = result[3] % 10;
		
		result[2] = result[2] + num[0][2] + num[1][2];
		if(result[2] >= 10) result[1]++;
		result[2] = result[2] % 10;
		
		result[1] = result[1] + num[0][1] + num[1][1];
		if(result[1] >= 10) result[0]++;
		result[1] = result[1] % 10;
		
		result[0] = result[0] + num[0][0] + num[1][0];
		
		// System.out.print(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
		
		if(result[0] >= 1){
			if(result[0] != 1) System.out.print(result[0]);
			System.out.print("m");
		}
		if(result[1] >= 1){
			if(result[1] != 1) System.out.print(result[1]);
			System.out.print("c");
		}
		if(result[2] >= 1){
			if(result[2] != 1) System.out.print(result[2]);
			System.out.print("x");
		}
		if(result[3] >= 1){
			if(result[3] != 1) System.out.print(result[3]);
			System.out.print("i");
		}
		System.out.println();
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