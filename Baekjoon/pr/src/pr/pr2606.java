// 백준 2606번
// 1번 컴퓨터를 통해 웜바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 문제
// 방법---------------------
// 첫 줄에 컴퓨터의 수 com이 주어짐.
// 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수 pair가 주어짐.
// 다음 줄부터 input2줄에 걸쳐 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어짐.
// 깊이 우선 탐색으로 1번 컴퓨터에서부터 웜바이러스에 걸린 컴퓨터의 수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr2606 {

	public static ArrayList<Integer>[] list;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int com = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		list = new ArrayList[com+1];
		for(int i=1; i<=com; i++)
			list[i] = new ArrayList<>();
		for(int i=0; i<pair; i++) {
			String[] input = br.readLine().split(" ");
			int tmp = Integer.parseInt(input[0]);
			int tmp2 = Integer.parseInt(input[1]);
			list[tmp].add(tmp2);								// 어디랑 연결되어 있는지 저장
			list[tmp2].add(tmp);								//  		"
		}
		// dfs 호출과 출력
		visited = new boolean[com+1];
		System.out.print(dfs(1));								// 1번 컴퓨터에서 시작
	}

	// dfs
	public static int dfs(int i) {
		// 방문
		visited[i] = true;
		int sum = 0;
		// 연결된 컴퓨터 탐색
		for(int j : list[i]) {
			if(!visited[j])
				sum += 1 + dfs(j);
		}
		return sum;
	}
}