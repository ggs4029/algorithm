// 백준 1011번
// x지점부터 y지점까지 이동하는데 필요한 공간 이동 장치 작동 횟수의 최솟값을 구하는 문제.
// 방법---------------------
// 첫 줄에 테스트케이스의 개수 t를 입력 받음.
// 테스트 케이스에 대해 현재 위치 x와 목표 위치 y를 한줄에 입력 받음.
// 이동 조건이 아래와 같으므로
// 1. 처음 이동은 1광년.
// 2. 마지막 이동의 도착은 도착거리에서 1광년 전이어야 함.
// 3. 둘을 제외한 이동은 k−1, k, k+1 중 하나. ( k는 이전 작동시기에 이동한 광년)
// 즉 처음 시작이 1광년이므로
// 홀수번째 이동 -> 짝수번째 이동한 거리만큼 이동
// 짝수번째 이동 -> k+1만큼 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			// 작동 횟수 최솟값 구하기
			int output = 0;										// 이동 횟수
			int k = 1;											// 처음 이동은 1광년
			int distance = y-x;
			while(distance>0) {									// 도착전이면
				output++;										// 이동
				distance -= k;
				if(output%2==0)									// 짝수번째 이동인 경우
					k++;										// k증가
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}