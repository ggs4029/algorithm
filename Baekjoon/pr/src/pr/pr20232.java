import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20232 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int y = Integer.parseInt(br.readLine());
		// 출력
		if(y == 1995)
			System.out.print("ITMO");
		else if(y>=1996 && y<=1997)
			System.out.print("SPbSU");
		else if(y>=1998 && y<=1999)
			System.out.print("ITMO");
		else if(y == 2000)
			System.out.print("SPbSU");
		else if(y>=2001 && y<=2005)
			System.out.print("ITMO");
		else if(y == 2006)
			System.out.print("PetrSU, ITMO");
		else if(y>=2007 && y<=2008)
			System.out.print("SPbSU");
		else if(y>=2009 && y<=2012)
			System.out.print("ITMO");
		else if(y == 2013)
			System.out.print("SPbSU");
		else if(y>=2014 && y<=2017)
			System.out.print("ITMO");
		else if(y == 2018)
			System.out.print("SPbSU");
		else if(y == 2019)
			System.out.print("ITMO");
	}
}