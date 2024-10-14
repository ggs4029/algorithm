// 백준 6159번
// 소 쌍이 의상에 들어갈 수 있는 경우(두 마리의 길이의 합이 의상 길이보다 작거나 같은 경우)
// 농부가 선택할 수 있는 소 쌍의 개수를 출력하는 문제
// 방법---------------------
// 첫 줄에 소의 마리수 n과 의상의 길이 s를 입력 받음
// 다음 줄부터 n줄에 걸쳐 소의 길이를 입력 받음
// 이중for문을 돌며 두마리를 선택하고 가능한 경우의 수를 구해 출력
// 중복 있게 순회한것이므로 출력할때는 output/2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6159 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
		int[] cow = new int[n];
		for(int i=0; i<n; i++)
			cow[i] = Integer.parseInt(br.readLine());
		// 소 쌍 선택하기
		int output = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i!=j) {
					if(cow[i]+cow[j]<=s) {				// 소길이합<=옷의길이면
						output++;
					}
				}
			}
		}
		// 출력
		System.out.print(output/2);
	}
}