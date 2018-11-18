import java.util.*;
public class TheaterReserve {
 public static void main(String args[]){

  int k;
  int[] seat = new int[10];
  int i;

 for(i=0; i<seat.length; i++)
  seat[i] = 0;
  
 

 Scanner input = new Scanner(System.in);

 
 
 while(true) {

  System.out.println("-----------------------");
  System.out.println("1 2 3 4 5 6 7 8 9 10");
  System.out.println("-----------------------"); 
  
 for(int r : seat){
  System.out.print(r+" ");}

  System.out.println();
  System.out.println("-----------------------");

  System.out.print("원하시는 좌석번호를 입력하세요(종료는 -1): ");
  k = input.nextInt();

 if(k == -1)
   {
     break;
   }

 
 if(seat[k-1] == 0) {
    seat[k-1] = 1;
    System.out.println("예약되었습니다.");
   }
  else
   System.out.println("이미 예약된 자리입니다.");

 }

  
}
}


  