// 백준 1476번
// 날짜 계산
// 방법---------------
// 원하는 e,s,m을 입력 받고
// sum과 x,y,z를 만들고 이를 이용해
// 원하는 값이 나올때까지 while문을 돌린다.
// while문 안에서 e는 15가 넘어가면 1로 만들고
// s는 28, m은 19를 넘어가면 1로 만든다.
// x,y,z가 각각 e,s,m이 될때까지 while문을 돌리고
// sum 값을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int e = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[2]);
		// 원하는 값 찾기
		long sum =1;
		int x=1;
		int y=1;
		int z=1;
		while(x!=e||y!=s||z!=m) {
			++sum;
			x++;
			y++;
			z++;
			if(x==16)
				x=1;
			if(y==29)
				y=1;
			if(z==20)
				z=1;
		}
		// 출력
		System.out.print(sum);
	}
}