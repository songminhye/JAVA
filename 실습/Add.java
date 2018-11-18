import java.util.Scanner;

public class Add {
 public static void main(String args[]){

  
  double x;
  double y;
  double z;
  

  Scanner input = new Scanner(System.in);
  System.out.print("첫번째 숫자를 입력하시오: ");
  x = input.nextDouble();

  System.out.print("두번째 숫자를 입력하시오: ");
  y = input.nextDouble();


  z = x + y;
  
  System.out.println(z);


 }
}