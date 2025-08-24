import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr2592 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] num = new int [1001];
		int sum = 0;
		for(int i=0; i<10; i++){
			int tmp = Integer.parseInt(br.readLine());
			num[tmp]++;
			sum += tmp;
		}
		// 평균과 최빈값 구하기
		int idx = 0;
		int output = 0;
		for(int i=0; i<=1000; i++){
			if(output < num[i]) {
				output=num[i];
				idx = i;
			}
		}
		// 출력
		System.out.println(sum / 10);
		System.out.print(idx);
	}
}