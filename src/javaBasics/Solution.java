package javaBasics;

import challenges.staticblockinitialization.ClassWithStaticBlock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public String solution(String S) {
        // list of files stored
        ArrayList<String> files = new ArrayList<String>();
        try {
            // read the file and save in arryaList
            File myFile = new File("./Tests data/test-input-01.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                files.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution mysol = new Solution();
    }
}


