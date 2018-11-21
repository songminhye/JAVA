
class Book{

private String title;
private int page;
private String writer;

 public Book(String title,int page,String writer)
 {
   this.title = title;
   this.page = page;
   this.writer = writer;
 }

 public void setTitle(String title){
  this.title = title;
}

 public void setPage(int page){
  this.page = page;
}
 public void setWriter(String writer){
 this.writer = writer;
}
 public String getTitle(){
  return title;
}
 public int getPage(){
 return page;
}

 public String getWriter(){
 return writer;
}

 public String toString(){
  return "å�̸�: " + title + " ������ : "+page+" �۰� : "+writer;
}

}

class Magazine extends Book{

 private String date;

  public Magazine(String title,int page,String writer,String date){
    
   super(title,page,writer);
   this.date = date;
}

 public void setDate(String date){
  this.date = date;
 }
 public String getDate(){
  return date;
 }

 public String toString(){
   return super.toString()+" �߸��� :"+date;
}
}

public class MagazineTest{
 public static void main(String args[]){

   Magazine a = new Magazine("����1",60,"�达","2018�� 5�� 3��");
   Magazine b = new Magazine("����2",80,"�̾�","2017�� 4�� 6��");
   Book c = new Book("����3",50,"�۾�");
   c.setTitle("����4");
   b.setPage(100);

   System.out.println(a.toString());
    System.out.println(b.toString());
    System.out.println(c.toString());
    System.out.println(a.getTitle());

}
}

//������ ���� ����غ� �ڵ�
