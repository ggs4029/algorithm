// 백준 20921번
// 한 번에 여러 개의 그렇고 그런 사이를 만들려 한다.
// 하지만 너무 많이 만들면 미풍양속에 저해되고, 너무 적게 만들면 솔로들이 많아지기 때문에,
// 정확히 k개의 그렇고 그런 사이를 만들려 한다.
// n명의 친구들을 k개의 그렇고 그런 사이로 만들어 출력하는 문제.
// 그렇고 그런 사이를 만드는 방법은 문제 참조.
// 방법---------------------
// 첫 줄에 정수 n, k가 주어진다.
// 큰 수부터 놓아가며 k개의 그렇고 그런 사이를 만들고
// 큰 수 먼저 출력 + 나머지 숫자들은 오름차순 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class pr20921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 그렇고 그런 사이 만들기
		int sum = 0;
		ArrayList<Integer> output = new ArrayList<>();
		ArrayList<Integer> output2 = new ArrayList<>();
		while(n>0) {
			if(sum+n-1<=k) {							// k개의 그렇고 그런 사이 만들기
				sum += n - 1;
				output.add(n);
			}
			else										// k개 이미 넘겼으면 output2로
				output2.add(n);
			n--;
		}
		// 정렬
		Collections.sort(output2);
		// 출력
		for(int i : output)
			sb.append(i).append(" ");
		for(int i : output2)
			sb.append(i).append(" ");
		System.out.print(sb.toString().trim());
	}
}