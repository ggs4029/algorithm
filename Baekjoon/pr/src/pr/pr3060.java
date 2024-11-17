// 백준 3060번
// 돼지 6마리가 있고 하루에 한번 밥을 줌.
// 돼지들은 원형 식탁에서 식사하고 기억력이 뛰어나기 때문에 전 날 자신의 양쪽과 맞은편에 앉았던 돼지가 먹었던 양을 기억하고 있음.
// 그리고 욕심이 많아 그 만큼의 양을 다음날 추가하여 식사 하기를 원함.
// 첫 날 돼지들이 먹었던 양이 주어졌을 때, 현수가 6마리의 돼지들의 요구를 들어줄 수 없게 되는 날이 몇 번째 날인지 구하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 테스트 케이스마다 첫 줄에는 매일 배달되는 사료의 양 n이 주어짐.
// 그 다음 줄에는 첫 날 돼지들이 먹는 양이 순서대로 주어진다.
// 돼지사료양 while문 돌며 계산해서 맞는 날짜 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr3060 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			int[] pig = new int[6];
			long sum = 0;
			String[] input = br.readLine().split(" ");
			for(int j=0; j<6; j++) {
				pig[j] = Integer.parseInt(input[j]);
				sum += pig[j];
			}
			// 날짜 구하기
			int output = 1;
			while(sum<=n) {
				output++;
				int tmp1 = pig[0]; int tmp2 = pig[1]; int tmp3 = pig[2];
				int tmp4 = pig[3]; int tmp5 = pig[4]; int tmp6 = pig[5];
				pig[0] += tmp2 + tmp6 + tmp4;
				pig[1] += tmp1 + tmp3 + tmp5;
				pig[2] += tmp2 + tmp4 + tmp6;
				pig[3] += tmp3 + tmp5 + tmp1;
				pig[4] += tmp4 + tmp6 + tmp2;
				pig[5] += tmp1 + tmp5 + tmp3;
				sum = 0;
				for(int k=0; k<6; k++)
					sum += pig[k];
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}