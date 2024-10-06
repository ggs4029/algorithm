// 백준 26651번
// 그램팬인 부분문자열의 개수가 x개인 문자열 s를 찾는 문제
// 방법---------------------
// 첫 줄에 x를 입력 받음.
// x의 수만큼 앞에 A를 붙이고 그 다음 A~Z 출력
// x = 0인 경우 아무거나 출력
// 주의! - s는 길이가 1이상 10만이하
// x가 10^9인 경우 n=31622, m=31623

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		long x = Long.parseLong(br.readLine());
		// 0일때 출력
		if(x==0) {
			System.out.print("GAEJOTDEN");
			return;
		}
		// n*m <= x인 n, m의 최대값 구하기
		long n, m;
		for(n=0; n*n<=x; n++);
		n-=1;
		for(m=n; n*m<=x; m++);
		m-=1;
        // n*m개 만큼의 팬램그 생성
        for(long i=0; i<n; i++)
        	sb.append('A');
        sb.append("BCDEFGHIJKLMNOPQRSTUVWXY");
        for(long i=0; i<m; i++)
        	sb.append('Z');
        // x-n*m개 만큼의 팬램그 생성
        for(long i=0; i<x-n*m; i++)
        	sb.append('A');
        sb.append("BCDEFGHIJKLMNOPQRSTUVWXYZ");
        // 출력
        System.out.print(sb.toString());
	}
}