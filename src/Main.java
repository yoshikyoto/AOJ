import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class Main{
	static int kyori[][];
	static boolean visited[];
	static double answer;
	static int n, m, b;
	static Integer tickets[];
	static double leastCost[];
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
				String strs[] = br.readLine().split(" ");
				n = Integer.parseInt(strs[0]); // �n�Ԍ��̐�
				if(n == 0) return;
				tickets = new Integer[n];
				
				m = Integer.parseInt(strs[1]); // �s�s�̐�
				kyori = new int[m][m];
				visited = new boolean[m];
				leastCost = new double[m];
				
				int p = Integer.parseInt(strs[2]); // ���H�̐�
				
				int a = Integer.parseInt(strs[3]) - 1; // �X�^�[�g
				
				b = Integer.parseInt(strs[4]) - 1; // �S�[��
				
				// �`�P�b�g
				strs = br.readLine().split(" ");
				for(int i = 0; i < n; i++){
					tickets[i] = Integer.parseInt(strs[i]);
				}
				Arrays.sort(tickets, Collections.reverseOrder());
				// printArray(tickets);
				
				
				// ��
				for(int i = 0; i < p; i++){
					strs = br.readLine().split(" ");
					int x = Integer.parseInt(strs[0]) - 1;
					int y = Integer.parseInt(strs[1]) - 1;
					int z = Integer.parseInt(strs[2]);
					kyori[x][y] = z;
					kyori[y][x] = z;
				}
				
				// printMatrix(kyori);
				answer = 0.0;
				Integer distance[] = new Integer[n];
				for(int i = 0; i < n; i++){
					distance[i] = 0;
				}
				dfs(a, 0, distance);
				if(answer == 0.0){
					System.out.println("Impossible");
				}else{
					System.out.println(answer);
				}
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static void dfs(int now, int count, Integer distance[]){
		// ���B�������ǂ���
		if(now == b){
			// System.out.println("���B���܂���");
			//printArray(distance);
			Integer dis_clone[] = distance.clone();
			Arrays.sort(dis_clone, Collections.reverseOrder());
			double result_temp = 0.0;
			
			for(int i = 0; i < count; i++){
				result_temp += (double)dis_clone[i] / (double)tickets[i];
			}
			// System.out.println(result_temp);
			if(answer == 0.0){
				answer = result_temp;
			}else if(answer > result_temp){
				answer = result_temp;
			}
			//printArray(visited);
			return;
		}
		
		// �n���̖����𒴂��Ă��Ȃ���
		// ���Ӂ@�n���̖�����0�X�^�[�g�ɂ��Ă�
		if(count >= n || count >= m) return;
		// System.out.println("���̏ꏊ: " + now + "\t�S�[��: " + b);
		
		// �ŏ��R�X�g�Ŏ}����
		Integer distance_clone[] = distance.clone();
		Arrays.sort(distance_clone, Collections.reverseOrder());
		double current_result = 0.0;
		for(int i = 0; i < count; i++){
			current_result += (double)distance_clone[i] / (double)tickets[i];
		}
		if(leastCost[now] == 0.0){
			leastCost[now] = current_result;
		}else{
			if(leastCost[now] >= current_result){
				leastCost[now] = current_result;
			}else{
				return;
			}
		}
		
		visited[now] = true;
		// ���̓s�s��
		for(int i = 0; i < m; i++){
			// �s����s�s���ǂ����m�F
			if(kyori[now][i] != 0 && !visited[i]){
				// System.out.println("���̊X��: " + i + "\t���̊X: " + now);
				distance[count] = kyori[now][i];
				dfs(i, count + 1, distance);
				distance[count] = 0;
				// System.out.println("backtrack");
			}
		}
		visited[now] = false;
	}
	/*
	
	public static void printArray(int array[]){
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + "\t");
		System.out.println();
	}
	
	public static void printArray(Integer array[]){
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
	*/
}