// 백준 2529번
// 제시된 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수를 첫째 줄과 둘째 줄에 각각 출력하는 문제.
// 각 부등호의 앞뒤에 들어가는 숫자는 0~9 중에서 선택해야 하고 선택된 숫자는 모두 달라야 함.
// 방법---------------------
// 첫 줄에 부등호 문자의 개수 k가 주어짐.
// 그 다음줄에 부등호들이 주어짐.
// dfs로 구현.
// k의 범위가 작으므로 저장과 출력에 ArrayList 사용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr2529 {

	public static boolean visited[] = new boolean[10];
	public static String num[];
	public static ArrayList<String> output = new ArrayList<>();

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int k = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		num = new String[k];
		for(int i=0; i<k;i++)
			num[i] = input[i];
		// dfs
		for(int i=0; i<10; i++){														// 0~9
			visited[i] = true;															// i 방문
			String tmp = i+"";
			dfs(i, 0, k, tmp);
			visited[i] = false;
		}
		// 출력
		System.out.println(output.get(output.size()-1));								// 최대값
		System.out.print(output.get(0));												// 최소값
	}

	// dfs
	static void dfs(int tmp, int sum, int k, String tmp2){
		if(sum==k){
			output.add(tmp2);															// 완성된 숫자 add
			return;
		}
		// 탐색
		for(int i=0; i<10; i++){
			if(!visited[i]){
				if((num[sum].equals("<") && tmp<i) || (num[sum].equals(">")&& tmp>i)){	// 부등호랑 다음 수랑 맞는지
					visited[i]=true;
					dfs(i, sum+1, k, tmp2+i);											// 다음 수로 재귀
					visited[i]=false;
				}
			}
		}
	}
}