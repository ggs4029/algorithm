// 백준 17478번
// n이 주어지면 재귀를 n번 반복하는 챗봇의 응답을 출력하는 문제.
// 방법---------------------
// 첫 줄에 n을 입력 받고
// 출력 예시에 맞게 재귀출력 메소드 구현한 뒤 답 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17478 {
	public static String tmp ="";
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		recursion(n);
		System.out.print(sb.toString().trim());
	}

	// 재귀출력 메소드
	public static void recursion(int n){
		String now = tmp;
		if(n == 0) {
			sb.append(now).append("\"재귀함수가 뭔가요?\"").append("\n");
			sb.append(now).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
			sb.append(now).append("라고 답변하였지.").append("\n");
			return;
		}
		sb.append(now).append("\"재귀함수가 뭔가요?\"").append("\n");
		sb.append(now).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
		sb.append(now).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
		sb.append(now).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
		tmp += "____";
		// 호출
		recursion(n-1);
		sb.append(now).append("라고 답변하였지.").append("\n");
	}
}