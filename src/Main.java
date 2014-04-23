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
				
				boolean xy[][] = new boolean[n][n];
				boolean xz[][] = new boolean[n][n];
				boolean yz[][] = new boolean[n][n];
				int answer = n * n * n;
				
				for(int i = 0; i < h; i++){
					strs = br.readLine().split(" ");
					int arg1 = Integer.parseInt(strs[1]) - 1;
					int arg2 = Integer.parseInt(strs[2]) - 1;
					if(strs[0].equals("xy")){
						// xy
						xy[arg1][arg2] = true;
						for(int j = 0; j < n; j++){
							if(xz[arg1][j]) continue;
							if(yz[arg2][j]) continue;
							answer--;
						}
					}else if(strs[0].equals("xz")){
						// xz
						xz[arg1][arg2] = true;
						for(int j = 0; j < n; j++){
							if(xy[arg1][j]) continue;
							if(yz[j][arg2]) continue;
							answer--;
						}
					}else{
						// yz
						yz[arg1][arg2] = true;
						for(int j = 0; j < n; j++){
							if(xy[j][arg1]) continue;
							if(xz[j][arg2]) continue;
							answer--;
						}
					}
				}
				System.out.println(answer);
			}
		} catch (Exception e) {
		}
	}
}