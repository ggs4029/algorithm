// 백준 ???번 - A번 햄버거
// 같은 종류의 빵 A개, 패티 B개, 양상추 C개, 토마토 D개를 가지고 있음.
// 입력에 대해서 맛있는 햄버거인지 결과를 출력하면 되는 문제.
// 맛있는 햄버거의 조건은 문제 참고.
// 방법---------------------
// 첫 줄에 문자열 s의 길이를 나타내는 n이 주어짐.
// 두번째 줄에 정수 ABCD가 주어짐.
// 세번째 줄에는 알파벳 소문자 abcd로만 이루어진 문자열 s가 주어진다.
// a는 빵 b는 패티 c는 양상추 d는 토마토임.
// 문제에서 주어진 조건들을 하나하나씩 차례로 검사하며 통과하지 못하면 No출력.
// 다 통과하면 Yes출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int C = Integer.parseInt(input[2]);
		int D = Integer.parseInt(input[3]);
		String s = br.readLine();
		// 햄부거 맛 판별
		// 가장 위와 아래는 빵
		if(s.charAt(0)!='a' || s.charAt(n-1)!='a') {						// 맨위 아래 확인
			System.out.print("No");
			return;
        }
		// 인접한 재료는 같을 수 X
		for(int i=1; i<n; i++) {
            if(s.charAt(i-1)==s.charAt(i)) {								// 똑같은 재료 붙어있으면
            	System.out.print("No");
                return;
            }
		}
		// 재료 초과 사용 금지
		int[] food = new int[4];
		for(int i=0; i<n; i++) {											// 재료 개수 세기
			if(s.charAt(i) == 'a')
				food[0]++;
			else if(s.charAt(i)=='b')
				food[1]++;
			else if(s.charAt(i)=='c')
				food[2]++;
			else if(s.charAt(i)=='d')
				food[3]++;
		}
		if(food[0]>A || food[1]>B || food[2]>C || food[3]>D) {				// 초과했으면
			System.out.print("No");
            return;
        }
		// 출력
		System.out.print("Yes");
	}
}