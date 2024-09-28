// 백준 3373번
// 문제에서 주어진 규칙에 따라 호텔방 배정하기
// 방법---------------------
// 첫 줄에 테스트 데이터의 개수 t를 입력 받고
// t줄에 걸쳐 h, w, n 을 입력 받음. (각각 호텔의 층 수, 각 층의 방 수, 몇 번째 손님인지)
// 방번호를 계산하고 출력 - NullPointer에러 주의!, 꼭대기층인 경우 주의!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String[] input = br.readLine().split(" ");
			int h = Integer.parseInt(input[0]);
			int w = Integer.parseInt(input[1]);
			int n = Integer.parseInt(input[2]);
			int sum = 1;
			// 방번호 계산
			String room = "";
			if(n%h==0)							// 앞번호
				room = h + "";
			else
				room = n%h +"";
			if (n%h==0) {						// 뒷번호
                sum += (n/h) - 1;
            } else {
                sum += n/h;
            }
            if (sum<10) {
                room += "0" + sum;
            } else {
                room += sum;
            }
			// 출력
			System.out.println(room);
		}
	}
}