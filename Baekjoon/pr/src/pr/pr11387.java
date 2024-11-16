// 백준 11387번
// 주어진 전투력 공식에 따라 계산해
// 크리와 파부가 서로의 무기를 장착했을 때의 전투력 변화 여부를 비교하고 그 결과를 출력하는 문제.
// 방법---------------------
// 각 줄마다 "공격력", "힘", "치명타 확률", "치명타 피해비율", "공격속도 증가" 를 입력 받음.
// 첫 줄은 크리꺼 두번째 줄은 파부꺼.
// 세 번째 줄에는 크리가 현재 장착하고 있는 무기가 올려주는 수치,
// 네 번째 줄에는 파부가 현재 장착하고 있는 무기가 올려주는 수치를 입력 받음.
// 문제에서 주어진 식에 따라 전투력을 구하고
// 출력 첫 번째 줄에 크리가 파부의 무기를 장착할 때 전투력 변화 여부를 출력.
// 출력 두 번째 줄에는 파부가 크리의 무기를 장착할 때 전투력 변화 여부를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11387 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		String[] input3 = br.readLine().split(" ");
		String[] input4 = br.readLine().split(" ");
		// 크리 스텟
		int power1 = Integer.parseInt(input1[0]);
		int strength1 = Integer.parseInt(input1[1]);
		double critical1 = Integer.parseInt(input1[2]) / 100.0;
		double criDamage1 = Integer.parseInt(input1[3]) / 100.0;
		double attackSpeed1 = Integer.parseInt(input1[4]) / 100.0;
		// 파부 스텟
		int power2 = Integer.parseInt(input2[0]);
		int strength2 = Integer.parseInt(input2[1]);
		double critical2 = Integer.parseInt(input2[2]) / 100.0;
		double criDamage2 = Integer.parseInt(input2[3]) / 100.0;
		double attackSpeed2 = Integer.parseInt(input2[4]) / 100.0;
		// 크리 무기 스텟
		int weaponAttack1 = Integer.parseInt(input3[0]);
		int weaponStrength1 = Integer.parseInt(input3[1]);
		double weaponCri1 = Integer.parseInt(input3[2]) / 100.0;
		double weaponCriDamage1 = Integer.parseInt(input3[3]) / 100.0;
		double weaponAttackSpeed1 = Integer.parseInt(input3[4]) / 100.0;
		// 파부 무기 스텟
		int weaponAttack2 = Integer.parseInt(input4[0]);
		int weaponStrength2 = Integer.parseInt(input4[1]);
		double weaponCri2 = Integer.parseInt(input4[2]) / 100.0;
		double weaponCriDamage2 = Integer.parseInt(input4[3]) / 100.0;
		double weaponAttackSpeed2 = Integer.parseInt(input4[4]) / 100.0;
		// 전투력 계산
		double cri = power(power1, strength1, critical1, criDamage1, attackSpeed1);
		double pabu = power(power2, strength2, critical2, criDamage2, attackSpeed2);
		// 크리가 파부의 무기를 장착
		double output1 = power(
				power1 + weaponAttack2 - weaponAttack1,
				strength1 + weaponStrength2 - weaponStrength1,
				critical1 + weaponCri2 - weaponCri1,
				criDamage1 + weaponCriDamage2 - weaponCriDamage1,
				attackSpeed1 + weaponAttackSpeed2 - weaponAttackSpeed1);
		// 파부가 크리의 무기를 장착
		double output2 = power(
				power2 + weaponAttack1 - weaponAttack2,
				strength2 + weaponStrength1 - weaponStrength2,
				critical2 + weaponCri1 - weaponCri2,
				criDamage2 + weaponCriDamage1 - weaponCriDamage2,
				attackSpeed2 + weaponAttackSpeed1 - weaponAttackSpeed2);
		// 출력
		if(output1>cri)
			System.out.println("+");
		else if(output1==cri)
			System.out.println("0");
		else
			System.out.println("-");
		if(output2>pabu)
			System.out.print("+");
		else if(output1==pabu)
			System.out.print("0");
		else
			System.out.print("-");
	}

	// 전투력 계산
	private static double power(int attack, int strength, double critRate, double critDamage, double attackSpeed) {
		critRate = Math.min(critRate, 1.0);
		return attack * (1 + strength / 100.0) * ((1 - critRate) + critRate * critDamage) * (1 + attackSpeed);
	}
}