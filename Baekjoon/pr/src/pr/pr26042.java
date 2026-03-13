// 백준 26042번
// 여러 명의 학생이 학교 식당에 밥먹으려고 가는 중임.
// 학생들은 식당 입구에 도착한 순서대로 줄을 서서 대기하고 1인분이 준비되면 순서대로 받아감.
// 학생이 학교 식당에 도착하고 식사가 준비되는 n개의 정보가 저장된 a가 주어질거임.
// a에 저장된 n개의 정보가 두 가지 유형으로 나눠질 때, (
// 식당 입구에 줄을 서서 대기하는 학생 수가 최대가 되었던 순간의 학생 수와
// 이때 식당 입구의 맨 뒤에 대기 중인 학생의 번호를 순서대로 출력해야하는 문제.
// 대기하는 학생 수가 최대인 경우가 여러 번이면 맨 뒤에 줄 서 있는 학생의 번호가 가장 작은 경우를 출력하기.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 그 다음 줄부터 n줄에 걸쳐 한 줄씩 정보들이 주어짐.
// 맨 뒤 학생 번호 읽어야하니까 큐를 더블 엔드 큐로 만들어서 구현하기.
// 받은 정보대로 유형1, 2 나누어서 처리하고
// 그 때마다 기다리는 사람 max치 갱신하는지, 맨 뒷사람 번호도 같이 체크하고 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class pr26042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();
		int max = 0;								// 최대 대기자 수
		int student = 0;							// 끝 학생 번호
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			// 받은 정보 읽기
			// 유형 1 - 학생 한명이 식당 와서 맨 뒤에 줄을 섬
			if(a == 1) {
				int num = Integer.parseInt(st.nextToken());
				q.offerLast(num);
			}
			// 유형 2 - 밥 받아서 식사 시작
			else {
				if(!q.isEmpty())
					q.pollFirst();
			}
			int wait = q.size();					// 지금 대기 중인 사람 수
			if(wait > 0) {
				int tmp = q.peekLast();				// 지금 맨 뒤에 있는 애
				if(wait > max) {					// 최대치 갱신하면
					max = wait;
					student = tmp;
				}
				else if(wait == max) {				// 최대치 같으면 맨 뒤 번호 비교해서 갱신
					if(tmp < student)
						student = tmp;
				}
			}
		}
		// 출력
		System.out.println(max + " " + student);
	}
}