// Solutions  EECS1022 labtest2a

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
    String answerQestion1() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 1 is c.";
    }

    /*
        Returns a string containing the correct answer to Questions 2
    */
    String answerQestion2() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 2 is d.";
    }

    /*
        Returns a string containing the correct answer to Questions 3
    */
    String answerQestion3() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 3 is c.";
    }

    /*
        Returns a string containing the correct answer to Questions 4
    */
    String answerQestion4() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 4 is a.";  // b is also correct
    }

    /*
        Returns a string containing the correct answer to Questions 5
    */
    String answerQestion5() {
        /*
            Your task is to edit the returned string to replace the "?" by the
            correct answer to the question, "a", "b", "c", "d", or "e".
         */
        return "The answer to question 5 is e.";
    }


    /*
        Given the age of the customer,
        return the ticket price.
     */
    double ticketPrice(int age) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        double result = 0.0;
        if (age <= 12 || age >= 65){
            result = 8.5;
        }
        else
        {
            result = 12.5;
        }
        return result;
    }

    /*
          Given a positive integer n,
          return the sum of the reciprocals of all positive integers less than or equal to n.
       */
    double sumReciprocals(int n) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        double result = 0.0;
        for (int i = 1; i <= n; i++){
            result += 1.0 / i;
        }
        return result;
    }

    /*
            Given a natural number n and a string s,
            return a string that contains s repeated n times.
         */
    String makeRepetitions(int n, String s) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String result = "";
        for (int i = 1; i <= n; i++){
            result = result + s;
        }
        return result;
    }

    /*
        Given a string s1 and a string s2,
        find the first occurrence of s2 as a substring in s1 and
        return s1 with all characters before the first occurrence of s2 removed;
        if s2 does not occur as a substring in s1, return s1 unchanged.
     */
    String removePrefix(String s1, String s2) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String result = s1;
        int pos = s1.indexOf(s2);
        if (pos >= 0){
            result = s1.substring(pos);
        }
        return  result;
    }

    /*
     Given a string s1 and a string s2,
     return a string containing the positions of all occurrences s2 in s1 separated by a comma.
  */
    String allPos(String s1, String s2) {
        /*
            Your task is to implement this method,
            so that running UtilitiesTester.java will output the expected value to console.
         */
        String result = "";
        int pos = s1.indexOf(s2);
        if (pos >= 0){
            result = result + pos;
        }
        pos = s1.indexOf(s2, pos+1);
        while (pos >= 0){
            result = result + "," + pos;
            pos = s1.indexOf(s2, pos+1);

        }
        return result;
    }

}
