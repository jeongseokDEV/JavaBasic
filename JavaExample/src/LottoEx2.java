import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoEx2 {
	public static void main(String[] args)
	{
		LottoEx2 Lotto = new LottoEx2();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("로또 번호 추출 개수 입력 : ");
		int gameCnt = sc.nextInt();
		
		for(int i = 1; i <= gameCnt; i++)
		{
			System.out.println(i + "번쨰 로또번호 : " + Lotto.lottoNumbers());
		}
	}
	
	String lottoNumbers()
	{
		List<Integer> lottoNum = new ArrayList<Integer>();
		
		for(int i = 1; i <= 45; i++)
		{
			lottoNum.add(i);

		}
		
		Collections.shuffle(lottoNum);
		
		int[] lottoNums = new int[6];
		for(int i = 0; i <= 5; i++)
		{
			lottoNums[i] = lottoNum.get(i);
		}
		
		Arrays.sort(lottoNums);
		return Arrays.toString(lottoNums);
	}
}
