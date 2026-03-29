// 백준 23028번
// 아리는 4학년 졸업 학점을 채워 졸업할 수 있는지 궁금해짐.
// 졸업하려면 총 130학점 이상 들어야 하고, 그 중 66학점 이상은 전공학점이어야 함.
// 아리는 현재 2021년 2학기까지 n학기를 마쳤음.
// 그리고 전공학점 a를 포함해 총 b학점을 이수하였음.
// 학교 홈피에 22년 1학기부터 26년 2학기까지 개설된느 전공과목, 비전공과목 수가 올라왔고
// 2022년 1학기부터는 한 학기에 전공 수업과 비전공 수업을 포함하여 최대 6과목을 수강할 수 있다는 공지가 올라왔음.
// 아리를 도와 아리가 전에 마쳤던 학기를 포함해 총 8학기 안에 졸업할 수 있는지 확인하는 문제.
// 방법---------------------
// 첫 줄에 n, a, b가 주어짐.
// 다음 줄부터 10개 줄에 걸쳐 22년 1학기부터 26년 2학기 까지
// 차례대로 학기에 개설되는 과목의 수가 주어지고, 한 줄에 한 학기의 전공과목 수 x랑 비전공 과목 수 y가 주어짐.
// 전공부터 무조건 다 듣고 남는 학점만큼 교양을 최대한 많이 듣도록 코드 짜고
// 졸업 가능한지 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr23028 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] notice = new int[10][2];
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			notice[i][0] = Integer.parseInt(st.nextToken()); 	// 공지된 전공 과목 수
			notice[i][1] = Integer.parseInt(st.nextToken()); 	// 공지된 교양 과목 수
		}
		// 졸업 가능한지 확인
		if(b>=130 && a>=66)										// 이미 졸업 조건 만족하면
			System.out.print("Nice");
		else {													// 졸업 조건 만족 못하면
			for(int i=0; i<8-n; i++) {
				a += notice[i][0] * 3;							// 전공 먼저 채우고
				b += notice[i][0] * 3;
				int tmp = 6 - notice[i][0];
				if(tmp < notice[i][1])							// 개설된 교양 수 보다 내가 들을 수 있는 개수가 적으면
					b += tmp * 3;
				else
					b += notice[i][1] * 3;
			}
			// 출력
			if(b>=130 && a>=66)
				System.out.print("Nice");
			else
				System.out.print("Nae ga wae");
		}
	}
}