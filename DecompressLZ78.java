import java.util.ArrayList;
import java.util.Scanner;

public class DECOMP {
    public static void main(String[] args) {
        int NumOfTags;
        System.out.print("Enter numbers of tags: ");
        Scanner input = new Scanner(System.in);
        NumOfTags = input.nextInt();

        ArrayList<Integer> position = new ArrayList<Integer>();
        ArrayList<Character> NextSymbol = new ArrayList<Character>();
        char InputSymbol;
        int Inputposition;
        System.out.println("Enter < index , syembol >");
        for (int i = 0; i < NumOfTags; ++i) {
            Inputposition = input.nextInt();
            InputSymbol = input.next().charAt(0);
            position.add(Inputposition);
            NextSymbol.add(InputSymbol);
            System.out.println("Enter < index , syembol >");
        }
        // ---------------------------------------------From hence to above to get
        // Tags---------------------------------------------
        String Decompression = "";
        ArrayList<String> Dictionary = new ArrayList<String>();
        Dictionary.add("");// to starting counting from 1 in dictionary

        for (int i = 0; i < position.size(); i++) {

            if (position.get(i) == 0) {// hence if we decompress new char(alredy there isn't in dictionary because
                                       // position =0) so we add new char in dictionary and save
                                       // char in my string look :ABCD in each char we enter if condition
                Decompression = Decompression + NextSymbol.get(i);
                Dictionary.add(String.valueOf(NextSymbol.get(i)));
            } else {// hence if we decompress tag which position>0(means we need take string from my
                    // dictionary) look :ABCDA hence tag for last char is <1,null>
                Decompression = Decompression + Dictionary.get(position.get(i)) + NextSymbol.get(i);// hence we add in
                                                                                                    // old my string
                                                                                                    // position string
                                                                                                    // in dictionary
                                                                                                    // +next char
                String temp2 = Dictionary.get(position.get(i)) + NextSymbol.get(i);// temp2 hence save new string which
                                                                                   // add in my dictionary
                if (!Dictionary.contains(temp2))// if new string which save in temp2 exist in my dictionary look :ABCDA
                                                // we don't need save last char agin in my dictionary
                    Dictionary.add(temp2);
            }

        }
        System.out.print(Decompression.replace("null", ""));//because if Decompression has null 

    }
}
