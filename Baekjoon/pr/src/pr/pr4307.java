// 백준 4307번
// 개미 여러 마리가 막대 위에 있고 개미들이 1cm/s로 이동할때
// 모든 개미가 땅으로 떨어질 때까지 가능한 시간 중 가장 빠른 시간과 느린 시간을 구하는 문제
// 개미가 어느 방향으로 움직이는지는 알 수 없음.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받고
// 각 테스트 케이스의 첫째 줄에는 막대의 길이와 개미의 수 n을 입력 받는다.
// 그 다음 n줄에는 개미의 초기 위치를 입력 받음.
// 가장 빠른 시간 - 모든 개미가 더 가까운 곳으로 바로 떨어지는 경우
//				 = 가운데에서 제일 가까운 개미가 떨어지는데까지 걸리는 시간
// 가장 느린 시간 - 모든 개미가 더 먼 곳으로 떨어지는 경우
//				 = 제일 왼쪽애가 오른쪽으로 떨어질 때까지 걸리는 시간
//					or 제일 오른쪽애가 왼쪽으로 떨어질 때까지 걸리는 시간
// 구해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr4307 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int l = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			int[] ant = new int[n];
			for(int j=0; j<n; j++) {
				ant[j] = Integer.parseInt(br.readLine());
			}
			// 정렬
			Arrays.sort(ant);
			// 가장 느린 시간 구하기
			int tmp1 = Integer.MIN_VALUE;					// 가운데에서 제일 가까운 왼쪽 개미
			int tmp2 = Integer.MAX_VALUE;					// 가운데에서 제일 가까운 오른쪽 개미
			for(int j : ant) {
				if(j<l/2)									// 왼쪽이면
					tmp1 = Math.max(tmp1, j);
				else if(j>=l/2)								// 오른쪽이면
					tmp2 = Math.min(tmp2, j);
			}
			// 가장 빠른 시간 구하기
			int tmp3 = Integer.MAX_VALUE;					// 가운데에서 제일 먼 왼쪽 개미
			int tmp4 = Integer.MIN_VALUE;					// 가운데에서 제일 먼 오른쪽 개미
			for(int k : ant) {
				if(k<l/2)									// 왼쪽이면
					tmp3 = Math.min(tmp3, k);
				else if(k>=l/2)								// 오른쪽이면
					tmp4 = Math.max(tmp4, k);
			}
			// 출력
			System.out.print(Math.max(tmp1, l-tmp2)+" ");
			System.out.println(Math.max(l-tmp3, tmp4));
		}
		return;
	}
}