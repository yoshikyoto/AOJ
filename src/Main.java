import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static void printArray(int array[]){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
}