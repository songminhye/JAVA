import java.util.Scanner;

public class Add {
 public static void main(String args[]){

  
  double x;
  double y;
  double z;
  

  Scanner input = new Scanner(System.in);
  System.out.print("ù��° ���ڸ� �Է��Ͻÿ�: ");
  x = input.nextDouble();

  System.out.print("�ι�° ���ڸ� �Է��Ͻÿ�: ");
  y = input.nextDouble();


  z = x + y;
  
  System.out.println(z);


 }
}