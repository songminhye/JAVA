public class Mine{

public static void main(String[] args) {

boolean[][] board= new boolean[10][10];
for(int i= 0; i< 10; i++){
  for(int j= 0; j< 10; j++){
     if( Math.random() < 0.3 )
         board[i][j] = true;}}
for(int i= 0; i< 10; i++) {
  for(int j= 0; j< 10; j++){
     if(board[i][j]== false)
        System.out.print("# ");
     else
        System.out.print(". ");
}
    System.out.println();
      }
    }
}

//랜덤으로 바둑판에 #을 넣어주는 코드