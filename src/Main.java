import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	static int tile[][];
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
				String strs[] = br.readLine().split(" ");
				int h = Integer.parseInt(strs[0]);
				int w = Integer.parseInt(strs[1]);
				if(h == 0) return;
				
				tile = new int[h][w];
				int ax, ay, bx, by;
				
				// フィールド読み取り
				for(int y = 0; y < h; y++){
					String input = br.readLine();
					for(int x = 0; x < w; x++){
						char masu = input.charAt(x);
						switch(masu){
						case '.':
							tile[y][x] = 0;
							break;
						case '#':
							tile[y][x] = -1;
							break;
						case 'A':
							tile[y][x] = 0;
							ax = x;
							ay = y;
							break;
						case 'B':
							tile[y][x] = 0;
							bx = x;
							by = y;
							break;
						}
					}
				}
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