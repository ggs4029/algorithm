// 백준 10814번
// 나이순 정렬
// 나이순으로, 나이가 같으면 가입순으로 정렬하기
// 방법------------------
// 멤버 클래스를 만들어 입력 받을 회원수와
// 그만큼의 나이와 이름을 입력 받고
// 나이가 같은 경우 가입순으로 정렬하기위해
// 안정 정렬중 병합 정렬을 이용한다.
// = 시간 초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10814_merge {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		Member[] member = new Member[n];
		for(int x=0; x<n; x++) {
			String[] input = br.readLine().split(" ");
			int age = Integer.parseInt(input[0]);
			String name = input[1];
			member[x] = new Member(age, name);
		}

		// 병합 정렬
		mergeSort(member, 0, member.length-1);

		// 출력
		for(int x=0; x<n; x++) {
			System.out.println(member[x].age+" "+member[x].name);
		}
	}

	// 멤버 클래스
	public static class Member{
		int age;		// 나이
		String name;	// 이름

		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	// 병합 정렬
	public static void mergeSort(Member[] mem, int p, int r) {
		if (p < r) {
			int q = (p+r) / 2;		// q는 p와 r의 중간 지점
			mergeSort(mem,p,q);		// 전반부 정렬
			mergeSort(mem,q+1,r);	// 후반부 정렬
			merge(mem, p, q, r);	// 병합
		}
	}

	// 병합
	public static void merge(Member[] mem, int p, int q, int r) {
		Member[] tmp = new Member[mem.length];	// 정렬된 원소를 임시저장할 Memeber배열
		int i = p;
		int j = q+1;
		int t = 0;
		// 나이끼리 비교
		while (i<=q && j<=r) {
			if(mem[i].age <= mem[j].age)
				tmp[t++] = mem[i++];
			else
				tmp[t++] = mem[j++];
		}
		// 왼쪽 배열만 남은경우
		while (i<=q)
			tmp[t++] = mem[i++];
		// 오른쪽 배열만 남은경우
		while (j<=r)
			tmp[t++] = mem[j++];
		// 결과 저장
		t=0;
		for (int k=p; k<=r; k++) {
			mem[k] = tmp[t++];
		}
	}
}