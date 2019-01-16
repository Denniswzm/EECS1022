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
        return "The answer to question 1 is b.";
    }

    /*
        Returns a string containing the correct answer to Questions 2
    */
    String answerQuestion2() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 2 is e.";
    }

    /*
        Returns a string containing the correct answer to Questions 3
    */
    String answerQuestion3() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 3 is d.";
    }

    /*
        Returns a string containing the correct answer to Questions 4
    */
    String answerQuestion4() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 4 is e.";
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
    Given an integer k and a set of integers s, remove k from the set s
    and add k + 1  to s;
    if k is not an element of s, the method leaves s unchanged.
    */
    void increment(int k, Set<Integer> s) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will will show the list l to be
            correctly updated.
         */
        boolean present = s.remove(k);
        if (present){
            s.add(k + 1);
        }
    }

    /*
    Given a string s and a list of strings l, return the position of the first occurrence of s in l;
    if s does not occur in l, return -1.
    */
    int getPos(String s, List<String> l) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        int result = -1;
        boolean found = false;
        for(int i = 0; i < l.size() && !found; i++)
            if (l.get(i).equals(s)){
                result = i;
                found = true;
            }
        return result;
    }

    /*
    Given a string s, return the first occurrence of a flight number in s;
    if there is no flight number in s, return the empty string.
    A flight number is a string of 2 upper case letters followed by 3 or 4 digits.
   */
    String findFlightNo(String s) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String regex = "[A-Z][A-Z][0-9][0-9][0-9][0-9]?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        String result = "";
        if (matcher.find()) {
            result = s.substring(matcher.start(),matcher.end());
        }
        return result;
    }

    /*
    Given a string s, return the set of all the product IDs in s;
    if there is no product ID in s, return the empty set.
    A product ID is string of 2 or more digits followed by 3 or more upper case letters,
    where the first digit can neither be 4 nor 8.
    */
    Set<String> findAllProductIDs(String s) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String regex = "[0-9&&[^48]][0-9]+[A-Z][A-Z][A-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        Set<String> bag = new TreeSet<String>();
        while (matcher.find()) {
            bag.add(s.substring(matcher.start(),matcher.end()));
        }
        return bag;
    }

    /*
    Given a list of strings l, return a map whose keys are all the distinct strings in l and such that
    the value of the map for each key is the position of the first occurrence of the key in the list l.
    If l is the empty list, return an empty map.
    */
    Map<String,Integer> firstOccurrences(List<String> l) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        Map<String,Integer> m = new HashMap<String,Integer>();
        for (int i = 0; i < l.size(); i++){
            String s = l.get(i);
            if (!m.containsKey(s)){
                m.put(s, i);
            }
        }
        return m;
    }

}
