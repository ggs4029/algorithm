// 백준 14003번
// 수열 a가 주어지면 가장 긴 증가하는 부분 수열의 길이와 그 수열을 구하는 문제.
// 수열의 크기와 수열 a를 이루고 있는 ai의 범위가 매우 커짐.
// 방법---------------------
// 첫 줄에 수열 a의 크기 n이 주어짐.
// 다음 줄에 수열 a를 이루고 있는 요소들이 한 줄에 주어짐.
// 이분 탐색을 하면서 가장 긴 증가하는 부분 수열에서의 위치를 기록해야함.
// 탐색을 마치면 기록한 위치들을 통해서 배열을 뒤에서 역추적해가며
// 가장 긴 증가하는 부분 수열을 이루는 원소들을 찾아
// 스택에 넣고 거꾸로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr14003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] input = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			input[i] = Long.parseLong(st.nextToken());
		// 이분 탐색
		long[] num = new long[n];
		num[0] = input[0];
		long[] record = new long[n];							// 가장 긴 증가하는 부분 수열 위치 기록용
		record[0] = 0;
		int len = 1;
		for(int i=1; i<n; i++) {
			long tmp = input[i];
			if(num[len-1] < tmp) {								// 지금 값이 num의 마지막 값보다 크면
				record[i] = len;								// 지금 값의 가장 긴 증가하는 부분 수열의 위치 기록하고
				num[len] = tmp;									// 끝에 추가
				len++;
			}
			else {												// 이분 탐색으로 적절한 위치에 넣기
				int min = 0;
				int max = len;
				while(min < max) {
					int mid = (min + max) / 2;
					if(num[mid] < tmp)
						min = mid + 1;
					else
						max = mid;
				}
				num[min] = tmp;
				record[i] = min; 								// 가장 긴 증가하는 부분 수열의 위치 기록
			}
		}
		// 역추적으로 가장 긴 증가하는 부분 수열 궇기
		Stack<Long> stack = new Stack<>();
		int tmp2 = len - 1;
		for(int i=n-1; i>=0; i--) {
			if(record[i] == tmp2) {								// 찾는 원소와 위치가 일치하면
				stack.push(input[i]);
				tmp2--;
			}
		}
		// 출력
		while(!stack.isEmpty())
			sb.append(stack.pop()).append(" ");
		System.out.println(len);
		System.out.print(sb.toString().trim());
	}
}