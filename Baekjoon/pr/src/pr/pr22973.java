// 백준 23304번
// 현욱이가 0번 지점에 있고 형이 k번 지점에 있음.
// 현욱이는 맨 처음에 1만큼 점프함.
// 그 뒤로 신이나서 점프할 때마다 이전에 점프할 때 뛴 거리의 두 배만큼의 거리를 움직임.
// 형 위치가 주어지면 형을 찾기 위해 필요한 최소 점프 횟수를 구하는 문제.
// 방법---------------------
// 첫 줄에 형 위치 k가 주어짐.
// 0 1 3 7 15 31 이렇게 2^n-1로 점프를 하고 있음.
// 그래서 형이 짝수번에 서 있으면 평생 못만남.
// k가 음수면 양수로 바꿔주고 루프 돌면서 2로 나눠가며 점프횟수 ++ 하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr22973 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long k = Long.parseLong(br.readLine());
		// 점프 횟수 구하기
		if(k == 0) {								// k가 0이면
			System.out.print(0);					// 이미 만났음
			return;
		}
		else if(k < 0)								// k가 음수면
			k = k * (-1);							// 양수로 바꾸고 진행
		if(k%2 == 0) {								// k가 짝수면
			System.out.print(-1);					// 절대 못만남
			return;
		}
		long sum = 0;
		while(k > 0) {
			k /= 2;
			sum++;
		}
		// 출력
		System.out.print(sum);
	}
}