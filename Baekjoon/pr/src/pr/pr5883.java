// 백준 23304번
// 어떤 용량을 원하는 사람을 줄에서 빼 버리면, 같은 용량을 원하는 사람들이
// 연속되어 있는 구간의 길이중 가장 긴 값이 최대가 되는지 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 순서대로 원하는 용량 b(i)가 주어진다.
// 해시맵으로 for문 순회하며 max값 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class pr5883 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		Map<Integer, Integer> m = new HashMap<>();
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if(!m.containsKey(num[i]))						// 맵에 없으면
				m.put(num[i], 1);
			else
				m.put(num[i], m.get(num[i])+1);
		}
		// 연속되어 있는 구간의 길이
		int output = 1;
		for(Integer i : m.keySet()) {
			int tmp = 0;
			int tmp2 = num[0];
			for(int j=0; j<n; j++) {
				if(num[j]==i)
					continue;
				if(tmp2 != num[j])
					tmp = 1;
				else {
					tmp++;
					output = Math.max(output, tmp);
				}
				tmp2 = num[j];
			}
		}
		// 출력
		System.out.print(output);
	}
}