import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
					String strs[] = br.readLine().split(" ");
					int s = Integer.parseInt(strs[0]);
					int d = Integer.parseInt(strs[1]);
					if(s == 0 && d == 0) return;
					
					// 水が通じてるかどうかフラグ
					
					int d_to_s[][] = new int[d][s];
					for(int i = 0; i < s; i++){
						strs = br.readLine().split(" ");
						for(int j = 0; j < d; j++){
							d_to_s[j][i] = Integer.parseInt(strs[j]);
						}
					}

					int d_to_d[][] = new int[d][d];
					for(int i = 0; i < d-1; i++){
						strs = br.readLine().split(" ");
						for(int j = 0; j < strs.length; j++){
							d_to_d[i][i + j + 1] = Integer.parseInt(strs[j]);
							d_to_d[i + j + 1][i] = Integer.parseInt(strs[j]);
						}
					}
					solve(s, d, d_to_s, d_to_d);
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	public static void solve(int s, int d, int d_to_s[][], int d_to_d[][]){
		boolean pipeline_flag[] = new boolean[d];
		
		int before_min = 101;
		int before_min_d = -1;
		for(int i = 0; i < d; i++){
			if(pipeline_flag[i]) continue;
			for(int j = 0; j < s; j++){
				if(d_to_s[i][j] == 0) continue; // 接続されてない場合
				// 最小値を更新した場合
				if(before_min > d_to_s[i][j]){
					before_min = d_to_s[i][j];
					before_min_d = i;
				}
			}
		}
		int sum = before_min;
		pipeline_flag[before_min_d] = true;
		if(flagCheckAnd(pipeline_flag)){
			System.out.println(sum);
			return;
		}
		
		while(true){
			int min_d = -1;
			int min = 101;
			for(int i = 0; i < d; i++){
				if(pipeline_flag[i]) continue;
				for(int j = 0; j < s; j++){
					if(d_to_s[i][j] == 0) continue; // 接続されてない場合
					// 最小値を更新した場合
					if(min > d_to_s[i][j]){
						min = d_to_s[i][j];
						min_d = i;
					}
				}
				for(int j = 0; j < d; j++){
					if(d_to_d[i][j] == 0) continue; // 接続されてない場合
					// 最小値を更新した場合
					if(pipeline_flag[j] && min > d_to_d[i][j]){
						min = d_to_d[i][j];
						min_d = i;
					}
				}
			}
			sum += min;
			pipeline_flag[min_d] = true;
			if(flagCheckAnd(pipeline_flag)){
				System.out.println(sum);
				return;
			}
		}
	}
	
	public static boolean flagCheckAnd(boolean flags[]){
		for(int i = 0; i < flags.length; i++){
			if(!flags[i]) return false;
		}
		return true;
	}
}