// 백준 5635번
// 학생들의 생일이 주어지면
// 가장 나이 적은 학생이랑 많은 학생 구하기.
// 방법---------------------
// 첫 줄에 학생 수 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 각 학생의 이름과 생일이 "이름 dd mm yyyy" 와 같이 주어짐.
// 연 -> 월 -> 일 순으로 정렬해가며 비교해 젊은이와 늙은이를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr5635 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[][] student = new String[n][4];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			student[i][0] = st.nextToken();
			student[i][1] = st.nextToken();
			student[i][2] = st.nextToken();
			student[i][3] = st.nextToken();
		}
		// 정렬
		Arrays.sort(student, (x, y) -> {
			if(x[3].equals(y[3])) {												// 연
				if(x[2].equals(y[2]))											// 월
					return Integer.parseInt(x[1]) - Integer.parseInt(y[1]);		// 일
				return Integer.parseInt(x[2]) - Integer.parseInt(y[2]);
			}
			return Integer.parseInt(x[3]) - Integer.parseInt(y[3]);
		});
		// 출력
		System.out.println(student[n-1][0]);
		System.out.print(student[0][0]);
	}
}