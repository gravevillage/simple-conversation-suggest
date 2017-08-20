import java.io.*;
import java.util.*;
import java.io.*;
import org.apache.lucene.search.spell.LevensteinDistance;

class Distance implements Comparable<Distance> {
  private static LevensteinDistance ld = new LevensteinDistance();
  public int id;
  public String word;
  public float distance;

  public Distance(String word , ArrayList<String> dict, int id) {
    this.word = dict.get(id);
    this.id = id;
    this.distance = ld.getDistance(word,dict.get(id));
  }

  public int compareTo(Distance other) {
    if(distance > other.distance){
      return -1;
    } else {
      return 1;
    }
  }
}

public class Matcher {
  ArrayList<String> dict = new ArrayList<String>();

  static int rank_max=5;
  
  public Matcher(String dictpath) throws Exception {
    BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(dictpath),"UTF-8"));
    String s;
    while ((s=file.readLine())!=null){
      dict.add(s);
    }
  }
  
  public List<Distance> generateRank(String input) throws Exception {
    List<Distance> rank = new ArrayList<Distance>();
    
    for(int i=0;i<dict.size();i++){
      rank.add(new Distance(input, dict, i));
    }
    
    Collections.sort(rank);
    String[] result = new String[rank_max];
    
    for(int i=0;i<rank_max;i++){
      result[i] =  rank.get(i).word;
    }
    
    return rank;
  }
  
  public static void main(String[] args) {
    try {
      Matcher matcher = new Matcher("dict.txt");
      List<Distance> res = matcher.generateRank(args[0]);
      for(int i=0;i<rank_max;i++){
        System.out.println(""+res.get(i).id+":"+res.get(i).word);
      }
    } catch(Exception e){
      e.printStackTrace();
    }
  }

}