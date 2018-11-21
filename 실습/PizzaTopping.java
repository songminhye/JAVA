import java.util.*;
public class PizzaTopping {
public static void main(String args[]){

final int pizza = 5;
String[] topping = new String[pizza];

topping[0] = "Pepperoni";
topping[1] = "Mushrooms";
topping[2] = "Onions";
topping[3] = "Sausage";
topping[4] = "Bacon";

for(int i=0; i<pizza; i++)
{
  System.out.print(topping[i]+" ");
}
}
}

//topping을 모두 print한다. 