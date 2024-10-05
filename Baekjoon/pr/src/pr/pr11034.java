// 백준 11034번
// 캥거루 세마리가 수직선 위에 있고, 서로 다른 좌표 위에 있음.
// 한번 움직일 때 바깥쪽의 두 캥거루 중 한 마리가 다른 두 캥거루 사이의 정수 좌표로 점프할 때
// 캥거루는 최대 몇번 움직일 수 있는지 출력하는 문제
// 한 좌표 위에 캥거루 여러마리 불가능
// 방법---------------------
// 첫 줄에 캥거루 세마리의 좌표를 입력 받음.
// 캥거루들 사이의 거리를 구한 뒤 (더 긴 거리 - 1)을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11034 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		while(true) {
			String s = br.readLine();
			if(s == null || s.isEmpty())
				break;
			String[] input = s.split(" ");
			int[] kang = new int[3];
			for(int i=0; i<3; i++)
				kang[i] = Integer.parseInt(input[i]);
			// 출력
			if(kang[2]-kang[1] > kang[1]-kang[0])
				System.out.println(kang[2]-kang[1]-1);
			else
				System.out.println(kang[1]-kang[0]-1);
		}
	}
}