// 백준 1002번
// 터렛
// 방법------------
// 원끼리 접하는 접점의 개수를 구하는 문제이다.
// 두 원의 원점이 같고 반지름까지 같다면 접점은 무한대이고
// 반지름이 같지 않다면 접점은 없다.
// 두 원의 원점이 다르다면,
// 접점이 없는 경우는 두 원점사이의 거리가 r1+r2보다 클때와
// 원안에 다른원이 있어 접점이 없는 경우이다.
// 접점이 하나인 경우는 두 원점사이의 거리와 r1+r2가 같은 경우(외접)와
// 두 원점 사이의 거리와 r1-r2가 같은 경우(내접)이다.
// 그 외에는 접점이 두개인 경우이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);
			int r1 = Integer.parseInt(input[2]);
			int x2 = Integer.parseInt(input[3]);
			int y2 = Integer.parseInt(input[4]);
			int r2 = Integer.parseInt(input[5]);
			int count = 0;
			// 좌표 계산
			// 있을 수 있는 위치가 무한대거나 0인 경우
			if ((x1 == x2) && (y1 == y2)) {
				if (r1 == r2) // 반지름까지 같은 경우
					System.out.println(-1);
				else
					System.out.println(0);
			}
			// 두 원의 원점 사이의 거리가 r1+r2보다 큰 경우
			else if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) > (r1 + r2) * (r1 + r2)) {
				System.out.println(0);
			}
			// 두 원의 원점 사이의 거리가 r1-r2보다 큰 경우
			else if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < (r1 - r2) * (r1 - r2)) {
				System.out.println(0);
			}
			// 원끼리 한 점에 접하는 경우(외접)
			else if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (r1 + r2) * (r1 + r2)) {
				System.out.println(1);
			}
			// 원끼리 한 점에 접하는 경우(내접)
			else if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (r1 - r2) * (r1 - r2)) {
				System.out.println(1);
			}
			// 원끼리 두 점에 접하는 경우
			else
				System.out.println(2);
		}
	}
}