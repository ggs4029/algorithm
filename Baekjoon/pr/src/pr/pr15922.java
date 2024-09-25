// 백준 15922번
// 수직선 위에 점들이 주어졌을때
// 그려지는 선분 길이의 총합을 구하는 문제
// 방법---------------------
// x, y범위 때문에 순회는 불가(시간초과)
// 겹치는 부분을 세지않도록 for문을 돌며 끝점을 갱신하는식으로 풀이
// 첫 줄에 그릴 선분의 개수 n을 입력 받음.
// n줄에 걸쳐 x, y좌표들을 입력 받고
// 완전 겹치는지, 부분 겹치는지, 아예 겹치지않는지 확인하며 선분의 길이를 더해감
// sum값을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		long a = Integer.parseInt(st.nextToken());		// 시작
		long b = Integer.parseInt(st.nextToken());		// 끝
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			// 판정
			if(b>=y) {									// 완전 겹치는 경우
				continue;
			}
			else if(b>=x) {								// 부분 겹치는 경우
				b=y;									// 끝점 확장
			}
			else {										// 겹치지 않는 경우
				sum = sum + Math.abs(b-a);				// 길이 더하기
				a = x;
				b = y;
			}
		}
		sum = sum + Math.abs(b-a);
		// 출력
		System.out.print(sum);
	}
}