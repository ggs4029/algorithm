// 백준 10814번
// 나이순 정렬
// 나이순으로, 나이가 같으면 가입순으로 정렬하기
// 방법------------------
// 멤버 클래스를 만들어 입력 받을 회원수와
// 그만큼의 나이와 이름을 입력 받고
// 나이가 같은 경우 가입순으로 정렬하기위해
// 람다식을 이용한 Arrays.sort()를 이용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class pr10814 {
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

		// 정렬
		Arrays.sort(member, new Comparator<Member>(){
			@Override
			public int compare(Member mem1, Member mem2) {
				return mem1.age - mem2.age;
			}
		});

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
}