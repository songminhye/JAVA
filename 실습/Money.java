import java.util.Scanner;

public class Money{
public static void main(String args[]){

Scanner input = new Scanner(System.in);

double dollar;
int won;

System.out.print("��ȭ�� �Է��ϼ���: ");
won = input.nextInt();

dollar =  won * (1/1392.83);

System.out.print("�޷��� "+dollar+"$ �Դϴ�.");

}
}

//ȯ�� �������ִ� �ڵ� 