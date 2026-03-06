// 백준 27718번
// n개의 선분이 주어지면
// 중복을 허용하여 두 개를 고르는 모든 경우에 대해
// 두 선분이 다음 중 어떤 관계인지 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 그 다음 줄부터 한 줄에 한 선분씩 끝점 좌표 두개가 주어짐.
// 포인트 클래스로 좌표 관리.
// 포인트 클래스 두개 합친거 라인 클래스로 만들어서 선분 관리.
// ccw 돌려서 선분 교차하는지 확인하고 알맞은 관계에 해당하는 숫자 출력.
// ccw끼리 곱하는 과정에서 오버플로 막기위해
// ccw메소드가 부호만 리턴하도록 구현함.
// 오답노트1-----------------
// 선분끼리 비교할때 자기 자신인지 구별하기 위해서
// .equals() 메소드를 썼는데
// Point클래스 내에서 오버라이딩을 안해서 뭘 비교하든 false만 나오고 있었음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr27718 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		Line[] line = new Line[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			line[i] = new Line(p1, p2);
		}
		// 두 선분 관계 구하기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Line l1 = line[i];
				Line l2 = line[j];
				int output = 0;
				// 자기 자신이면
				if((l1.p1.equals(l2.p1) && l1.p2.equals(l2.p2)) || (l1.p1.equals(l2.p2) && l1.p2.equals(l2.p1)))
					output = 3;
				// 자기 자신 아니면 선분 교차 확인
				else {
					Point p1 = l1.p1;
					Point p2 = l1.p2;
					Point p3 = l2.p1;
					Point p4 = l2.p2;
					long tmp1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
					long tmp2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
					if(tmp1<=0 && tmp2<=0) {											// 두 선분이 만날 수 있으면
						double den = (double)(p1.x - p2.x) * (p3.y - p4.y) -			// 분모 = 0이면 기울기 같음
								(p1.y - p2.y) * (p3.x - p4.x);
						if(tmp1==0 && tmp2==0 && den==0) {								// 네 점 평행하면
							if(Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) &&
									Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) &&
									Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) &&
									Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y)) {
								Point min1, max1, min2, max2;
								if(p1.x<p2.x || (p1.x==p2.x && p1.y<p2.y)) {
									min1 = p1;
									max1 = p2;
								}
								else {
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
								if(max1.equals(min2) || max2.equals(min1))				// 1 - 끝점 하나에서만 만나는 경우
									output = 1;
								else													// 3 - 너무 많이 겹침
									output = 3;
							}
							else														// 0 - 평행만 하고 안만남
								output = 0;
						}
						else {															// 네 점 평행하지 않으면
							if(ccw(p1, p2, p3)==0 || ccw(p1, p2, p4)==0 ||				// 1 - 끝점이 교점인지 확인
									ccw(p3, p4, p1)==0 || ccw(p3, p4, p2)==0) {
								output = 1;
							}
							else														// 2 - 끝점이 교점이 아님
								output = 2;
						}
					}
					else																//  0 - 안만남
						output = 0;
				}
				sb.append(output);
			}
			sb.append("\n");
		}
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

		@Override
	    public boolean equals(Object o) {
	        Point z = (Point) o;
	        return this.x==z.x && this.y==z.y;
	    }
	}

	// Point 두개를 묶어 선분으로 관리하는 Line 클래스
	public static class Line {
		Point p1, p2;

		Line(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
	}
}