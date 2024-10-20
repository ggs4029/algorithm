// 백준 3373번
// 문제에서 주어진 내용을 기반으로 총 비용을 출력하는 문제
// 방법---------------------
// 첫 줄에 입력 데이터의 개수 n을 입력 받고
// n줄에 걸쳐 나라이름을 입력 받는다.
// 케이스마다 드는 비용을 계산하여 출력.
// ------------------------
// 나마비아 - 오기 전에 남아프리카공화국 들렀으면 40 아니면 140
// 남아프리카 공화국, 보츠와나 - 0
// 케냐 - 50
// 짐바브웨 - 30
// 잠비아 - 50
// 짐바브웨 -> 잠비아 or 잠비아 -> 0 and 20
// 탄자니아 - 50
// 에티오피아 - 50

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] s = new String[n];
		for(int i=0; i<n; i++)
			s[i] = br.readLine();
		// 비용 계산
		int sum = 0;
		String tmp = "";						// 전에 들른 나라
		boolean sa = false;						// 남아공 들렀는지 체크
		for(int i=0; i<n; i++) {
			if(s[i].equals("botswana")) {
				tmp = "botswana";
			}
			else if(s[i].equals("ethiopia")) {
				sum += 50;
				tmp = "ethiopia";
			}
			else if(s[i].equals("kenya")) {
				sum += 50;
				tmp = "kenya";
			}
			else if(s[i].equals("namibia")) {
				if(sa)
					sum += 40;
				else
					sum += 140;
				tmp = "namibia";
			}
			else if(s[i].equals("south-africa")) {
				sa = true;
				tmp = "south-africa";
			}
			else if(s[i].equals("tanzania")) {
				sum += 50;
				tmp = "tanzania";
			}
			else if(s[i].equals("zambia")) {
				if(tmp.equals("zimbabwe"))
					sum += 20;
				else
					sum += 50;
				tmp = "zambia";
			}
			else if(s[i].equals("zimbabwe")) {
				if(tmp.equals("zambia"))
					sum += 0;
				else
					sum += 30;
				tmp = "zimbabwe";
			}
		}
		// 출력
		System.out.print(sum);
	}
}