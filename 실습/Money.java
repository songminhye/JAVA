import java.util.Scanner;

public class Money{
public static void main(String args[]){

Scanner input = new Scanner(System.in);

double dollar;
int won;

System.out.print("원화를 입력하세요: ");
won = input.nextInt();

dollar =  won * (1/1392.83);

System.out.print("달러는 "+dollar+"$ 입니다.");

}
}

//환율 적용해주는 코드 