// class Solution {
//     private static final int NUMBER_LETTERS_ALPHABET = 26;

//     public boolean checkInclusion(String s1, String s2) {
//         if (s1.length() > s2.length()) {
//             return false;
//         }

//         int[] letterFrequencyS1 = new int[NUMBER_LETTERS_ALPHABET];
//         int[] letterFrequencyS2 = new int[NUMBER_LETTERS_ALPHABET];
//         for (int i = 0; i < s1.length(); i++) {
//             letterFrequencyS1[s1.charAt(i) - 'a']++;
//             letterFrequencyS2[s2.charAt(i) - 'a']++;
//         }

//         if (Arrays.equals(letterFrequencyS1, letterFrequencyS2)) {
//             return true;
//         }

//         for (int i = s1.length(); i < s2.length(); i++) {
//             letterFrequencyS2[s2.charAt(i - s1.length()) - 'a']--;
//             letterFrequencyS2[s2.charAt(i) - 'a']++;
//             if (Arrays.equals(letterFrequencyS1, letterFrequencyS2)) {
//                 return true;
//             }
//         }

//         return false;
//     }
// }
// import java.util.Arrays;

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int[] patternHash = new int[26];
//         int[] windowHash = new int[26];
//         int patternLength = s1.length();
//         int windowLength = s2.length();
//         int left = 0;
//         int right = 0;

//         if (windowLength < patternLength) {
//             return false;
//         }

//         while (right < patternLength) {
//             patternHash[s1.charAt(right) - 'a']++;
//             windowHash[s2.charAt(right) - 'a']++;
//             right++;
//         }

//         right--;

//         while (right < windowLength) {
//             if (Arrays.equals(patternHash, windowHash)) {
//                 return true;
//             }

//             right++;

//             if (right != windowLength) {
//                 windowHash[s2.charAt(right) - 'a']++;
//             }

//             windowHash[s2.charAt(left) - 'a']--;
//             left++;
//         }

//         return false;
//     }
// }
// class Solution {
//     private static final int lettersCount = 'z' - 'a' + 1;

//     public boolean checkInclusion(String s1, String s2) {
//         if (s1.length() > s2.length()) {
//             return false;
//         }

//         int[] s1LetterCount = new int[lettersCount];
//         int[] s2LetterCount = new int[lettersCount];

//         for (int i = 0; i < s1.length(); i++) {
//             s1LetterCount[getLetterNumber(s1.charAt(i))]++;
//             s2LetterCount[getLetterNumber(s2.charAt(i))]++;
//         }

//         if (Arrays.equals(s1LetterCount, s2LetterCount)) {
//             return true;
//         }

//         for (int i = s1.length(); i < s2.length(); i++) {
//             s2LetterCount[getLetterNumber(s2.charAt(i))]++;
//             s2LetterCount[getLetterNumber(s2.charAt(i - s1.length()))]--;

//             if (Arrays.equals(s1LetterCount, s2LetterCount)) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     private int getLetterNumber(char letter) {
//         return letter - 'a';
//     }
// }
class Solution {
    static {
        for (int i = 0; i < 200; i++) {
            checkInclusion("a", "");
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        final int len1 = s1.length();
        final int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        final int[] counters = new int[26];
        for (int i = 0; i < len1; i++) {
            counters[s1.charAt(i) - 'a']++;
            counters[s2.charAt(i) - 'a']--;
        }

        int deltaCount = 0;
        for (int i = 0; i < 26; i++) {
            if (counters[i] < 0) {
                deltaCount++;
            }
        }
        if (deltaCount == 0) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            final int removeC = s2.charAt(i - len1) - 'a';
            final int addC = s2.charAt(i) - 'a';

            counters[removeC]++;
            if (counters[removeC] == 0) {
                deltaCount--;
            }

            counters[addC]--;
            if (counters[addC] == -1) {
                deltaCount++;
            }

            if (deltaCount == 0) {
                return true;
            }
        }
        return false;
    }
    
}
// import java.util.Arrays;

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         // Если s1 длиннее s2, то перестановка s1 не может быть подстрокой s2
//         if (s1.length() > s2.length()) {
//             return false;
//         }

//         // Преобразуем строки в массивы символов
//         char[] ch1 = s1.toCharArray();
//         char[] ch2 = s2.toCharArray();

//         // Создаем массивы для частот символов
//         int[] sig1 = new int[26];
//         int[] sig2 = new int[26];

//         // Заполняем массив частот символов для s1
//         for (char ch : ch1) {
//             sig1[ch - 'a'] += 1;
//         }

//         // Начинаем скользящее окно по s2
//         for (int i = 0, start = 0; i < ch2.length; i++) {
//             // Добавляем текущий символ в окно
//             sig2[ch2[i] - 'a']++;
            
//             // Если размер окна равен длине s1, проверяем массивы частот
//             if (i - start + 1 == ch1.length) {
//                 if (Arrays.equals(sig1, sig2)) {
//                     return true;
//                 }
//                 // Убираем первый символ из окна
//                 sig2[ch2[start] - 'a']--;
//                 start++;
//             }
//         }
        
