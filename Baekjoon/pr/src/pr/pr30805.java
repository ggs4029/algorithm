// 백준 30805번
// 수열a와 수열b가 공통으로 갖는 부분 수열들 중 사전 순으로 가장 나중인 것을 구하는 문제.
// 부분 수열에 대한 정의와 사전 순에 대한 자세한 내용은 문제 참조.
// 방법---------------------
// 첫 줄에 수열a의 길이 n이 주어지고 다음 줄에 n개의 정수들이 주어짐.
// 셋째 줄에 수열b의 길이 m이 주어지고 다음 줄에 m개의 정수들이 주어짐.
// 두 수열의 공통된 최댓값을 순서대로 읽어가며 계속 찾고 배열리스트에 저장.
// 배열리스트 차례대로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pr30805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			b[i] = Integer.parseInt(st.nextToken());
		// 공통 부분 수열 중 사전 순으로 가장 나중인 수열 구하기
		ArrayList<Integer> num = new ArrayList<>();
		int tmp = 0; int tmp2 = 0;
		while(tmp<=n && tmp2<=m) {
			int max = 0;									// 두 수열에 공통적으로 있는 최댓값
			for(int i=tmp; i<n; i++) {
				for(int j=tmp2; j<m; j++) {
					if(a[i]==b[j])							// 같은 값 있으면
						max = Math.max(max, a[i]);			// 비교해서 최댓값 업데이트
				}
			}
			if(max!=0) {
				num.add(max);								// 최댓값 넣고
				while(a[tmp]!=max)							// 인덱스 이동
					tmp++;
				while(b[tmp2]!=max)							// 인덱스 이동
					tmp2++;
				tmp++; tmp2++;
			}
			else											// 최댓값 없으면 종료
				break;
		}
		// 출력
		sb.append(num.size()).append("\n");
		for(int i=0; i<num.size(); i++)
			sb.append(num.get(i)).append(" ");
		System.out.print(sb.toString().trim());
	}
}