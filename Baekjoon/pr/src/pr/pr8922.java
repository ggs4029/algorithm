// 백준 8922번
// 두찌 수열은 정수 n-튜플로 이루어진 수열임.
// 두찌 수열은 항상 0으로 이루어진 튜플이 나오거나 루프를 만나게 됨.
// n튜플이 주어지면 이 수열이 0으로 이루어진 튜플은 만드는지
// 루프를 만드는지 맞추는 문제.
// 두찌 수열이 무엇인지 자세한 내용은 문제 참조.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스의 첫 줄엔 튜플 크기 n이 주어지고
// 그 다음 줄엔 n-튜플이 주어짐.
// 입력 받은 테케들로 반복문 돌리면서
// 튜플 한번씩 돌릴 때마다 원소들 싹 다 0 됐는지 체크해주고
// 되었으면 zero, 아니면 다음 튜플 만들어주고 다시 돌리고
// 반복해주고 끝까지 zero 아니면 loop 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr8922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			int[] num = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				num[j] = Integer.parseInt(st.nextToken());
			// 두찌 수열 돌리기
			boolean tmp = false;
			for(int j=0; j<=1000; j++) {
				if(check(num)) {							// 다 0인지 체크
					tmp = true;
					break;
				}
				int[] num2 = new int[n];					// 다음 튜플
				for(int k=0; k<n; k++) {
					if(k == n-1)
						num2[k] = Math.abs(num[k] - num[0]);
					else
						num2[k] = Math.abs(num[k] - num[(k+1)]);
				}
				num = num2;
			}
			if(tmp)
				sb.append("ZERO").append("\n");
			else
				sb.append("LOOP").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 튜플이 다 0인지 체크하는 메소드
	public static boolean check(int[] num) {
		for(int i=0; i<num.length; i++) {
			if(num[i] != 0)
				return false;
		}
		return true;
	}
}