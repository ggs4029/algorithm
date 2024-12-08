// 백준 7662번
// 정수만 저장하는 이중 우선순위 큐 Q가 있음.
// Q에 저장된 각 정수의 값 자체를 우선순위라고 간주.
// Q에 적용될 일련의 연산이 주어질 때 이를 처리한 후 최종적으로 Q에 저장된 데이터 중 최댓값과 최솟값을 출력하는 문제.
// 방법---------------------
// 첫째 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스의 첫 줄엔 Q에 적용할 연산의 개수를 나타내는 k가 주어짐.
// 그 다음 줄부터 k줄에 걸쳐 연산을 나타내는 문자 (D or I)와 n이 주어짐.
// I는 n을 삽입하라는 뜻.
// D 1은 최댓값 삭제, D -1은 최솟값 삭제.
// 트리맵을 구현해 사용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class pr7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			TreeMap<Integer, Integer> m = new TreeMap<>();
			// 입력
			int k = Integer.parseInt(br.readLine());
			for(int j=0; j<k; j++) {
				String[] input = br.readLine().split(" ");
				// 데이터 삽입 연산
				if(input[0].equals("I"))
					m.put(Integer.parseInt(input[1]), m.getOrDefault(Integer.parseInt(input[1]), 0)+1);
				// 데이터 삭제 연산
				else {
					if(m.isEmpty())															// 비었으면 스킵
						continue;
					else if(Integer.parseInt(input[1])==1){									// 최댓값 삭제
						int tmp = m.lastKey();
						if(m.get(tmp)==1)
							m.remove(tmp);
						else
							m.put(tmp, m.get(tmp)-1);
					}
					else{																	// 최솟값 삭제
						int tmp = m.firstKey();
						if(m.get(tmp)==1)
							m.remove(tmp);
						else
							m.put(tmp, m.get(tmp)-1);
					}
				}
			}
			if(m.isEmpty())
				sb.append("EMPTY").append("\n");
			else
				sb.append(m.lastKey()+ " " + m.firstKey()).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}