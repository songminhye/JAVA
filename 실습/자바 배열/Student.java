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
  return "�̸�: "+name+"  �й�: "+number+"  ����: "+major+"  �̼�����: "+grade;
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
  return super.toString()+"  ���Ƹ�: "+club;
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
    schol = "����";
  }
   else
    schol = "������";

}


public String toString(){
  return super.toString()+"  ����: "+assistant+"  ���бݺ��� :"+randoms+"  ���бݿ���: " + schol;
}
}

public class StudentTest{
 public static void main(String args[]){

 UnderGraduate a = new UnderGraduate("�۹���",2016110660,"���ڰ��к�",80,"BIST");
 Graduate b = new Graduate("������",2013110660,"���ڰ��к�",150,"��������");
 Student c = new Student("���ֿ�",2016114294,"���ڰ��к�",80);
 b.setSchol();

 System.out.println(a);
 System.out.println(b);
 System.out.println(c);

 b.setName("���ֿ�");
 a.setClub("�丮����");
 b.setSchol();
 c.setNumber(2017110660);

 System.out.println(a.toString());
 System.out.println(b.toString());
 System.out.println(c.toString());
}
}