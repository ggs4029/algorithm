// 백준 9237번
// 나무 묘목 n개를 심을거임.
// 각 묘목이 자라는데 걸리는 시간은 정확히 알고 있고, 묘목 하나를 심는데는 1일이 걸림.
// 마지막 나무까지 다 자라면 이장님을 초대하려함.
// 나무를 심는 순서를 신중하게 골라 이장님을 최대한 빨리 초대하려고 함.
// 이장님을 초대할 수 있는 최솟값을 구하는 문제.
// 방법---------------------
// 첫 줄에 묘목의 수 n을 입력 받고
// 다음 줄에 각 나무들이 자라는데 며칠이 걸리는지를 한 줄에 입력 받는다.
// 나무 심는 순서를 오래걸리는 애들부터 심어서 이장님 오는 최솟값을 구한다.
// 내림차순 정렬하고 순회하면서 최솟값 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class pr9237 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 묘목 성장일 입력값 저장
		Integer[] num = new Integer[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(num, Collections.reverseOrder());			// 내림차순으로
		// 이장님 오는날 최솟값 구하기
		int output = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			output = Math.max(output, num[i] + i + 1);
		// 출력
		System.out.print(output + 1);
	}
}