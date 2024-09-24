// 백준 7347번
// 검, 흰 원판으로 이루어진 수열을 플립 동작을 이용해
// 검은색은 검은색끼리 흰색은 흰색끼리 모을수 있는지 여부를 확인하는 문제
// 방법---------------------
// 첫째 줄에 테스트 케이스의 개수 T를 입력 받음.
// T줄에 걸쳐 테스트 케이스의 길이 + 수열을 입력 받음.
// 테스트 케이스의 길이가 홀수인 경우 - 어느 경우에도 YES
//					짝수인 경우 - 생각을 해봐야함
// 짝수인 경우에 성립하는 경우 -
// 		1. 흰돌이 짝수개인 경우 - 홀수번째에 있는 흰돌의 개수 = 짝수번째에 있는 흰돌의 개수
//		2. 흰돌이 홀수개인 경우 - |홀수번째에 있는 흰돌의 개수 - 짝수번째에 있는 흰돌의 개수| = 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr7347 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int a = 0;
			int b = 0;
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			for(int j=0; j<length; j++) {
				int test = Integer.parseInt(st.nextToken());
				// 홀짝 개수 세기
				if(j%2==1 && test==0) {
					a++;
				}
				else if(j%2==0 && test==0) {
					b++;
				}
			}
			// 출력
			if(length%2==1 || (a-b==1 || a-b==-1 || a-b==0)) {
				System.out.println("YES");
			}
			else
				System.out.println("NO");
		}
	}
}