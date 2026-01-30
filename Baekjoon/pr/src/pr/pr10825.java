// 백준 10825번
// 반 학생 n명의 이름과 국영수 점수가 주어지면
// 문제에 주어진 조건대로 성적을 정렬하는 문제.
// 자세한 조건은 문제 참조.
// 방법---------------------
// 첫 줄에 학생 수 n명을 입력 받음.
// 다음 줄부터 n줄에 걸쳐 이름, 국, 영, 수 점수를 한 줄에 입력 받음.
// 입력 받은 정보들 저장할 클래스 만들어서 학생마다 이름이랑 성적 저장하고
// 문주에서 주어진 조건대로 우선순위 정해서 학생들 성적 정렬하고
// 이름 좌르륵 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr10825 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		Student[] student = new Student[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kr = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			student[i] = new Student(name, kr, eng, math);
		}
		// 정렬
		Arrays.sort(student);
		// 출력
		for(Student i : student)
			sb.append(i.name).append("\n");
		System.out.print(sb.toString().trim());
	}

	// 학생 성적 저장 클래스
	public static class Student implements Comparable<Student> {
		String name;
		int kr;
		int eng;
		int math;

		Student(String name, int kr, int eng, int math) {
			this.name = name;
			this.kr = kr;
			this.eng = eng;
			this.math = math;
		}

		// 정렬 조건
		@Override
		public int compareTo(Student s) {
			// 국어 점수가 감소하는 순으로
			if(this.kr != s.kr)
				return s.kr - this.kr;
			// 국어가 같으면 영어 점수가 증가하는 순으로
			if(this.eng != s.eng)
				return this.eng - s.eng;
			// 국어 영어 같으면 수학 점수가 감소하는 순으로
			if(this.math != s.math)
				return s.math - this.math;
			// 다 같으면 이름 순으로
			return this.name.compareTo(s.name);
		}
	}
}