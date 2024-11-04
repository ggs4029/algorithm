// 백준 28288번
// 가장 많은 관심 있는 사람들이 참석할 수 있도록 이벤트를 어느 날에 일정을 잡아야 하는지를 결정하는 문제.
// 방법---------------------
// 첫째 줄에 이벤트에 참석하려는 사람 수 n이 주어짐.
// 다음 n줄에 걸쳐 각 사람의 참석 가능성을 나타내는 문자열이 주어짐.
// 이 문자열은 각각의 날짜에 대해 참석 가능성을 나타내고 1, 2, 3, 4, 5일 순서로 구성되어 있음.
// Y = 참석 가능  . = 참석할 수 없음
// 입력 받은 문자열 for문으로 해체해서 세고 가장 많이 겹치는 날 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28288 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] attend = new String[n];
		for(int i=0; i<n; i++)
			attend[i] = br.readLine();
		// 날짜마다 카운트
		int[] sum = new int[5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<n; j++) {
				if(attend[j].charAt(i)=='Y')
					sum[i]++;
			}
		}
		// 일정 잡기
		int tmp = 0;								// 최댓값 저장할 변수
		StringBuilder sb = new StringBuilder();
		for(int i : sum) {
			if(i>tmp)
				tmp = i;
		}
		for(int i=0; i<5; i++) {
			if(sum[i]==tmp) {
				if(sb.length()>0)
					sb.append(",");
				sb.append(i+1);
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
}