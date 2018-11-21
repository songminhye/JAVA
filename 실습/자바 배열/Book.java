
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
  return "책이름: " + title + " 페이지 : "+page+" 작가 : "+writer;
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
   return super.toString()+" 발매일 :"+date;
}
}

public class MagazineTest{
 public static void main(String args[]){

   Magazine a = new Magazine("잡지1",60,"김씨","2018년 5월 3일");
   Magazine b = new Magazine("잡지2",80,"이씨","2017년 4월 6일");
   Book c = new Book("잡지3",50,"송씨");
   c.setTitle("잡지4");
   b.setPage(100);

   System.out.println(a.toString());
    System.out.println(b.toString());
    System.out.println(c.toString());
    System.out.println(a.getTitle());

}
}

//생성자 등을 사용해본 코드
