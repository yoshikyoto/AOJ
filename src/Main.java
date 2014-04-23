import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	static int hei[];
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
				String strs[] = br.readLine().split(" ");
				int w = Integer.parseInt(strs[0]);
				int q = Integer.parseInt(strs[1]);
				if(w == 0 && q == 0) return;
				hei = new int[w];
				for(int i = 0; i < w; i++){
					hei[i] = -1;
				}
				
				for(int i = 0; i < q; i++){
					strs = br.readLine().split(" ");
					char method = strs[0].charAt(0);
					switch(method){
					case 's':{
						int id = Integer.parseInt(strs[1]);
						int cat_w = Integer.parseInt(strs[2]);
						sleep(id, cat_w);
						break;
					}
					case 'w':{
						int id = Integer.parseInt(strs[1]);
						wakeup(id);
						break;
					}
					}
				}
				System.out.println("END");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static void sleep(int id, int cat_w){
		int space = 0;
		int point = 0;
		for(int i = 0; i < hei.length; i++){
			if(hei[i] == -1){
				if(space == 0) point = i;
				space++;
				if(space >= cat_w){
					System.out.println(point);
					for(int j = 0; j < space; j++){
						hei[point + j] = id;
					}
					return;
				}
			}else{
				space = 0;
			}
		}
		System.out.println("impossible");
	}
	
	public static void wakeup(int id){
		int point = 0;
		for(int i = 0; i < hei.length; i++){
			if(hei[i] == id){
				point = i;
				break;
			}
		}
		for(int i = point; i < hei.length; i++){
			if(hei[i] != id) break;
			hei[i] = -1;
		}
	}
	
	public static void printArray(int array[]){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
}