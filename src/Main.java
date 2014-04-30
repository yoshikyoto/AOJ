import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	static int sx, sy, gx, gy;
	static int answer;
	static int w, h;
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
				String strs[] = br.readLine().split(" ");
				w = Integer.parseInt(strs[0]);
				h = Integer.parseInt(strs[1]);
				if(w == 0) return;
				
				int tile[][] = new int[h][w];
				
				for(int i = 0; i < h; i++){
					strs = br.readLine().split(" ");
					for(int j = 0; j < w; j++){
						tile[i][j] = Integer.parseInt(strs[j]);
						if(tile[i][j] == 2){
							sy = i;
							sx = j;
						}
						if(tile[i][j] == 3){
							gy = i;
							gx = j;
						}
					}
				}
				//System.out.println(sy + " " + sx + " " + gy + " " + gx);
				int ans = solve(tile, sx, sy, 0);
				if(ans == 11) ans = -1;
				System.out.println(ans);
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static int solve(int tile[][], int x, int y, int count){
		//tile[y][x] = 2;
		// printMatrix(tile);
		if(count >= 10) return 11;
		int up = 11, right = 11, down = 11, left = 11;
		// 上
		if(y > 0 && tile[y-1][x] != 1){
			// System.out.println("上に動かせる");
			up = goUp(tile, x, y, count);
		}
		
		// 右
		if(x < w-1 && tile[y][x+1] != 1){
			// System.out.println("右に動かせる");
			right = goRight(tile, x, y, count);
		}
		
		// 下
		if(y < h-1 && tile[y+1][x] != 1){
			// System.out.println("下に動かせる");
			down = goDown(tile, x, y, count);
		}
		
		// 左
		if(x > 0 && tile[y][x-1] != 1){
			// System.out.println("左に動かせる");
			left = goLeft(tile, x, y, count);
		}
		return Math.min(Math.min(up, down), Math.min(right, left));
	}
	
	public static int goDown(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("下に動かす" + count);
		for(; y < h-1; y++){
			if(tile[y+1][x] == 3){
				// System.out.println("ゴールです: " + count);
				return count;
			}
			if(tile[y+1][x] == 1){
				// System.out.println("壁にぶつかった");
				tile[y+1][x] = 0;
				int result = solve(tile, x, y, count);
				tile[y+1][x] = 1;
				return result;
			}
		}
		return 11;
	}
	
	public static int goRight(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("右に動かす" + count);
		for(; x < w-1; x++){
			if(tile[y][x+1] == 3){
				// System.out.println("ゴールです: " + count);
				return count;
			}
			if(tile[y][x+1] == 1){
				// System.out.println("壁にぶつかった");
				tile[y][x+1] = 0;
				int result = solve(tile, x, y, count);
				tile[y][x+1] = 1;
				return result;
			}
		}
		return 11;
	}
	
	public static int goUp(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("上に動かす" + count);
		for(; y > 0; y--){
			if(tile[y-1][x] == 3){
				// System.out.println("ゴールです: " + count);
				return count;
			}
			if(tile[y-1][x] == 1){
				// System.out.println("壁にぶつかった");
				tile[y-1][x] = 0;
				int result = solve(tile, x, y, count);
				tile[y-1][x] = 1;
				return result;
			}
		}
		return 11;
	}
	
	public static int goLeft(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("左に動かす" + count);
		for(; x > 0; x--){
			if(tile[y][x-1] == 3){
				// System.out.println("ゴールです: " + count);
				return count;
			}
			if(tile[y][x-1] == 1){
				// System.out.println("壁にぶつかった");
				tile[y][x-1] = 0;
				int result = solve(tile, x, y, count);
				tile[y][x-1] = 1;
				return result;
			}
		}
		return 11;
	}
}