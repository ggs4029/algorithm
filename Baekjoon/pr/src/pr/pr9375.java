// 백준 9375번
// 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
// 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
// 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 테스트 케이스마다 첫째 줄엔 해빈이가 가진 의상의 수 n이 주어지고
// 그 다음 n줄에 걸쳐 의상 이름과 의상의 종류가 주어짐.
// 해시맵을 이용해 값을 저장하고 조합의 개수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class pr9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> m = new HashMap<>();
			for(int j=0; j<n; j++) {
				String[] input = br.readLine().split(" ");
				if(m.containsKey(input[1]))
					m.put(input[1], m.get(input[1])+1);
				else
					m.put(input[1], 1);
			}
			int tmp = 1;
			for(int j : m.values())
				tmp = tmp * (j+1);							// j+1인 이유 = 안 입는 경우
			sb.append(tmp-1).append("\n");					// 다 안입는 경우는 없으므로 1빼야함
		}
		// 출력
		System.out.print(sb.toString());
	}
}