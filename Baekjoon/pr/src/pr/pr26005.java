// 백준 26005번
// 나뭇잎 학회
// NxN 배열로 배치된 여러 개의 스위치가 있고 이 중 하나의 스위치가 전구와 연결되어 있음.
// 스위치 눌러서 전구가 깜빡이는지를 확인해 어떤 스위치가 전구와 연결되어 있는지를 알아내야함.
// 스위치의 작동 방식 - 스위치 하나를 단독으로 누르는게 아니라 상하좌우로 인접한 두 개의 스위치를 동시에 눌러야 전구가 켜짐.
// 즉, 스위치를 누를 때는 반드시 두 개를 동시에 눌러야 한다는 것.
// 전구와 연결된 스위치를 알아내기 위해 필요한 최소한의 나뭇잎 수를 알아내는 문제.
// 나뭇잎 - 스위치를 누를 때마다 하나씩 제출.
// 방법---------------------
// 첫 줄에 N이 입력으로 주어짐.
// Math.round(N^2/2) 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		// 출력
		if(N==1)
			System.out.print(0);
		else
			System.out.print((int)Math.ceil((double)N*N/2));
	}
}