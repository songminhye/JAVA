public class GetMin{
 public static void main(String args[]){

 int s[] = {12, 3, 19, 6, 18, 8, 12, 4, 1, 19};
 int minimum = s[0];
 int i;

 for(i=0; i<s.length; i++){
    
     if(minimum > s[i]) {
         
          minimum = s[i];
      }
    }

System.out.println("최소값은 "+minimum);
}
}
    

