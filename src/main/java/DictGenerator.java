import java.io.*;

public class DictGenerator {

  public static void main(String[] args) throws Exception {
    PrintWriter qf = new PrintWriter ("question.txt","utf-8");
    PrintWriter af = new PrintWriter ("answer.txt","utf-8");

    for(int i=0;i<args.length;i++){
      BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(args[i]),"UTF-8"));
      String s;
      int line=0;

      while ((s=file.readLine())!=null){
        System.out.println(args[i]+line+":"+s);
        if(line%7==2){
          qf.println(s);
        } else if(line%7==3){
          af.println(s);
        }
        line++;
      }
    }
    qf.close();
    af.close();
  }
  
}