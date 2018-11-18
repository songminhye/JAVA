import java.util.*;
public class ArrayTest2 {
 public static void main(String args[]){
   
  final int student = 5;
  int total = 0;
  int [] numbers = new int[student];

  Scanner input = new Scanner(System.in);
 
 for(int i=0; i<student; i++)
{
  System.out.print("성적을 입력하시오: ");
  numbers[i] = input.nextInt();
 }

 for(int i=0; i<student; i++)
 {
   total += numbers[i];
  }

 System.out.println("평균성적은"+total/student+"입니다.");
}
}

 