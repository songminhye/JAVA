import java.util.Scanner;

public class Lab5 {
 public static void main(String args[]){
 
 double w;
 double h;
 double area;
 double c;

 Scanner input = new Scanner(System.in);
 System.out.print("�簢���� ���� ũ��: ");
 w = input.nextDouble();

 System.out.print("�簢���� ���� ũ��: ");
 h = input.nextDouble();

 area = w * h;
 c = 2 * (w + h );

 System.out.println("�簢���� ���� : " + area);
 System.out.println("�簢���� �ѷ� : " + c);

 




 }
}