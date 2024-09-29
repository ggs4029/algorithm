// 백준 30802번
// 티셔츠와 펜을 몇개 시켜야하는지 구하는 문제
// 티셔츠는 t장씩 최소 몇 묶음 주문해야하는지,
// 펜은 p자루씩 몇 묶음 주문하고 낱개로는 몇개 주문하는지 출력(펜은 남아서는 안된다.)
// 방법---------------------
// 첫 줄에 참가자의 수 n을 입력 받고
// 둘째 줄에 티셔츠 사이즈별 신청자의 수 s,m,l,xl,xxl,xxxl을 한줄에 입력 받음
// 셋째 줄에 티셔츠와 펜의 묶음 수를 의미하는 t, p를 입력 받음
// for문을 돌며 문제의 조건에 맞게 티셔츠를 최소 몇 묶음 주문해야하는지 계산+출력.
// 단순 계산으로 펜을 몇 묶음 주문해야하는지, 낱개로는 몇개 주문해야하는지 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30802 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Integer.parseInt(br.readLine());
		long[] size = new long[6];
		long t,p;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<size.length; i++) {
			size[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		t = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		// 티셔츠 계산
		long output = 0;
		for(int i=0; i<size.length; i++) {
			if(size[i]==0)
				continue;
			else if(size[i]%t>0)
				output = output + size[i]/t+1;
			else
				output += size[i]/t;
		}
		// 티셔츠 출력 + 펜 계산 and 출력
		System.out.println(output);
		System.out.print(n/p + " " + n%p);
	}
}