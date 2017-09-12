package cs2050.hw1;

/**
Matt Coover
CS2050
HW1
User Login
This program asks a user to create a login based on defined standards. If the
login is valid, the user is notified. If the login is invalid, the user is 
told why, and asked to try again.
 * @author mattc
 */

import java.util.Scanner;
import java.lang.Character;
        
public class CS2050HW1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        
        boolean tryAgain = true;
        boolean checkCase;
        boolean length;
        boolean digit;
        boolean hashtag;
        boolean validity;
        
        
        do {
            greetUser();
            
            CS2050HW1 input = new CS2050HW1();
            
            String username = scnr.nextLine();
            
            input.readUser(username);
            
            checkCase = input.caseOk(username);
            
            length = input.lengthOk(username);
            
            digit = input.digitOk(username);
            
            hashtag = input.hashtagOk(username);
            
            validity = input.validOk(checkCase, length, digit, hashtag);
            
            input.printUser(username, checkCase, length, digit, hashtag, validity );
            
            System.out.println ("Try another login? Enter Y or N");
            String yn = scnr.nextLine();
            
            if (yn.equals ('y'))
                tryAgain = true;
               
            else if (yn.equals('n'))
                tryAgain = false;
            
        } while (tryAgain == true);
    }

    /**
     *
     */
    public static void greetUser() {
        System.out.println("This program will evaluate your chosen username "
                + "and check for the following criteria: \n"
                + "Username is at least 5 characters long. \n"
                + "Username contains one uppercase and one lowercase letter \n"
                + "Username contains one digit (0-9) \n"
                + "Username contains one of the following special characters:"
                + "! @ # $ \n"
                + "Please enter username now :)");
    }

    public String readUser(String newUsername) {
        
        Scanner scnr = new Scanner(System.in);
        String username = newUsername;
        return username;      
    }

    public boolean caseOk(String hasCase) {
        int x = 0;
        int y = 0;
        boolean tf = false;
        
        for (int i = 0; i < hasCase.length(); i++) {
            if (Character.isUpperCase(hasCase.charAt(i)))
                x++;
            if (Character.isLowerCase(hasCase.charAt(i)))
                y++;
        }
        if (x < 1 || y < 1)
            tf = false;
        else tf = true;
        
        return tf;
    }

    public boolean lengthOk(String lengthTest) {
        boolean length = lengthTest.length() >= 5;
        return length;
    }
    
    public boolean digitOk(String num) {
        char x;
        int dig = 0;
        boolean tf = false;
        
        for (int i = 0; i < num.length(); i++) {
            x = num.charAt(i);
            if (Character.isDigit(x)) {
                dig ++;
                if (dig < 1) {
                    tf = false;
                } else tf = true;
            }
        }
        return tf;
    }

    public boolean hashtagOk(String hashtag) {
        boolean tf = false;
        char x;
        
        for (int i = 0; i < hashtag.length(); i++) {
            x = hashtag.charAt(i);
            if (x == '!' || x == '@' || x == '#' || x == '$')
                tf = true;
        }
        return tf;
    }
    
    public boolean validOk(boolean checkCase, boolean length, boolean digit, boolean hashtag) {
        if (!checkCase || !length || !digit || !hashtag) {
        return false;
    } else
        return true;
    }

    public void printUser(String username, boolean checkCase, boolean length, 
                            boolean digit, boolean hashtag, boolean validity) {
        if(!validity){
            System.out.println(username + " is Invalid");
        
         if(!checkCase)
            System.out.println("Must include one Uppercase and one Lowercase"
                    + " letter");
         
         if(!length)
            System.out.println("Must be a minimum of 5 characters in length");
         
         if(!digit)
            System.out.println("Must include at least one digit (0-9)");
         
         if(!hashtag)
            System.out.println("Must include one of the following: ! @ # $");
         } else {
             System.out.println("Success! input " + username + " is Valid");
         }

    }

    public void addToReport(String username, boolean checkCase, boolean length, 
                            boolean digit, boolean hashtag, boolean validity) {
        if(!validity){
            System.out.println(username + "is Invalid");
        }
         if(!checkCase){
            System.out.println("Must include one Uppercase and one Lowercase"
                    + " letter");
         
         if(!length)
            System.out.println("Must be a minimum of 5 characters in length");
         
         if(!digit)
            System.out.println("Must include at least one digit (0-9)");
         
         if(!hashtag)
            System.out.println("Must include one of the following: ! @ # $");
         } else {
             System.out.println("Success! input " + username + " is Valid");
         }
    }

    public void printReport() {
    }
    
}
