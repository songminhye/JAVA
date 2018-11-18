import java.util.Scanner;

public class Lab5 {
 public static void main(String args[]){
 
 double w;
 double h;
 double area;
 double c;

 Scanner input = new Scanner(System.in);
 System.out.print("사각형의 가로 크기: ");
 w = input.nextDouble();

 System.out.print("사각형의 세로 크기: ");
 h = input.nextDouble();

 area = w * h;
 c = 2 * (w + h );

 System.out.println("사각형의 넓이 : " + area);
 System.out.println("사각형의 둘레 : " + c);

 




 }
}