import java.util.InputMismatchException;
import java.util.Scanner;

public class RockPaperScissors {
	private Scanner scanner = new Scanner(System.in);
	private String hand[] = { "가위", "바위", "보" };
	private int youHand, cpuHand;
	private int win, lose, draw;
	
	public void play() {
		while(true) {
			System.out.println("숫자를 입력하세요.");
			System.out.println("가위(1) 바위(2) 보(3) 종료(0)");
			System.out.print("선택 : ");
			
			try {
				youHand = scanner.nextInt();
			} catch(InputMismatchException e) {
				scanner.nextLine();
				System.out.println("잘못 입력했습니다.");
				System.out.println();
				continue;
			}
			
			cpuHand = (int)(Math.random()*3)+1;
			
			if(youHand == 0) {
				break;
			}
			else if(youHand < 0 || youHand > 3) {
				System.out.println("잘못 입력했습니다.");
				System.out.println();
				continue;
			}
			
			judgment();
		}
	}

	private void judgment() {
		System.out.println();
		System.out.println("당신 : " + hand[youHand-1] + " cpu : " + hand[cpuHand-1]);
		
		if(youHand - cpuHand == 1 || youHand - cpuHand == -2) {
			win++;
			System.out.println("당신이 이겼습니다.");
			record();
		}
		else if(youHand - cpuHand == -1 || youHand - cpuHand == 2) {
			lose++;
			System.out.println("당신이 졌습니다.");
			record();
		}
		else if(youHand == cpuHand) {
			draw++;
			System.out.println("비겼습니다.");
			record();
		}
		System.out.println();
	}
	
	private void record() {
		System.out.println(win + "승 " + lose + "패 " + draw + "무");
		if(win+lose == 0) {
			System.out.println("승률 : 0.00%");
			System.out.println();
		}
		else {
			System.out.printf("승률 : %.2f%%", (double)win/(win+lose)*100);
			System.out.println();
		}
	}
}
