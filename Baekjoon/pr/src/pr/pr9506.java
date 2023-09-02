// 백준 9506번
// 완전수 구하기
// n을 입력 받고 완전수라면
// 약수들의 합을 예제 출력처럼 나타내고
// 아니라면 n is NOT perfect. 를 출력
// 방법-----------------
// 입력 받은 n의 n을 제외한 약수들을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9506 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			// 입력, 입력의 마지막은 -1
			int n = Integer.parseInt(br.readLine());
			if(n==-1)
				break;
			// 변수 설정
			String output = n+" = ";
			int sum = 0;
			// 약수 구하기
			for(int x=1; x<n; x++) {
				if(n%x==0) { // 약수면
					sum+=x;
					if(x==1)
						output = output + 1;
					else
						output = output + " + "+ x ;
				}
			}
			if(sum==n) { // 완전수인 경우
				System.out.println(output);
			}
			else {
				System.out.println(n+" is NOT perfect.");
			}
		}
		br.close();
	}
}