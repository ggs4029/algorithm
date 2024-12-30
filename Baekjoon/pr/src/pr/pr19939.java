// 백준 19939번
// k개 팀이 박 터트리기 게임 함.
// 각 팀은 하나의 바구니를 가지고 있고, 바구니에 들어있는 공을 던져서 자기 팀의 박을 터트려야 함.
// 게임 준비를 위해, n개의 공을 k개의 바구니에 담아야 함.
// 1. n개의 공을 k개의 바구니에 빠짐없이 나누어 담는다.
// 2. 각 바구니에는 1개 이상의 공이 들어 있어야 한다.
// 3. 각 바구니에 담긴 공의 개수는 모두 달라야 한다.
// 4. 가장 많이 담긴 바구니와 가장 적게 담긴 바구니의 공의 개수 차이가 최소가 되어야 한다.
// 위의 규칙을 만족하며 n개의 공을 k개의 바구니에 눠 담을 수 있는지 여부를 결정하고,
// 담을 수 있는 경우에는 가장 많이 담긴 바구니와 가장 적게 담긴 바구니의 공의 개수 차이를 계산해서 출력하는 문제.
// 방법---------------------
// 첫 줄에 n과 k를 입력 받음.
// 1, 2, 3번 규칙에 의해 공을 일단 1, 2, 3, ... ,k-1, k개 담고.
// 이것들의 합이 k * (k + 1) /2 니까 n이 이거보단 같거나 커야함.
// 남은 공을 하나씩 바구니에 담아야 차이 최소니까
// n - (k * (k + 1) /2) 가 k의 배수면  공의 개수 차이는 k-1이고
// k의 배수가 아니면 k개.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19939 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		// 판별 + 출력
		int tmp = k * (k + 1) /2;
		if(n<tmp)
			System.out.print(-1);
		else {
			if((n-tmp)%k==0)
				System.out.print(k-1);
			else
				System.out.print(k);
		}
	}
}