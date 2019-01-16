// solutions EECS 1022 labtest2b

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
        return "The answer to question 1 is b.";  // e should also be accepted
    }

    /*
        Returns a string containing the correct answer to Questions 2
    */
    String answerQuestion2() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 2 is c.";
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
        return "The answer to question 4 is c.";
    }

    /*
        Returns a string containing the correct answer to Questions 5
    */
    String answerQuestion5() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 5 is a.";
    }


    /*
    Given the age of the customer and whether he/she is a student,
    return the ticket price.
 */
    double ticketPrice(int age, boolean student) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        double result = 0.0;
        if (age <= 10 || student){
            result = 8.5;
        }
        else
        {
            result = 12.5;
        }
        return result;
    }

    /*
      Given a natural number n,
      return the sum of the squares of all natural numbers less than or equal to n.
   */
    int sumSquares(int n) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        int result = 0;
        for (int i = 1; i <= n; i++){
            result += i * i;
        }
        return result;
    }

    /*
        Given a string s,
        return the string with all characters at odd positions deleted.
     */
    String deleteOddCharacters(String s) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String result = "";
        for (int i = 0; i < s.length(); i = i + 2){
            result = result + s.charAt(i);
        }
        return result;
    }

    /*
        Given a string s1 and a string s2,
        find the first occurrence of s2 as a substring in s1 and
        return s1 with all characters after the first occurrence of s2 removed;
        if s2 does not occur as a substring in s1, return s1 unchanged.
     */
    String removeSuffix(String s1, String s2) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String result = s1;
        int pos = s1.indexOf(s2);
        if (pos >= 0){
            result = s1.substring(0, pos + s2.length());
            // result = s1.substring(pos + s2.length(),s1.length()); this returns the prefix as in sample test output given
        }
        return  result;
    }

    /*
    Given a string s, a string t, a string r1, and a string r2,
    return s with every odd occurrence of t replaced by r1 and
    every even occurrence of t replaced by r2.
 */
    String replaceOddEven(String s, String t, String r1, String r2) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String result = s;
        int pos = result.indexOf(t);
        int count = 1;
        while (pos >= 0){
            String repl;
            if (count % 2 == 1) {
                repl = r1;
            }
            else
            {
                repl = r2;
            }
            result = result.substring(0,pos) + repl + result.substring(pos + t.length());
            pos = result.indexOf(t);
            count++;
        }
        return  result;
    }
}
