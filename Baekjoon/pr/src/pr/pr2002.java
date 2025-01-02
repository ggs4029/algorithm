// 백준 2002번
// N개의 차량이 터널을 지나간 후, 대근이와 영식이는 자신들이 적어 둔 차량 번호의 목록을 보고,
// 터널 내부에서 반드시 추월을 했을 것으로 여겨지는 차들이 몇 대 있다는 것을 알게 되었다.
// 대근이와 영식이를 도와 반드시 추월을 했을 것으로 여겨지는 차의 개수를 구하는 문제.
// 대근이는 터널 입구, 영식이는 터널 출구에서 차량 번호 적음.
// 방법---------------------
// 첫째 줄에 차량 수 n 주어짐.
// 그 다음 줄부터 n줄에는 대근이가 적은 차량 번호가 쭉 입력 되고
// 그 다음 n줄에는 영식이가 적은 차량 번호들이 입력됨.
// 연결해시맵으로 구현.
// 반복자 사용해 키셋 순회하며 차량이 추월했는지 검사하고 결과 값을 출력.
// * 비교 끝난 차량은 해시맵에서 제거해야함. *

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class pr2002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		LinkedHashMap<String, Integer> m = new LinkedHashMap<>();	// 대근
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			m.put(input, i);
		}
		// 추월 차량 개수 구하기
		int output = 0;
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			Iterator<String> tmp = m.keySet().iterator();
            while(tmp.hasNext()){									// 키셋 순회
                if(m.get(input)>m.get(tmp.next())){					// 먼저 나온 차보다 입력 받은 차량이 먼저 나왔으면
                    output++;
                    break;
                }
            }
            m.remove(input);										// 비교 끝난 차량 제거
		}
		// 출력
		System.out.print(output);
	}
}