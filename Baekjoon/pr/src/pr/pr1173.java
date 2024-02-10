// 백준 1173번
// 운동
// 운동을 N분 하는데 필요한 시간의 최솟값 구하기
// 방법------------------------------
// 운동하고자 하는 시간 N
// 초기 맥박 m
// 넘어서는 안되는 맥박 M
// 운동시 분당 맥박 증가량 T
// 휴식시 분당 맥박 감소량 R
// 5개를 한줄에 입력 받고
// while문을 돌며
// 운동 1분 후 맥박이 M보다 작으면 운동 아니면 휴식한다.
// 휴식시 맥박이 m보다 아래로 떨어지면 m으로 다시 설정해준다.
// 운동시간을 채울 수 없는 경우를 주의해서 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1173 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int N = Integer.parseInt(st.nextToken());	// 운동하고자 하는 시간
		int m = Integer.parseInt(st.nextToken());	// 맥박 최솟값
		int M = Integer.parseInt(st.nextToken());	// 맥박 최댓값
		int T = Integer.parseInt(st.nextToken());	// 운동시 분당 맥박 증가량
		int R = Integer.parseInt(st.nextToken());	// 휴식시 분당 맥박 감소량
		// 시간 구하기
		int time = 0;			// 운동을 N분하는데 걸린 최솟값을 저장할 변수
		int n = 0;				// 운동만 한 시간
		int min = m;			// 맥박 최솟값
		while(n != N) {
			time++;
			// 운동하는 경우
			if(m+T <= M) {
				n++;			// 운동 시간 +1
				m += T;			// 맥박 + T
			}
			// 휴식하는 경우
			else {
				if(m-R < min)	// 초기 맥박 아래로 떨어지는 경우
					m = min;	// 초기 맥박으로 다시 설정
				else
					m -= R;
			}
			// 운동시간을 채울 수 없는 경우
			if((m+T > M) && (m==min))
				break;
		}
		// 출력
		if(n != N)
			System.out.print(-1);
		else
			System.out.print(time);
	}
}