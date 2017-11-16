public class Crypto {
  public static void main(String[] args) {
    int key = 3;
    System.out.println("Encrypting with key = 3: myString = \"Hi, !There!; ()\" ");
    String myString = "Hi, !There!; ()";
    String cipher = encryptString(myString, key, 2);
    System.out.println("Result: cipher = " + cipher);
    System.out.println("***********************\n");

    System.out.println("Decrypting: cipher = " + cipher);
    String plain_text = decryptString(cipher, key);
    System.out.println("Result: plaintext = " + plain_text);
    System.out.println("***********************\n");
  } // end main method


  public static String normalizeText(String str) {
    String getRidOf = ".,:;’\"!?() ";

    for (int i = 0; i <= getRidOf.length() - 1; i++) {
      str = str.replace(getRidOf.substring(i, i + 1), "");
    }
    str = str.toUpperCase();
    return str;
  } // end normalizeText method


  public static String shiftAlphabet(int shift) {
    int start = 0;
    if (shift < 0) {
        start = (int) 'Z' + shift + 1;
    } else {
        start = 'A' + shift;
    }
    String result = "";
    char currChar = (char) start;
    for(; currChar <= 'Z'; ++currChar) {
        result = result + currChar;
    }
    if(result.length() < 26) {
        for(currChar = 'A'; result.length() < 26; ++currChar) {
            result = result + currChar;
        }
    }
    return result;
  } // end shiftAlphabet method


  public static String cesarify(String str, int shift_key) {
    String noShiftAlphabet = shiftAlphabet(0);
    String shiftedAlphabet = shiftAlphabet(shift_key);
    String new_str = "";

    for (int i = 0; i <= str.length() - 1; i++) {
      char charToReplace = str.charAt(i);
      int indexOfCharInNormalAlphabet = noShiftAlphabet.indexOf(charToReplace);
      char newChar = shiftedAlphabet.charAt(indexOfCharInNormalAlphabet);
      new_str += newChar;
    }
    return new_str;
  } // end cesarify method


  public static String groupfy(String str, int group_size) {
    // With a group_size == 2, "TESTE" must be converted to "TE ST Ex"
    if (group_size >= str.length()) {
      return str;
    } else {
      int x_to_complete = group_size - str.length() % group_size;

      while (x_to_complete > 0) {
        str += 'x';
        x_to_complete -= 1;
      }

      String grouped_str = "";
      for (int i = 0; i < str.length() - 1; i += group_size) {
        grouped_str += str.substring(i, i + group_size) + " ";
      }
      return grouped_str;
    }
  } // end groupfy method


  public static String encryptString(String str, int shift_key, int group_size) {
    str = normalizeText(str);
    str = cesarify(str, shift_key);
    str = groupfy(str, group_size);
    return str;
  } // end encryptString method


  public static String ungroupfy(String str) {
    int to_cut_from = str.indexOf('x');
    if (to_cut_from < 0) {
      str = normalizeText(str);
    } else {
      str = str.substring(0, to_cut_from);
    }
    str = normalizeText(str);
    return str;
  } // end ungroupfy method


  public static String decryptString(String str, int shift_key) {
    str = ungroupfy(str);
    str = cesarify(str, -shift_key);
    return str;
  } // end decryptString method

} // end Crypto class
