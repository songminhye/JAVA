import java.util.*;
public class Array{
 public static void main(String args[]) {



   int [][] s = new int[10][10];
   Random r = new Random();
   int c = r.nextInt(9);
   int l = r.nextInt(9);
   int i,j;

   s[c][l] = 1;

   

   for(int p =0; p<10;p++){
   int k = r.nextInt(3) ;
    if(k==0)
      { if(c==0)
          System.out.println("못간다.");
         else
         { c -= 1;
        s[c][l] =1; }
       }

     else if(k==1)
       {
          if(l==9)
             System.out.println("못간다.");
          else {
          l += 1;
         s[c][l] =1;
          }
        }
     else if(k==2)
       {
           if(c==9)
             System.out.println("못간다.");
          else {
           c+=1;
          s[c][l]=1;
          }
         }
     else if(k==3)
       { if(l==0)
          System.out.println("못간다.");
         else{
           l -= 1;
          s[c][l] =1;
         }
        }

     System.out.println("---------------------");
     for(i=0; i<10; i++) {
          for(j=0; j<10; j++) {
                  if(s[i][j] == 1)
                      System.out.print("# ");
		  else 
		      System.out.print(". ");
            }
        System.out.println();
        }
     System.out.println(k);
      
     System.out.println("---------------------");


}


     
    

 
}
}