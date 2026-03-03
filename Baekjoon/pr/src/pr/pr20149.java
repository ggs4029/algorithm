// 백준 20149번
// 2차원 좌표 평면 위의 두 선분 l1, l2가 주어지면
// 두 선분이 교차하는지 구하고, 교차한다면 교차하는 점의 x, y좌표 출력하는 문제.
// 방법---------------------
// 첫 줄에 l1의 양 끝 점 x1, y1 x2, y2가 한 줄에 주어짐.
// 다음 줄에 l2의 양 끝 점 x3, y3 x4, y4가 한 줄에 주어짐.
// 입력 받은 점들 포인트 클래스 구현해서 저장하고
// ccw 돌려서 선분 교차하는지 확인하고 출력.
// ccw끼리 곱하는 과정에서 오버플로 막기위해
// ccw메소드가 부호만 리턴하도록 구현.
// 교점 좌표 구하는 공식을 사용해 교점 구해 출력.
// 오답노트1-----------------
// if문에서 단순히 tmp1==0 && tmp2==0 면 무조건 네 점이 일직선일거라고 생각했는데
// 예제 입력 8번 처럼 들어오면 선분 두개가 일직선이 아니고 점 하나에서만 만나도
// 조건문에 걸려서 추가로 조건 검사를 해야함.
// 선분들 기울기까지 구해서 그거 같은지 추가로 검사하는 코드 추가.
// 교점 좌표 구하는 공식 중에서 분모 부분만 떼오면됨.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr20149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Point p3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p4 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		// 선분 교차하는지 확인
		long tmp1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		long tmp2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		if(tmp1<=0 && tmp2<=0) {												// 두 선분이 만날 수 있으면
			double den = (double)(p1.x - p2.x) * (p3.y - p4.y)					// 분모
					- (p1.y - p2.y) * (p3.x - p4.x);
			if(tmp1==0 && tmp2==0 && den==0) {									// 네 점을 하나의 선분으로 이을수 있는지
				if(Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) &&				// 네 점을 하나의 선분으로 이을수 있고 선분 교차
						Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) &&
						Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) &&
						Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y)) {
					sb.append(1).append("\n");
					// 한 점만 교차하면 교점 좌표 구하기
					Point min1, max1, min2, max2;
					if(p1.x<p2.x || (p1.x==p2.x && p1.y<p2.y)) {
						min1 = p1;
						max1 = p2;
					}
					else{
						min1 = p2;
						max1 = p1;
					}
					if(p3.x<p4.x || (p3.x==p4.x && p3.y<p4.y)) {
						min2 = p3;
						max2 = p4;
					}
					else {
						min2 = p4;
						max2 = p3;
					}
					if(max1.x==min2.x && max1.y==min2.y)						// 첫번째 선분의 오른쪽 + 두번째 선분의 왼쪽
						sb.append(max1.x + " " + max1.y);
					else if(max2.x==min1.x && max2.y==min1.y)					// 첫번째 선분의 왼쪽 + 둰번째 선분의 오른쪽
						sb.append(max2.x + " " + max2.y);
				}
				else															// 네 점을 하나의 선분으로 이을수 있지만 선분 교차 x
					sb.append(0);
			}
			else {																// 네 점 하나의 선분으로 안이어짐
				sb.append(1).append("\n");
				// 교점 좌표 공식을 이용해 교점 좌표 구하기
				double px = ((double)(p1.x * p2.y - p1.y * p2.x) * (p3.x - p4.x)
						- (p1.x - p2.x) * (p3.x * p4.y - p3.y * p4.x)) / den;
				double py = ((double)(p1.x * p2.y - p1.y * p2.x) * (p3.y - p4.y)
						- (p1.y - p2.y) * (p3.x * p4.y - p3.y * p4.x)) / den;
				sb.append(px + " " + py);
			}
		}
		else																	// 두 선분이 못 만남
			sb.append(0);
		// 출력
		System.out.print(sb.toString().trim());
	}

	// ccw 메소드
	public static long ccw(Point a, Point b, Point c) {
		// 반시계 방향 = 양수
		// 일직선 = 0
		// 시계 방향 = 음수
		long output = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		// 부호만 리턴
		if(output > 0)
			return 1;
		if(output < 0)
			return -1;
		return 0;
	}

	// Point 클래스
	public static class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}