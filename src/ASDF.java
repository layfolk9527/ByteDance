public class ASDF {
  public static void main(String []args){
      char c='a';
      int b=3;
      char c1= Character.highSurrogate(b);
      char d=1;
      String s= String.valueOf(c+d);
      System.out.print(s);
  }

}
