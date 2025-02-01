// 백준 29792번
// 카오가 n개의 캐릭터 중 메소를 캐기 위해
// 하루에 한 캐릭터 당 최대 15분씩 최대 m개의 캐릭터만 보스를 잡기로 하였다.
// 캐릭터마다 주어진 15분 동안은 매초 일정한 데미지를 넣을 수 있으며,
// 보스를 잡은 후 다른 보스를 잡으러 떠나는 시간은 계산하지 않는다.
// 캐릭터마다 각 보스는 1회씩만 처치할 수 있으며, 다른 캐릭터가 잡은 보스라도, 현재 캐릭터가 잡지 않은 보스라면 잡을 수 있다.
// 보스를 잡던 도중 캐릭터를 변경하는 것은 불가능하며, 캐릭터가 상대하는 보스의 체력은 공유되지 않아,
// 오롯이 한 캐릭터의 힘으로 보스를 상대해야 할 때, 보스 몬스터의 체력, 보상 메소 정보와 캐릭터의 데미지 정보가 주어지면
// 카오가 계획에 맞추어 하루에 보스를 잡아 얻을 수 있는 최대 메소가 몇인지 구해보자.
// 방법---------------------
// 첫 줄에 n, m, k가 주어짐.
// 둘째 줄부터 n줄에 걸쳐 캐릭터의 dps가 주어짐.
// 그 다음줄부터 k줄에 걸쳐 보스의 체력 p와 처치 시 드랍 메소 q가 주어짐.
// dp[i] = i초 동안 얻을 수 있는 최대 메소

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class pr29792 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] dps = new long[n];
		for(int i=0; i<n; i++)
			dps[i] = Long.parseLong(br.readLine());
		long[] boss = new long[k];
		int[] drop = new int[k];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			boss[i] = Long.parseLong(st.nextToken());
			drop[i] = Integer.parseInt(st.nextToken());
		}
		// 캐릭터별로 최대 메소 구하기
		Integer[] meso = new Integer[n];
		for(int i=0; i<n; i++) {
			long tmp = dps[i];								// 현재 캐릭의 dps
			int[] dp = new int[900 + 1]; 					// dp[i] = i초 동안 얻을 수 있는 최대 메소
			for(int j=0; j<k; j++) {
				long clearTime = (boss[j] + tmp - 1) / tmp; // 이 보스를 잡는데 필요한 시간
				if(clearTime > 900)							// 시간 내에 잡을 수 없으면
					continue;								// pass
				for(int l=900; l>=clearTime; l--)
					dp[l] = Math.max(dp[l], dp[l-(int)clearTime] + drop[j]);
			}
			meso[i] = dp[900];
		}
		// 내림차순 정렬
		Arrays.sort(meso, Collections.reverseOrder());
		// 메소 제일 잘버는 캐릭터 m개 선택
		long output = 0;
		for(int i=0; i<m; i++)
			output += meso[i];
		// 출력
		System.out.print(output);
	}
}