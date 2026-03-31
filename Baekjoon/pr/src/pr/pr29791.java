// 백준 29791번
// 메이플에는 에르다 노바와 오리진 스킬이 있음.
// 에르다 노바 -> 행동 불가 걸 수 있는 스킬, 재사용 대기 시간 100초
// 오리진 -> 절대 행동 불가 걸 수 있는 스킬, 재사용 대기 시간 360초
// 스킬을 맞은 몬스터는 90초 동안 각각의 스킬에 대해 면역이 됨.
// 에르다 노바 사용 횟수와 오리진 스킬 사용 횟수, 에르다 노바의 단축키를 누른 시점들
// 그리고 오리진 스킬의 단축키를 누른 시점들이 주어질 때
// 몬스터가 행동 불가와 절대 행동 불가 상태가 된 횟수를 구하는 문제.
// 방법---------------------
// 첫 줄에 노바 사용 횟수 n과 오리진 사용 횟수 m이 주어짐.
// 다음 줄에 노바 단축키를 누른 시점 n개가 한 줄에 주어지고
// 그 다음 줄에는 오리진 단축키를 누른 시점 m개가 한 줄에 주어진다.
// 입력 받은거 오름차순 정렬해주고 스킬 쿨 생각해 주면서
// 지금 사용 가능한지 체크하고 바인드 걸린 횟수 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr29791 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nova = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			nova[i] = Integer.parseInt(st.nextToken());
		int[] origin = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			origin[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(nova);
		Arrays.sort(origin);
		// 스킬 사용횟수 구하기
		int novaTime = 0;						// 노바 사용시간
		int originTime = 0; 					// 오리진 사용시간
		int sum1 = 0;							// 노바 사용횟수
		int sum2 = 0;							// 오리진 사용횟수
		for(int i=0; i<nova.length; i++){
			int tmp = nova[i];
			if(tmp >= novaTime){
				novaTime = tmp + 100;			// 스킬 쿨타임 100초
				sum1++;
			}
		}
		for(int i=0; i<origin.length; i++){
			int tmp = origin[i];
			if(tmp >= originTime){
				originTime = tmp + 360;			// 스킬 쿨타임 360초
				sum2++;
			}
		}
		// 출력
		System.out.print(sum1 + " " + sum2);
	}
}