//         // Если ни одно окно не совпало, возвращаем false
//         return false;
//     }
// }

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         char[] ch1 = s1.toCharArray();
//         char[] ch2 = s2.toCharArray();
//         int[] sig1 = new int[26];
//         int[] sig2 = new int[26];
//         for (char ch : ch1) {
//             sig1[ch - 'a'] += 1;
//         }
//         for (int i = 0, start = 0; i < ch2.length; i++) {
//             sig2[ch2[i] - 'a']++;
//             if (i - start + 1 == ch1.length) {
//                 if (Arrays.equals(sig1, sig2)) {
//                     return true;
//                 }
//                 sig2[ch2[start] - 'a']--;
//                 start++;
//             }
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         char[] str1 = s1.toCharArray();
//         char[] str2 = s2.toCharArray();
//         int alphLength='z'-'a'+1;
//         int[] chars1 = new int[alphLength];
//         int[] chars2 = new int[alphLength];
//         for (char ch : str1) {
//             chars1[ch - 'a']++;
//         }
//         for (int i = 0, start = 0; i < str2.length; i++) {
//             chars2[str2[i] - 'a']++;
//             if (i - start + 1 == str1.length) {
//                 if (Arrays.equals(chars1, chars2)) {
//                     return true;
//                 }
//                 chars2[str2[start] - 'a']--;
//                 start++;
//             }
//         }
//         return false;
//     }
// }
// class Solution {
//     static final int LETTERS = 26;

//     public boolean checkInclusion(String s1, String s2) {
//         int[] s1Freq = new int[LETTERS];
//         int[] s2Freq = new int[LETTERS];

//         for (int i = 0; i < s1.length(); i++) {
//             s1Freq[s1.charAt(i) - 'a']++;
//         }
//         for (int i = 0; i < s2.length(); i++) {
//             s2Freq[s2.charAt(i) - 'a']++;

//             if (i >= s1.length()) {
//                 s2Freq[s2.charAt(i - s1.length()) - 'a']--;
//             }

//             if (Arrays.equals(s1Freq, s2Freq)) {
//                 System.out.println(Arrays.equals(s1Freq, s2Freq));
//                 return true;
//             }
//         }
//         return false;
//     }
// }
// class Solution {
//     static final int LETTERS = 26;

//     public boolean checkInclusion(String s1, String s2) {
//         int[] s1Freq = new int[LETTERS];
//         int[] s2Freq = new int[LETTERS];

//         for (int i = 0; i < s1.length(); i++) {
//             s1Freq[s1.charAt(i) - 'a']++;
//         }
//         for (int i = 0; i < s2.length(); i++) {
//             s2Freq[s2.charAt(i) - 'a']++;

//             if (i >= s1.length()) {
//                 s2Freq[s2.charAt(i - s1.length()) - 'a']--;
//             }

//             if (Arrays.equals(s1Freq, s2Freq)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         if (s1.length() > s2.length()) {
//             return false;
//         }

//         int[] count = new int[26];

//         for (int i = 0; i < s1.length(); i++) {
//             count[s1.charAt(i) - 'a']++;
//             count[s2.charAt(i) - 'a']--;
//         }

//         if (allZeroes(count)) {
//             return true;
//         }

//         for (int i = s1.length(); i < s2.length(); i++) {
//             count[s2.charAt(i) - 'a']--;
//             count[s2.charAt(i - s1.length()) - 'a']++;

//             if (allZeroes(count)) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     private boolean allZeroes(int[] count) {
//         for (int i = 0; i < count.length; i++) {
//             if (count[i] != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
// class Solution {
//     private static final int LETTER_COUNT = 26;

//     public boolean checkInclusion(String s1, String s2) {
//         if (s1.length() > s2.length()) {
//             return false;
//         }

//         int[] count = new int[LETTER_COUNT];

//         for (int i = 0; i < s1.length(); i++) {
//             count[s1.charAt(i) - 'a']++;
//             count[s2.charAt(i) - 'a']--;
//         }

//         if (allZeroes(count)) {
//             return true;
//         }

//         for (int i = s1.length(); i < s2.length(); i++) {
//             count[s2.charAt(i) - 'a']--;
//             count[s2.charAt(i - s1.length()) - 'a']++;

//             if (allZeroes(count)) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     private boolean allZeroes(int[] count) {
//         for (int i = 0; i < count.length; i++) {
//             if (count[i] != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         final int A_IN_LOWERCASE = 'a';
//         final int NUMBER_LETTERS_IN_THE_ENGLISH_ALPHABET = 26;

//         int lengthString1 = s1.length();
//         int lengthString2 = s2.length();

//         if (lengthString1 > lengthString2) {
//             return false;
//         }

//         int[] countChars = new int[NUMBER_LETTERS_IN_THE_ENGLISH_ALPHABET];
//         for (char currentChar : s1.toCharArray()) {
//             countChars[currentChar - A_IN_LOWERCASE]++;
//         }

//         int startIndex = 0;
//         int endIndex = 0;

//         while (endIndex < lengthString2) {
//             countChars[s2.charAt(endIndex) - A_IN_LOWERCASE]--;

//             while (countChars[s2.charAt(endIndex) - A_IN_LOWERCASE] < 0) {
//                 countChars[s2.charAt(startIndex) - A_IN_LOWERCASE]++;
//                 startIndex++;
//             }

//             if (endIndex - startIndex == lengthString1 - 1) {
//                 return true;
//             }
//             endIndex++;
//         }
//         return false;
//     }
// }