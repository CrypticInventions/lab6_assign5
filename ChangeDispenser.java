package lab6assign5_template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ChangeDispenser {

    //public wrapper
    //NOTE - your wrapper method does NOT have to be a void method.

    private static List makeChange(int amount, List<Integer> change,int denom [], int current) {
        //add your
        if (amount > 0) {
            int count = amount / denom[current];
            int newChange = amount - (denom[current] * count);
            change.add(count);
            makeChange(newChange, change, denom, current + 1);
        }
        return change;
    }
        //Hints:
        //Use a list to store the denomination values of coins in decreasing order.
	//Use a second list to store the names of coins in the same order as their denomination value list.
      
        //call the private recursive counterpart and pass the corresponding
        //   arguments.

        public static void count(List<Integer> change, int currentCoin,int currentName, String [] coinName){
                if(change.get(currentCoin) > 1) {
                    System.out.println(coinName[currentName + 1] + ": " + change.get(currentCoin));
                }
                else {
                    System.out.println(coinName[currentName] + ": " + change.get(currentCoin));
            }
                if(currentCoin < change.size() - 1) {
                    count(change, currentCoin    + 1,currentName + 2, coinName);
                }
        }


    //private recursive counterpart
    //NOTE - your recursive method does NOT have to be a void method.
    // example:
    // private static void makeChange(parameter list) {
    //   HintS -
    //       Your recursive method uses the coin value list and the coin name list. 
    //       In each call to the recursive method, the count of the first coin in the list 
    //          (coin in largest denomination value) is calculated and printed out. 
    //       Then the first coin is removed from the lists. 
    //       The remaining amount of money is calculated. 
    //       The coin lists and the remaining amount are passed to the next recursive call. 
    //       The recursion ends when no money is left.
    //}
    
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        //add your code to do the following:
        int [] denominators = {100,50,25,10,5,1};
        String [] coinName = {"Dollar", "Dollars", "HALF_DOLLAR", "HALF_DOLLARS", "QUARTER", "QUARTERS", "DIME","DIMES" ,"NICKLE", "NICKLES", "Penny", "Pennies"};
         List<Integer> change = new ArrayList<>();

        //prompt the user to enter the amount in dollars and cents
        //get the amount
        //convert the amount to all cents
        //call the public wrapper method
        System.out.println("Please enter the amount of dollars and cents.");
        int amount = (int)( in.nextDouble() * 100);
        change = makeChange(amount,change, denominators, 0);
        count(change,0,0,coinName);
        //count(change, 0 , name);
        //NOTE -
        // test your code using $2.91, $0.91, $0.78, $0
    }

}
