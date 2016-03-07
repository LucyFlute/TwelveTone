import java.util.Scanner;


public class TwelveTone {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //Welcome and tester
    System.out.println("Welcome. A tone row is defined here as twelve single consecutive notes that do not repeat a pitch.\n");
    System.out.println("For example:");
    
    String[] toneRow = {"ax", "bx", "ax", "cx", "dx", "ex", "fx", "gx","bb", "ab", "gb", "bx", "eb", "db", "bx"};
    printSArray(toneRow);
    printArray(convertArray(toneRow));
    System.out.println(isThereToneRow(convertArray(toneRow)) + "\n");
    
    System.out.println("How many notes are in your row?");
    String input = in.nextLine();
    String[] yourToneRow = new String[Integer.parseInt(input)];
    
    System.out.println("Instructions: Enter your notes one at a time. Input two lowercase letters \n - one for the note name (a, b, c...) and then an x for natural or b for flat.");
    //creates String array from input
    for (int i = 0; i < yourToneRow.length; i++) {
      String input2 = in.nextLine();
      yourToneRow[i] = input2;
    }
    
    System.out.println("Your notes are:");
    printSArray(yourToneRow);
    
    if (isThereToneRow(convertArray(yourToneRow))) {
      System.out.println("There is a twelve-tone row!");
    } else {
      System.out.println("We could not find a twelve-tone row.");
    }
    
    
    
    
  }
  
  public static String[] inputNotes(String a) {
    String[] notes = new String[(a.length())/2];
    for (int i = 0; i < notes.length; i++) {
      notes[i] = String.valueOf(a.charAt(i*2)) + String.valueOf(a.charAt(i*2+1)); 
      // notes[i] = a.substring(i,i+1);
      //i++;
    }
    return notes;
  }
  
  
  public static boolean isThereToneRow(int[] a) {
    int[] currentRow = new int[12];
    for (int i = 0; i < a.length - 11; i++) {
      for (int j = 0; j < 12; j++) {
        currentRow[j] = a[j+i];
      }
      if (allToneRow(currentRow)) {
        return true;
      }
    }
    return false;
  }
  
  
  public static boolean allToneRow(int[] a) {
    if (a.length < 12) {
      return false;
    }
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 12; j++) {
        if (i != j) {
          if (a[i] == a[j]) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public static int[] convertArray(String[] s) {
    int[] result = new int[s.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = convertNote(s[i]);
    }
    return result;
  }
  
  public static int convertNote(String a) {
    int x = 0;
    if (a.equals("cx")) {
      x = 1;
    } else if (a.equals("db")) {
      x = 2;
    } else if (a.equals("dx")) {
      x = 3;
    } else if (a.equals("eb")) {
      x = 4;
    } else if (a.equals("ex")) {
      x = 5;
    } else if (a.equals("fx")) {
      x = 6;
    } else if (a.equals("gb")) {
      x = 7;
    } else if (a.equals("gx")) {
      x = 8;
    } else if (a.equals("ab")) {
      x = 9;
    } else if (a.equals("ax")) {
      x = 10;
    } else if (a.equals("bb")) {
      x = 11;
    } else if (a.equals("bx")) {
      x = 12;
    }
    return x;
  }
  
  public static void printArray(int[] x) {
    for (int i = 0; i < x.length; i++) {
      System.out.print(x[i] + " ");
    }
    System.out.println();
  }
  
  public static void printSArray(String[] x) {
    for (int i = 0; i < x.length; i++) {
      System.out.print(x[i] + " ");
    }
    System.out.println();
  }
  
  
}

