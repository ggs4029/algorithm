// 백준 1673번
// 강민이는 치킨 한 마리를 주문할 수 있는 치킨 쿠폰을 n장 가지고 있다.
// 치킨을 한 마리 주문할 때마다 도장을 하나씩 찍어 주는데, 도장을 k개 모으면 치킨 쿠폰 한 장으로 교환 가능.
// 강민이가 지금 갖고 있는 치킨 쿠폰으로 치킨을 최대 몇 마리나 먹을 수 있는지 구하여라.
// 단, 치킨을 주문하기 위해서는 반드시 치킨 쿠폰을 갖고 있어야 함.
// 방법---------------------
// 여러 줄에 걸쳐 n과 k가 주어짐.
// 각 입력 마다 치킨을 몇 마리나 먹을 수 있는지 while문으로 계산 후 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1673 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine())!=null && !input.trim().isEmpty()) {
			String[] input2 = input.split(" ");
			long n = Long.parseLong(input2[0]);
			long k = Long.parseLong(input2[1]);
			// 치킨 구하기
			long sum = 0;
			long coupon = 0;								// 치킨 다 시키면 쿠폰 n개 모임
			coupon = n;
			while(coupon>=k) {
				long tmp = coupon / k;						// 쿠폰으로 벌어먹은 치킨
				sum += tmp;
				coupon = coupon % k + tmp;
            }
			// 출력
			System.out.println(n+sum);
		}
	}
}