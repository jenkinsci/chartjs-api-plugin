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
package io.jenkins.plugins.chartjs;

import hudson.Extension;
import hudson.model.PageDecorator;

@Extension
public class Chartjs extends PageDecorator {

    public static String getShortName(String buildName, int buildNumber) {
        if (buildName.length() < 38) {
            return buildName + ":" + buildNumber;
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
            return removeEverySecondNonDigit(buildName) + ":" + buildNumber;
        }
    }

    public static String removeEverySecondNonDigit(String buildName) {
        StringBuilder bns = new StringBuilder();
        int nonDigits = 0;
        for (int x = 0; x < buildName.length(); x++) {
            if (!Character.isDigit(buildName.charAt(x))) {
                nonDigits++;
                if (nonDigits % 2 == 0) {
                    //add every second non-digit
                    bns.append(buildName.charAt(x));
                }
            } else {
                //add all digits
                bns.append(buildName.charAt(x));
                //reset counter, so next char will be not included
                nonDigits = 0;
            }
        }
        return bns.toString();
    }

    public static String removeNonVowels(String buildName) {
        StringBuilder bns = new StringBuilder();
        for (int x = 0; x < buildName.length(); x++) {
            if ("aeiou".contains("" + buildName.charAt(x)) || Character.isDigit(buildName.charAt(x))) {
                bns.append(buildName.charAt(x));
            }
        }
        return bns.toString();

    }

    public static String removeEveryNonDigitNoLetter(String buildName) {
        StringBuilder bns = new StringBuilder();
        for (int x = 0; x < buildName.length(); x++) {
            if (Character.isLetterOrDigit(buildName.charAt(x))) {
                bns.append(buildName.charAt(x));
            }
        }
        return bns.toString();
    }

}
