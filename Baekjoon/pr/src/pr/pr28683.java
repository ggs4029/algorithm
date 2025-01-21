// 백준 28683번
// 적어도 한 변의 길이가 루트n인 서로 다른 모양의 직각삼각형 중
// 적어도 두 변의 길이가 정수인 직각삼각형은 몇 개인지 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 루트n이 정수가 아니면 다른 두 변이 무조건 정수여야함.
// 루트n이 정수면 다른 한 변이 정수가 아니어도 되니까 무한이 있음.
// a^2 + n = b^2 에서 n = (b-a)(b+a)임을 이용해 b-a와 b+a가 둘 다 짝수거나 홀수인지 확인.
// n에서 어떤 제곱수를 뺀게 제곱수인지도 확인.
// 구한 직각삼각형 개수 출력.
// 오답노트------------------
// n에서 어떤 제곱수를 뺀게 제곱수인지도 확인하는 부분에서
// a^2 + b^2 = n 인 상황에서 i가 n/2보다 크면 a^2 + b^2이 n보다 커지므로
// for문 조건 i*i<=n 이 아니라 i*i<=n/2 임에 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28683 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		// 직각 삼각형 개수 구하기
		long m = (long) Math.sqrt(n);
		if(m*m == n) {														// n이 1이면
			System.out.print(-1);											// 무한이 있음
			return;
		}
		long output = 0;
		for(long i=1; i<=m; i++) {
			if(n%i == 0) {
				long tmp = n/i;												// n의 두 약수인 i와 tmp가
				if((i%2 == 0 && tmp%2 == 0) || (i%2 != 0 && tmp%2 != 0))	// 둘 다 짝수거나 둘 다 홀수거나
					output++;
			}
		}
		for(long i=1; i*i<=n/2; i++) {
			long tmp = n - i * i;
			long tmp2 = (long) Math.sqrt(tmp);
			if(tmp2*tmp2 == tmp)											// n에서 어떤 제곱수 뺀게 제곱수면
				output++;
		}
		// 출력
		System.out.print(output);
	}
}