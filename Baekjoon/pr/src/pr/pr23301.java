// 백준 12865번
// 여러명의 스터디 참가 시간표가 나오면 거기서 시간 만족도가 최대인 시간을 찾아 출력하는 문제.
// 방법---------------------
// 첫 줄에 스터디 참가자 수 n과 스터디 시간 t가 주어진다.
// 다음 줄부터 참가하고자 하는 참가자들의 시간 정보가 n개 주어진다.
// 각 정보는 첫 줄에는 가능한 시간 수 k가 주어지고
// 그 다음 줄부터 k줄에 걸쳐 가능한 시간의 시작과 끝이 입력됨.
// 배열 사용해 그 시간마다 참여자가 몇명인지 구분.
// 이중 for문으로 범위 쭉 탐색하면서 최대값 찾아 출력하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr23301 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int t = Integer.parseInt(input[1]);
		int[] study = new int[1000+1];
		for(int i=0; i<n;  i++) {
			int k = Integer.parseInt(br.readLine());
			for(int j=0; j<k;  j++) {
				String[] input2 = br.readLine().split(" ");
				int s = Integer.parseInt(input2[0]);
				int e = Integer.parseInt(input2[1]);
				for(int x=s; x<e;  x++)							// 그 시간대 참여면
					study[x]++;									// +1
			}
		}
		// 최대 만족도인 시간 구하기
		int max = -888484;
		int output_s = -1557;
		for(int i=0; i<=1000; i++) {
			int sum = 0;
			for(int j=i; j<i+t; j++) {							// t 범위 동안
				if(j>1000)
					break;
				sum += study[j];								// 만족도의 합 구하기
			}
			if(sum>max) {										// 만족도 더 크면
                max = sum;										// 갱신
                output_s = i;
            }
		}
		// 출력
		System.out.print(output_s+ " ");
		System.out.print(output_s+t);
	}
}