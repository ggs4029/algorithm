// 백준 7596번
// Sue가 MP3 플레이어에 있는 곡들을 알파벳 순으로 정렬하는 문제.
// 입력은 여러 개의 시나리오로 구성되어 있습니다.
// 각 시나리오는 첫 번째로 곡의 수를 나타내는 양의 정수 n(1 < n <= 200)이 주어지고, 그 후 n개의 곡 제목이 주어집니다.
// 마지막 입력은 0이며, 이 경우는 처리하지 않습니다.
// 방법---------------------
// 각 시나리오의 첫 줄은 곡의 수 n임.
// 그 뒤 n줄에 걸쳐 곡들의 제목을 입력 받음.
// 출력 할 때는 각 시나리오마다 1부터 시작해 번호를 붙이고 그 다음줄부터 노래 제목 딱딱.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr7596 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tmp = 1;
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			String[] input = new String[n];
			for(int i=0; i<n; i++)
				input[i] = br.readLine();
			// 정렬
			Arrays.sort(input);
			sb.append(tmp).append("\n");
			for(int i=0; i<n; i++)
				sb.append(input[i]).append("\n");
			tmp++;
		}
		// 출력
		System.out.print(sb.toString());
	}
}