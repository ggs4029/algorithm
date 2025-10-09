// 백준 8986번
// 일직선상에 n개의 전봇대가 한 줄로 서있음.
// 이 전봇대들을 이웃한 두 전봇대 사이의 거리가 모두 일정하도록 일부 전봇대들을 옮기려함.
// 이동해야하는 전봇대들의 거리의 합이 최소가 되도록 하고 싶음.
// 단, x0에 위치한 전봇대는 움직일 수 없고 나머지들도 정수 좌표로만 이동 가능.
// 전봇대들의 위치가 주어지면 이동 거리의 합이 최소가 되는 그 이동 거리를 출력하는 문제.
// 방법---------------------
// 첫 줄에 전봇대의 수 n이 주어짐.
// 두번째 줄에 전봇대들의 위치 n개가 한 줄에 주어진다.
// 기본적인 삼분 탐색으로 전봇대들 위치를 구하면
// 오답노트------------------
// 1. 맨 왼쪽에 있는 전봇대 (x0)은 움직일 수 없음.
// 2. 이웃한 전봇대들 사이의 거리가 모두 일정하도록 만들어야함.
// 따라서 맨 왼쪽을 고정하고 dㄹㄹ 바꿔가며 삼분 탐색을 하는게 맞지 않나.
// 즉 d값에 따른 전봇대들의 이동 거리의 최소 합을 구하기.
// 오답노트2-----------------
// 시간 초과 -> n번 도는 for문을 while(right-left > 3)으로 변경

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr8986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Long.parseLong(st.nextToken());
		// 삼분 탐색
		long left = 0;													// 최소 d
		long right = num[n - 1];
		while(right-left > 3) {
			long leftThird = left + (right - left) / 3;					// 1/3 지점
			long rightThird = right - (right - left) / 3;				// 2/3 지점
			// 이동 거리 구하기
			long tmp1 = dSum(num, leftThird);
            long tmp2 = dSum(num, rightThird);
            // 간격 좁히기
			if(tmp1 < tmp2)												// 왼쪽 지역이 이동 거리 합이 더 작으면
				right = rightThird;										// 맨 오른쪽 지역 버리기
			else														// 왼쪽 지역이 이동 거리 합이 크거나 같으면
				left = leftThird;										// 맨 왼쪽 지역 버리기
		}
		// 이동거리 최소 합 구하기
		long output = Long.MAX_VALUE;
		for(long i=left; i<=right; i++)
			output = Math.min(output, dSum(num, i));
		// 출력
		System.out.print(output);
	}

	// 간격이 d일때 전봇대들의 이동 거리 합 계산 메소드
	public static long dSum(long[] num, long d) {
		long output = 0;
		for(int i=1; i<num.length; i++)
			output += Math.abs(num[i] - (i * d));
		return output;
	}
}