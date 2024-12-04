// 백준 11689번
// 준석이가 탄핵되지 않으면서 학생회가 가져갈 수 있는 최대 예산을 정수로 출력하는 문제.
// 탄핵은 과반수 이상이 찬성하면 탄핵당함.
// 학생회보다 예산을 조금 받는 단체 애들은 탄핵투표에 찬성하고 아닌 단체 애들은 반대를 던짐.
// 방법---------------------
// 첫째 줄에 학생 단체 수 n과 총예산 m이 주어짐.
// 둘째 줄에는 각 학생단체의 표의 수가 n개 주어짐.
// 리스트로 표 수 받고, 내림차순 정렬.
// 총 표 수 구해서 절반 구하고 for문 돌면서 맨 앞 값부터 총 표에서 빼가며 과반수 넘을 때의 인덱스 구함.
// m/(인덱스+1+1) 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pr31673 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		long m = Long.parseLong(input[1]);
		String[] input2 = br.readLine().split(" ");
		List<Long> vote = new ArrayList<>();
		for(int i=0; i<n; i++)
			vote.add(Long.parseLong(input2[i]));
		// 정렬
		Collections.sort(vote, Collections.reverseOrder());		// 내림차순으로
		// 최대 예산 구하기
		long total = 0;
        for(long i : vote)
            total += i;
        long sum = total;
		long mid = total / 2;
		int tmp = 0;
		for(int i=0; i<n; i++) {
			sum -= vote.get(i);
			if(sum<=mid) {										// 과반수 이상 되면
				tmp = i;										// 인덱스 기록하고 break
				break;
			}
		}
		// 출력
		System.out.print(m / (tmp + 2));
	}
}