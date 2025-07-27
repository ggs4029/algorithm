// 백준 1786번
// 문자열 t에서 패턴 문자열 p가 몇 번 등장하는지와 그 시작 위치들을 출력하는 문제.
// kmp 알고리즘 사용하여 구현하기.
// 방법---------------------
// 첫 줄에 문자열 t와 다음 줄에 문자열 p를 입력 받음.
// kmp 알고리즘 메소드와 kmp 알고리즘 검색 중
// 불일치시 사용할 부분일치 테이블 메소드 두개 구현.
// 문제에서 주어진대로 문자열 비교해가며 불일치하면 테이블 참고해 되돌리고
// 일치하면 진행하는 구조로 작성해 시간 복잡도 O(t + p) 지키기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1786 {
	public static String t;
	public static String p;
	public static int[] table;
	public static int output = 0;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		t = br.readLine();
		p = br.readLine();
		table = new int[p.length()];
		// 메소드 호출
		kmp();
		// 출력
		System.out.println(output);
		System.out.print(sb.toString().trim());
	}

	// KMP 알고리즘 메소드
	private static void kmp() {
		// 부분일치 테이블 만들기
		makeTable();
		int k = 0;									// 최대 일치 길이
		for(int i=0; i<t.length(); i++) {
			while(k>0 && t.charAt(i)!=p.charAt(k))	// 불일치하면
				k = table[k-1];						// 되돌아가기
			if(t.charAt(i)==p.charAt(k)) {			// 일치하면
				if(k == p.length()-1) {				// 패턴 전체가 일치하면
					output++;
					sb.append(i-k+1).append("\n");
					k = table[k];
				}
				else								// 패턴 전체 일치는 아니면
					k++;
			}
		}
	}

	// 전처리(부분일치 테이블) 메소드
	private static void makeTable() {
		int k = 0;									// 최대 일치 길이
		for(int i=1; i<p.length(); i++) {
			while(k>0 && p.charAt(i)!=p.charAt(k))	// 불일치하면
				k = table[k-1];						// 되돌아가기
			if(p.charAt(i) == p.charAt(k)) {		// 일치하면
				k++;
				table[i]=k;
			}
		}
	}
}