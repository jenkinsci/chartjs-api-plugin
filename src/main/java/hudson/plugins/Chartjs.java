/*
 * The MIT License
 *
 * Copyright 2016 user.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins;

import hudson.Extension;
import hudson.model.PageDecorator;

@Extension
public class Chartjs extends PageDecorator {

    public static String getShortName(String buildName, int buildNumber) {
        if (buildName.length() < 38) {
            return buildName + ":" +Integer.toString(buildNumber);
        } else {
//            System.out.println(buildName.length());
//            System.out.println(removeEveryNonDigitNoLetter(buildName).length());
//            System.out.println(removeNonVowels(buildName).length());
//            System.out.println(removeEverySecondNonDigit(buildName).length());
//            System.out.println(removeParts(buildName).length());
//            System.out.println(buildName);
//            System.out.println(removeEveryNonDigitNoLetter(buildName));
//            System.out.println(removeNonVowels(buildName));
//            System.out.println(removeEverySecondNonDigit(buildName));
//            System.out.println(removeParts(buildName));
            return removeEverySecondNonDigit(buildName) + ":" +Integer.toString(buildNumber);
        }
    }

    public static String removeEverySecondNonDigit(String buildName) {
        String bns = "";
        int nonDigits = 0;
        for (int x = 0; x < buildName.length(); x++) {
            if (!Character.isDigit(buildName.charAt(x))) {
                nonDigits++;
                if (nonDigits % 2 == 0) {
                    //add every second nondigit
                    bns = bns + buildName.charAt(x);
                }
            } else {
                //add all digits
                bns = bns + buildName.charAt(x);
                //reset counter, so next char will be not included
                nonDigits = 0;
            }
        }
        return bns;
    }

    public static String removeNonVowels(String buildName) {
        String bns = "";
        for (int x = 0; x < buildName.length(); x++) {
            if ("aeiou".contains("" + buildName.charAt(x)) || Character.isDigit(buildName.charAt(x))) {
                bns = bns + buildName.charAt(x);
            }
        }
        return bns;

    }

    public static String removeEveryNonDigitNoLetter(String buildName) {
        String bns = "";
        for (int x = 0; x < buildName.length(); x++) {
            if (Character.isLetterOrDigit(buildName.charAt(x))) {
                bns = bns + buildName.charAt(x);
            }
        }
        return bns;
    }

    private static String removeParts(String buildName) {
        String ss = buildName.substring(0, 12) + ".." + buildName.substring(buildName.length() / 2 - 6, buildName.length() / 2 + 6) + ".." + buildName.substring(buildName.length() - 12, buildName.length());
        //may make unclear what build it actually is
        return ss;
    }

}
