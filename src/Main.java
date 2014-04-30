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
				answer = 11;
				solve(tile, sx, sy, 0);
				if(answer == 11) answer = -1;
				System.out.println(answer);
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static void solve(int tile[][], int x, int y, int count){
		//tile[y][x] = 2;
		// printMatrix(tile);
		if(count+1 >= answer) return;
		// ã
		if(y > 0 && tile[y-1][x] != 1){
			// System.out.println("ã‚É“®‚©‚¹‚é");
			goUp(tile, x, y, count);
		}
		
		// ‰E
		if(x < w-1 && tile[y][x+1] != 1){
			// System.out.println("‰E‚É“®‚©‚¹‚é");
			goRight(tile, x, y, count);
		}
		
		// ‰º
		if(y < h-1 && tile[y+1][x] != 1){
			// System.out.println("‰º‚É“®‚©‚¹‚é");
			goDown(tile, x, y, count);
		}
		
		// ¶
		if(x > 0 && tile[y][x-1] != 1){
			// System.out.println("¶‚É“®‚©‚¹‚é");
			goLeft(tile, x, y, count);
		}
		return;
	}
	
	public static void goDown(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("‰º‚É“®‚©‚·" + count);
		for(; y < h-1; y++){
			if(tile[y+1][x] == 3){
				// System.out.println("ƒS[ƒ‹‚Å‚·: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y+1][x] == 1){
				// System.out.println("•Ç‚É‚Ô‚Â‚©‚Á‚½");
				tile[y+1][x] = 0;
				solve(tile, x, y, count);
				tile[y+1][x] = 1;
				return;
			}
		}
		return;
	}
	
	public static void goRight(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("‰E‚É“®‚©‚·" + count);
		for(; x < w-1; x++){
			if(tile[y][x+1] == 3){
				// System.out.println("ƒS[ƒ‹‚Å‚·: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y][x+1] == 1){
				// System.out.println("•Ç‚É‚Ô‚Â‚©‚Á‚½");
				tile[y][x+1] = 0;
				solve(tile, x, y, count);
				tile[y][x+1] = 1;
				return;
			}
		}
		return;
	}
	
	public static void goUp(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("ã‚É“®‚©‚·" + count);
		for(; y > 0; y--){
			if(tile[y-1][x] == 3){
				// System.out.println("ƒS[ƒ‹‚Å‚·: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y-1][x] == 1){
				// System.out.println("•Ç‚É‚Ô‚Â‚©‚Á‚½");
				tile[y-1][x] = 0;
				solve(tile, x, y, count);
				tile[y-1][x] = 1;
				return;
			}
		}
		return;
	}
	
	public static void goLeft(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("¶‚É“®‚©‚·" + count);
		for(; x > 0; x--){
			if(tile[y][x-1] == 3){
				// System.out.println("ƒS[ƒ‹‚Å‚·: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y][x-1] == 1){
				// System.out.println("•Ç‚É‚Ô‚Â‚©‚Á‚½");
				tile[y][x-1] = 0;
				solve(tile, x, y, count);
				tile[y][x-1] = 1;
				return;
			}
		}
		return;
	}
}