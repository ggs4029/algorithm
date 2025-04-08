// 백준 4673번
// 셀프 넘버 구하기
// 10000이하의 숫자중 셀프 넘버를 한줄에 하나씩 증가하는 순서로 출력한다.
// 방법----------------
// 생성자가 체크 메소드 구현해 1부터 10000까지 루프 돌면서
// 생성자 있는 수만 체크해주고 false인 셀프 넘버들만 출력.

import java.io.IOException;

public class pr4673 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		// 셀프 넘버 구하기
		boolean[] num = new boolean[10000+1];
		for(int i=1; i<=10000; i++) {
			int tmp = check(i);
			num[tmp] = true;
		}
		for(int i=1; i<=10000; i++) {
			if(!num[i])								// 셀프 넘버면 추가
				sb.append(i).append("\n");
		}
		System.out.print(sb.toString().trim());
	}

	// 생성자 체크 메소드
	public static int check(int i) {
		int sum = i;
		while(i != 0) {
			sum += i % 10;
			i = i / 10;
		}
		if(sum <= 10000)
			return sum;
		return 0;
	}
}