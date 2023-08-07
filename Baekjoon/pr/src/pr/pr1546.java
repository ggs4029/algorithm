// 백준 1546번
// 시험점수를 조작하는 문제
// 방법-------------------------
// 시험본 과목의 개수 n을 입력받음
// 그 뒤에 n개의 성적을 입력 받음
// 입력 받은 성적 중 최고값을 for문을 통해 찾는다

package pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n 입력받기, n개의 성적을 입력 받기
		int n = Integer.parseInt(br.readLine());
		String[] arr1 = br.readLine().split(" ");
		double[] arr2 = new double[n];
		for(int x=0; x<arr1.length; x++) {
			arr2[x] = Integer.parseInt(arr1[x]);
		}
		// 성적 중에서 최댓값 찾기
		double max = -1.0;
		for(double e:arr2) {
			if(e>max)
				max=e;
		}
		// 성적 고치기
		double sum = 0;
		for(int x=0; x<arr2.length; x++) {
			arr2[x] = arr2[x]*100/max;
			sum = arr2[x] +sum;
		}
		// 출력
		System.out.print(sum/arr2.length);
	}
}
