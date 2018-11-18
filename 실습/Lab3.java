import java.util.Scanner;

public class Lab3 {
 public static void main(String args[]){


int b = -3;
int c = 2;
double dis;
double root1, root2;

dis = Math.pow(b, 2)-(4*c);
root1 = (-b + Math.sqrt(dis))/2;
root2 = (-b - Math.sqrt(dis))/2;

System.out.println("근은" + root1);
System.out.println("근은" + root2);



 }
}