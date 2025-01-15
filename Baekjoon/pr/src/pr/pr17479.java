// 백준 17479번
// 정식당에는 다양한 메뉴들이 있지만 크게 3가지로 나눌 수 있는데,
// A개의 "일반메뉴", B개의 "특별메뉴", C개의 "서비스메뉴"로 나뉘어져 있다.
// 일반메뉴는 자유롭게 주문할 수 있으나 특별메뉴와 서비스메뉴는 주문할 때 제약이 있다.
// 손님들이 주문하는 것이 옳은 주문인지 아닌지 판별하는 문제.
// 메뉴 주문에 대한 제약은 문제 참고.
// 방법---------------------
// 첫 줄에 a, b, c가 주어진다.
// 그 다음 줄부터 a줄에 걸쳐 일반 메뉴의 이름과 가격이 주어짐.
// 그 다음 b줄에 걸쳐 특별 메뉴의 이름과 가격이 주어짐.
// 그 다음 c줄에 걸쳐 서비스 메뉴의 이름과 가격이 주어짐.
// 그 다음 줄에 손니밍 주문하는 음식 수 n이 주어지고
// 그 다음 줄부터 n줄에 걸쳐 손님이 주문하는 음식의 이름들이 주어진다.
// 해시맵 두개 만들어서 하나는 메뉴, 가격 하나는 메뉴, 타입 으로 사용.
// 주문 받고 각 메뉴 타입마다 가격 합 구해놓고 제약을 위반하는지 검사하고 답을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class pr17479 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> menu = new HashMap<>();
		HashMap<String, Integer> type = new HashMap<>();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		for(int i=0; i<a; i++){
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			menu.put(tmp, Integer.parseInt(st.nextToken()));
			type.put(tmp, 1);
		}
		for(int i=0; i<b; i++){
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			menu.put(tmp, Integer.parseInt(st.nextToken()));
			type.put(tmp, 2);
		}
		for(int i=0; i<c; i++) {
			String tmp = br.readLine();
			menu.put(tmp, 0);									// 서비스 메뉴는 0원
			type.put(tmp, 3);
		}
		// 옳은 주문인지 판별하기
		long general = 0, special = 0, specialSize = 0;
		int service = 0;
		int order = Integer.parseInt(br.readLine());
		for(int i=0; i<order; i++){
			String input = br.readLine();
			int tmp = type.get(input);
			if(tmp==1)											// 일반 요리면
				general += menu.get(input);						// 가격 적어두기
			else if(tmp==2){									// 스페셜 요리면
				special += menu.get(input);						// 적어두기
				specialSize++;
			}
			else
				service++;
		}
		// 출력
		if((general<20000 && specialSize>0)) {					// 제약 1
			System.out.print("No");
			return;
		}
		else if((general+special<50000 && service>0)) {			// 제약 2
			System.out.print("No");
			return;
		}
		else if(service>1) {									// 제약 3
			System.out.print("No");
			return;
		}
		else
			System.out.print("Okay");

	}
}