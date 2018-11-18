class Student {
  
  private String name;
  private int number;
  private String major;
  private int grade;

 public Student(String name,int number,String major, int grade){
  this.name = name;
  this.number = number;
  this.major = major;
  this.grade = grade;
   }

 public void setName(String name){
  this.name = name;
  }
 public String getName(){
   return name;
  } 
 
  public void setNumber(int number){
  this.number = number;
  }
 public int getNumber(){
   return number;
  } 
 
  public void setMajor(String major){
  this.major = major;
  }
 public String getMajor(){
   return major;
  }  

  public void setGrade(int grade){
  this.grade = grade;
  }
 public int getGrade(){
   return grade;
  }  

 public String toString(){
  return "이름: "+name+"  학번: "+number+"  전공: "+major+"  이수학점: "+grade;
 }
}

class UnderGraduate extends Student{
 
  private String club;

  public UnderGraduate(String name,int number,String major, int grade, String club){
   super(name,number,major,grade);
   this.club = club;
  }
 
 public void setClub(String club){
  this.club = club;
  }
 public String getClub(){
   return club;
  }  

 public String toString(){
  return super.toString()+"  동아리: "+club;
 }
}

class Graduate extends Student{

 private double randoms ;
 private String schol;
 private  String assistant;

 public Graduate(String name,int number,String major, int grade,String assistant){
  super(name,number,major,grade);
  this.assistant=assistant;
  
 }

public void setAssistant(String assistant){
  this.assistant = assistant;
  }
 public String getAssistant(){
   return assistant;
  }  

public void setSchol(){
  
  randoms = Math.random();
  
  
  if(randoms >= 0.7)
  {
    schol = "받음";
  }
   else
    schol = "못받음";

}


public String toString(){
  return super.toString()+"  조교: "+assistant+"  장학금비율 :"+randoms+"  장학금여부: " + schol;
}
}

public class StudentTest{
 public static void main(String args[]){

 UnderGraduate a = new UnderGraduate("송민혜",2016110660,"전자공학부",80,"BIST");
 Graduate b = new Graduate("김주은",2013110660,"전자공학부",150,"연구조교");
 Student c = new Student("박주영",2016114294,"전자공학부",80);
 b.setSchol();

 System.out.println(a);
 System.out.println(b);
 System.out.println(c);

 b.setName("이주영");
 a.setClub("요리조리");
 b.setSchol();
 c.setNumber(2017110660);

 System.out.println(a.toString());
 System.out.println(b.toString());
 System.out.println(c.toString());
}
}