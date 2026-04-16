import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr24860 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		st = new StringTokenizer(br.readLine());
		long vk = Long.parseLong(st.nextToken());
		long jk = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long vl = Long.parseLong(st.nextToken());
		long jl = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long vh = Long.parseLong(st.nextToken());
		long dh = Long.parseLong(st.nextToken());
		long jh = Long.parseLong(st.nextToken());
		// 생성할 수 있는 면역글로불린 분자 경우의 수 계산하기
		long light = (vk * jk) + (vl * jl);
		long heavy = vh * dh * jh;
		// 출력
		System.out.print(light * heavy);
	}
}