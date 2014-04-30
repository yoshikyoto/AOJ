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
		// ��
		if(y > 0 && tile[y-1][x] != 1){
			// System.out.println("��ɓ�������");
			goUp(tile, x, y, count);
		}
		
		// �E
		if(x < w-1 && tile[y][x+1] != 1){
			// System.out.println("�E�ɓ�������");
			goRight(tile, x, y, count);
		}
		
		// ��
		if(y < h-1 && tile[y+1][x] != 1){
			// System.out.println("���ɓ�������");
			goDown(tile, x, y, count);
		}
		
		// ��
		if(x > 0 && tile[y][x-1] != 1){
			// System.out.println("���ɓ�������");
			goLeft(tile, x, y, count);
		}
		return;
	}
	
	public static void goDown(int tile[][], int x, int y, int count){
		count++;
		// System.out.println("���ɓ�����" + count);
		for(; y < h-1; y++){
			if(tile[y+1][x] == 3){
				// System.out.println("�S�[���ł�: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y+1][x] == 1){
				// System.out.println("�ǂɂԂ�����");
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
		// System.out.println("�E�ɓ�����" + count);
		for(; x < w-1; x++){
			if(tile[y][x+1] == 3){
				// System.out.println("�S�[���ł�: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y][x+1] == 1){
				// System.out.println("�ǂɂԂ�����");
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
		// System.out.println("��ɓ�����" + count);
		for(; y > 0; y--){
			if(tile[y-1][x] == 3){
				// System.out.println("�S�[���ł�: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y-1][x] == 1){
				// System.out.println("�ǂɂԂ�����");
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
		// System.out.println("���ɓ�����" + count);
		for(; x > 0; x--){
			if(tile[y][x-1] == 3){
				// System.out.println("�S�[���ł�: " + count);
				if(count < answer) answer = count;
				return;
			}
			if(tile[y][x-1] == 1){
				// System.out.println("�ǂɂԂ�����");
				tile[y][x-1] = 0;
				solve(tile, x, y, count);
				tile[y][x-1] = 1;
				return;
			}
		}
		return;
	}
}