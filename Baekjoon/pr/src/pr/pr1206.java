// 백준 1206번
// 설문조사 중이고 n개 문항에 0~10점으로 답해야함.
// 각 문항의 평균 점수 소수점 셋째 자리에서 자른 값을 보고서 종이에 적고 사무실로 돌아왔다.
// 이제 설문조사 결과를 보고해야 하는데, 평균 점수만 알고 있기 때문에 설문조사에 참여한 사람의 수를 알 수 없다.
// 각 문항의 평균 점수가 주어진다. 이때 설문조사에 참여한 사람의 수를 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어지고
// 다음 줄부터 각 문항에 대한 평균점수가 주어짐.
// 무한루프 돌면서 설문자수 하나씩 올려가며 그 사람수에 대해 점수 평균합이 가능한지 검사.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr1206 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine().trim());
		int[] num = new int[n];
		for(int i=0; i<n; i++) {
			double input = Double.parseDouble(br.readLine());
			num[i] = (int) Math.round(input * 1000);
		}
		// 설문조사 참여자 수 구하기
		long output = 1;
		while(true) {
			boolean tmp = true;
			for(int i : num) {
				long min = (i * output + 999) / 1000;
				if(min*1000 >= (i+1)*output) {
					tmp = false;
					break;
				}
			}
			output++;
			// 출력
			if(tmp) {
				System.out.print(output-1);
				break;
			}
		}
	}
}