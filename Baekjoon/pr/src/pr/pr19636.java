// 백준 19636번
// D일 간의 다이어트가 끝난 후, 일일 기초 대사량의 변화를 고려하지 않았을 때와
// 일일 기초 대사량의 변화를 고려했을 때 각각의 예상 체중과 일일 기초 대사량을,
// 그리고 다이어트 전 데시의 원래 생활로 돌아간다면 몸무게가 증가하는 요요 현상이 일어날지 계산하는 문제
// 방법---------------------
// 첫 줄에는 다이어트 전 체중 W0, 다이어트 전 일일 에너지 섭취량 I0, 기초 대사량 변화 역치 T가 주어짐.
// 두번째 줄에는 다이어트 기간 D와 다이어트 기간 일일 에너지 섭취량 I, 다이어트 기간 일일 활동 대사량 A가 주어진다.
// 문제에서 주어진대로 일일 기초 대사량의 변화를 고려하지 않았을 때의 다이어트 후 예상 체중과 일일 기초 대사량을 출력.
// + 다음 줄에 일일 기초 대사량의 변화를 고려했을 때의 다이어트 후 예상 체중과 일일 기초 대사량을 출력하고
// 요요 현상 발생 여부 또한 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19636 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		long W0 = Long.parseLong(input[0]); 						// 다이어트 전 체중
		long I0 = Long.parseLong(input[1]); 						// 다이어트 전 기초 대사량
		long T = Long.parseLong(input[2]); 							// 기초 대사량 변화 역치
		String[] input2 = br.readLine().split(" ");
		int D = Integer.parseInt(input2[0]); 						// 다이어트 기간
		long I = Long.parseLong(input2[1]); 						// 다이어트 중 일일 에너지 섭취량
		long A = Long.parseLong(input2[2]); 						// 다이어트 중 일일 활동 대사량
		// 다이어트 기간 동안 체중과 기초 대사량 계산
		long weight1 = W0; 											// 기초 대사량 고려하지 않은 체중
		long weight2 = W0; 											// 기초 대사량 고려한 경우 체중
		long I1 = I0; 												// 변화 고려하지 않은 기초 대사량
		long I2 = I0; 												// 변화 고려한 기초 대사량
		for(int i=0; i<D; i++) {
			weight1 += I - (I1 + A);
			weight2 += I - (I2 + A);
			// 기초 대사량 변화
			if(Math.abs(I - (I2 + A)) > T)
				I2 += Math.floor((I - (I2 + A)) / 2.0);
		}
		// 출력
		if(weight1<=0)
			System.out.println("Danger Diet");
		else
			System.out.println(weight1 + " " + I0);
		if(weight2<=0 || I2<=0)
			System.out.print("Danger Diet");
		else {
			System.out.print(weight2 + " " + I2 + " ");
			if(I0-I2>0)												// 요요 현상 계산
				System.out.println("YOYO");
			else
				System.out.println("NO");
		}
	}
}