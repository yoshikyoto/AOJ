import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
					int n = Integer.parseInt(br.readLine());
					if(n == 0) return;

					String strs[] = br.readLine().split(" ");
					int num = (n * (n-1)) / 2;
					int sum = 0;
					for(int i = 0; i < num; i++){
						sum += Integer.parseInt(strs[i]);
					}
					sum = sum / (n - 1);
					System.out.println(sum);
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}