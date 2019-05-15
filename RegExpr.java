package RegularExprs;

import java.util.regex.*;

public class RegExpr {

    public static void main(String[] args) {
        // regex
        // pattern embeded within .* finds only first occurance
        // "(pattern)" finds all occurences and counts.

        // pattern.matches

        // regex is not suitable for parsing html.
        // source : https://stackoverflow.com/questions/25851293/java-regex-why-matcher-group-does-not-work-without-matcher-find

        String text = "This is Kiran from sankir.com.";
        String pattern1 = ".*sankir.*";
        String pattern2 = ".*sanKir.*";

        boolean isMatch = Pattern.matches(pattern1, text);
        System.out.println("1.Pattern Matches ex: \nText is :" + text + "\nDoes the text contains pattern 'sankir'?  \nAnswer is : " + isMatch);

        isMatch = Pattern.matches(pattern2, text);
        System.out.println("Does the text contains pattern 'sanKir'? \nAnswer is : " + isMatch);

        //pattern compile and matches
        String textcm = "This is Kiran from sankir.com.";
        String pattern3 = ".*saNKir.*";

        Pattern patterncm = Pattern.compile(pattern3, Pattern.CASE_INSENSITIVE); // build pattern using compile utility
        Matcher matchercm = patterncm.matcher(textcm); //  use macther method - returns macther object
        boolean isMatched = matchercm.matches(); // use matches method - returns boolean
        System.out.println("\n2.Pattern Compile and Match ex: \nText is : " + textcm);
        System.out.println("Does the text contains pattern 'saNKir' - case insensitive ? \nAnswer is : " + isMatched);

        //    Pattern Split
        String textspl = "MynameisKiran. @It@is@My@Website and at my hosting site. It is viewed @from_mY_office.";
        String pattern4 = "@";

        System.out.println("\n3.Pattern Split ex: \nText is : " + textspl);
        System.out.println("Pattern to split is : " + pattern4);

        Pattern patternspl = Pattern.compile(pattern4, Pattern.CASE_INSENSITIVE);
        String[] myStrings = patternspl.split(textspl);
        for (String temp : myStrings) {
            System.out.println(temp);
        }
        System.out.println("Number of split strings: " + myStrings.length);

        // pattern find; start and end
        String textfind = "CCC AA PP AA KKK AAAA YY";    //String textfind = "CCC BB PP BB KKK BBBB YY";
        String pattern5 = "AA";

        System.out.println("\n4.Pattern Find and Start & End ex: \nText is : " + textfind);
        System.out.println("Pattern to find is : " + pattern5);

        Pattern patternfind = Pattern.compile(pattern5, Pattern.CASE_INSENSITIVE);
        Matcher matcherfind = patternfind.matcher(textfind);

        while (matcherfind.find()) {
            System.out.println("Pattern Start - End found at: " + matcherfind.start() + " - " + matcherfind.end());
        }
    }
}
