import java.io.*;
import java.util.*;
import java.io.*;
import org.apache.lucene.search.spell.LuceneLevenshteinDistance;

class Distance implements Comparable<Distance> {
  public int id;
  public String word;
  public float distance;

  public Distance(String word , String[] dict, int id) {
    this.word = word;
    this.id = id;
    this.distance = ld.getDistance(word,dict[id]);
  }

  public int compareTo(Distance other) {
    if(distance > other.distance){
      return 1;
    } else {
      return -1;
    }
  }
}

public class Matcher {
  ArrayList<String> dict = new ArrayList<String>();
  LuceneLevenshteinDistance ld = new LuceneLevenshteinDistance();
  static int rank_max=5;
  
  public Matcher(String dictpath) throws Exception {
    int c = 0;
    BufferedInputStream file = new BufferedInputStream(new FileInputStream(new File(dictpath)));

    while (file.available()!=0){
      dict.add(c, file.readLine());
      c++;
    }
  }
  
  public String[] generateRank(String input) throws Exception {
    List<Distance> rank = new List<Distance>();
    
    for(int i=0;i<dict.size();i++){
      rank.add(new Distance(input, dict,i));
    }
    
    Collections.sort(rank);
    String[] result = new String[rank_max];
    
    for(int i=0;i<rank_max;i++){
      result[i] =  rank.get(i).word;
    }
    
    return result;
  }
  
  public static void main(String args){
    Matcher matcher = new Matcher("dict.txt");
    String[] res = matcher.generateRank(args[0]);
    for(int i=0;i<res.length;i++){
      System.out.print(""+i+"\t"+res[i]);
    }
  }

}