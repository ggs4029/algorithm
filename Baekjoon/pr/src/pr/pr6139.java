// 백준 6139번
// 소 k마리가 책을 다 읽는데 걸리는 시간을 출력하는 문제
// 시간은 분 단위로 올림하여 출력.
// 방법---------------------
// 첫 줄에 책의 페이지 n과 소의 마릿수 k가 주어짐.
// 다음줄부터 k줄에 걸쳐 그 소의 읽는 속도 s와 연속으로 읽을 수 있는 시간 t, 휴식시간 r이 주어짐.
// 각 마리마다 책을 다 읽는데 걸리는 시간을 구해 한줄씩 k줄 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6139 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input1 = br.readLine().split(" ");
		int n = Integer.parseInt(input1[0]);
		int k = Integer.parseInt(input1[1]);
		int[][] cows = new int[k][3];
		for(int i=0; i<k; i++) {
			String[] input2 = br.readLine().split(" ");
			cows[i][0] = Integer.parseInt(input2[0]);
			cows[i][1] = Integer.parseInt(input2[1]);
			cows[i][2] = Integer.parseInt(input2[2]);
		}
		// 책 읽는 시간 계산
		for(int i=0; i<k; i++) {
			int time = 0;											// 시간
			int tmp = n;											// 남은 책 페이지
			while(tmp>0) {											// 책 페이지가 하나라도 남아있으면
				if(tmp>cows[i][0]*cows[i][1]) {						// 한 사이클초과로 페이지가 남아있으면
					tmp -= cows[i][0]*cows[i][1];
					time += cows[i][1] + cows[i][2];
				}
				else {
					time += Math.ceil((double) tmp/cows[i][0]);		// 올림해서 계산
					tmp = 0;
				}
			}
			// 출력
			System.out.println(time);
		}
	}
}