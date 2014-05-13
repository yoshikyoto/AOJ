import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	static int[][] tile;
	static String[] tagnames;
	static int[] tagcontents;
	static int index;
	
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) return;
			
			tile = new int[10001][10001];
			tagnames = new String[100];
			tagcontents = new int[100];
			index = 1;
			
			String xml = br.readLine();
			parse(xml);
			
			print();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static int parse(String xml){
		int num_of_contents = 0;
		while(true){
			// タグを抽出
			int left = xml.indexOf("<");
			int right = xml.indexOf(">");
			if(left == -1) break;
			num_of_contents++;
			int this_tag_index = index;
			index++;
			String tagname = xml.substring(left + 1, right);
			tagnames[this_tag_index] = tagname;
			int tagname_length = right - left - 1;
			System.out.println("tagname: " + tagname + "\tlength " + tagname_length);
			
			// タグの中身を抽出
			int begin = xml.indexOf("<" + tagname + ">");
			int end = xml.indexOf("</" + tagname + ">");
			String contents = xml.substring(begin + tagname_length + 2, end);
			System.out.println("contents: " + contents);
			
			// 座標と中身を分割, 中身をパース
			int contents_index = contents.indexOf("<");
			String coordinate = new String();
			if(contents_index == -1){
				coordinate = contents;
				contents = "";
			}else{
				coordinate = contents.substring(0, contents_index);
				contents = contents.substring(contents_index);
				tagcontents[this_tag_index] = parse(contents);
			}
			
			// 座標のsplit
			String coordinateArr[] = coordinate.split(",");
			int sx = Integer.parseInt(coordinateArr[0]);
			int sy = Integer.parseInt(coordinateArr[1]);
			int ex = Integer.parseInt(coordinateArr[2]);
			int ey = Integer.parseInt(coordinateArr[3]);
			System.out.println(sx + "\t" + sy + "\t" + ex + "\t" + ey);
			// sx = sx / 10;
			// sy = sy / 10;
			// ex = ex / 10;
			// ey = ey / 10;
			
			for(int x = sx; x <= ex; x++){
				for(int y = sy; y <= ey; y++){
					tile[y][x] = this_tag_index;
				}
			}
			
			xml = xml.substring(end + tagname_length + 3);
			System.out.println(xml);
		}
		return num_of_contents;
	}
	
	static void print(){
		for(int i = 1; i < index; i++){
			System.out.print(tagnames[i] + "\t");
		}
		System.out.println();

		for(int i = 1; i < index; i++){
			System.out.print(tagcontents[i] + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < 1000; i++){
			for(int j = 0; j < 1000; j++){
				System.out.print(tile[i*10][j*10]);
			}
			System.out.println();
		}
	}
}