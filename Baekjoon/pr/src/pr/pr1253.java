// 백준 1253번
// n개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 "좋다" 라고함.
// n개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 구해 출력하는 문제.
// 방법---------------------
// 첫 줄에 수의 개수 n이 주어짐.
// 다음 줄에 n개의 수가 한 줄에 주어짐.
// 입력 받은 수들 배열에 넣고 정렬함.
// 이분 탐색 돌리면서 양 끝으로 포인터 잡고
// 둘이 더해 num[i]값이랑 같은지 비교하고
// 적절하게 포인터 위치 옮겨가며 다시 반복.
// 좋은 수의 개수를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 이분 탐색
		int good = 0;
		for(int i=0; i<n; i++) {
			int min = 0;
			int max = n - 1;
			while(min < max) {
				if(min==i || max==i) {							// 본인이면 패스하고 포인터 옮기기
					if(min == i)
						min++;
					else
						max--;
				}
				else {
					int tmp = num[min] + num[max];
					if(tmp == num[i]) {							// 더해서 똑같으면
						good++;									// 좋은 수
						break;
					}
					else if(tmp < num[i])						// 더해서 작으면
						min++;									// 왼쪽 포인터 오른쪽으로
					else										// 더해서 크면
						max--;									// 오른쪽 포인터 온쪽으로
				}
			}
		}
		// 출력
		System.out.print(good);
	}
}