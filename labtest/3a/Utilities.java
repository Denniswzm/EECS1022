import java.util.*;
import java.util.regex.*;

public class Utilities
{
    /*
        No attributes.
        Do not add any attributes.
     */

    /*
        Default constructor.
        Do not change it.
     */
    Utilities() {

    }

    /*
        Returns a string containing the correct answer to Questions 1
    */
    String answerQuestion1() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 1 is c.";
    }

    /*
        Returns a string containing the correct answer to Questions 2
    */
    String answerQuestion2() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 2 is d.";
    }

    /*
        Returns a string containing the correct answer to Questions 3
    */
    String answerQuestion3() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 3 is c.";
    }

    /*
        Returns a string containing the correct answer to Questions 4
    */
    String answerQuestion4() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 4 is d.";
    }

    /*
        Returns a string containing the correct answer to Questions 5
    */
    String answerQuestion5() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 5 is e.";
    }

    /*
    Given a string s and a list of Strings l, remove the first occurrence of s in l
    and add s at the beginning of l;
    if s does not occur in l, the method leaves l unchanged.
    */
    void moveToFront(String s, List<String> l) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will will show the list l to be
            correctly updated.
         */
        boolean present = l.remove(s);
        if (present){
            l.add(0,s);
        }
    }

    /*
    Given an integer k and a list of integers l, return the position of the last occurrence of k in l;
    if k does not occur in l, return -1.
    */
    int getPos(int k, List<Integer> l) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        int result = -1;
        for(int i = 0; i < l.size(); i++)
            if (l.get(i) == k){
                result = i;
            }
        return result;
    }

    /*
    Given a string s, return the position of the first occurrence of a license plate number in s;
    if there is no license plate number in s, return -1.
    A license plate number is a string of 3 or 4 upper case letters followed by 3 digits.
   */
    int findPlateNo(String s) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String regex = "[A-Z][A-Z][A-Z][A-Z]?[0-9][0-9][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        int result = -1;
        if (matcher.find()) {
            result = matcher.start();
        }
        return result;
    }

    /*
    Given a string s, return a list of all the product IDs in s;
    if there is no product ID in s, return an empty list.
    A product ID is a string of 3 or more upper case letters followed by 2 or more digits,
    where the first letter can neither be M nor X.
    */
    List<String> findAllProductIDs(String s) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String regex = "[A-Z&&[^MX]][A-Z][A-Z]+[0-9][0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        List<String> l = new ArrayList<String>();
        while (matcher.find()) {
            l.add(s.substring(matcher.start(),matcher.end()));
        }
        return l;
    }

    /*
    Given a list of strings l, return a map whose keys are all the distinct strings in l and such that
    the value of the map for each key is the number of times the key occurs in the list l.
    If l is the empty list, return an empty map.
    */
    Map<String,Integer> countOccurrences(List<String> l) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        Map<String,Integer> m = new HashMap<String,Integer>();
        for (String s : l){
            if (m.containsKey(s)){
                m.put(s, m.get(s)+1);
            }
            else
            {
                m.put(s,1);
            }
        }
        return m;
    }

}
