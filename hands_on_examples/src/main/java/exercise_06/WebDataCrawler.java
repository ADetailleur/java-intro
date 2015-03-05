package exercise_06;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import exercise_06.acquirer.WebsiteWordListAcquirer;

class WebDataCrawler {

  private static WebsiteWordListAcquirer websiteWordListAcquirer = new WebsiteWordListAcquirer();

  public static void main(String[] args) {

    List<String> cnnWordList = websiteWordListAcquirer.getWordListFrom("http://www.cnn.com/");
    System.out.println("'CNN' words count: " + cnnWordList.size());

    List<String> guardianWordList = websiteWordListAcquirer.getWordListFrom("http://www.theguardian.com/");
    System.out.println("'The Guardian' words count: " + guardianWordList.size());

    List<String> independentWordList = websiteWordListAcquirer.getWordListFrom("http://www.independent.co.uk/");
    System.out.println("'The Independent' words count: " + independentWordList.size());

    /*
     * Perform tasks on the list of words we have collected from websites:
     * 
     * - Create a new HashMap which has the word (String) as a key, and a number (Integer) as value, like this: 
     * 
     *   Map<String, Integer> distributionMap = new HashMap<String, Integer>();
     * 
     * We can now count how many times words occur.
     */
    

    Map<String, Integer> distributionMap = new HashMap<String, Integer>();

    // Add the word lists from CNN, The Guardian and The Independent to the
    // distribution map.


    
    
    
    
    
    
    
    
    
    
    
    
    
    TreeMap<String, Integer> sortedMap = sortMapByOccurrences(distributionMap);
    System.out.println(sortedMap);

    // Now only display values with an occurrence of five or more.

    
    
    
    
    // If you convert all words to lower case before adding to the distribution map, would that make the distribution
    // more interesting?
    
    
    
    
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  private static TreeMap<String, Integer> sortMapByOccurrences(
      Map<String, Integer> map) {
    TreeMap<String, Integer> result = new TreeMap<String, Integer>(
        new ValueComparator(map));
    result.putAll(map);
    return result;
  }

  static class ValueComparator implements Comparator<String> {

    private Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
      this.map = map;
    }

    @Override
    public int compare(String o1, String o2) {
      Integer v1 = map.get(o1);
      Integer v2 = map.get(o2);

      if (v1 <= v2) {
        return 1;
      } else {
        return -1;
      }
    }

  }

}