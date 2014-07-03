package com.grassllama.bluegrey.utils;

import com.grassllama.bluegrey.model.Board;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Caleb
 */
public class TextBasedBoardBuilder {

    public Board createBoard(String filename) {
        return new Board(getIntegerBoard(filename));
    }

    private List<List<Integer>> getIntegerBoard(String filename) {
        File file = new File(filename);
        BufferedReader reader = null;
        List<List<Integer>> intBoard = new ArrayList<List<Integer>>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String text;

            while ((text = reader.readLine()) != null) {
                List<Integer> row = new ArrayList<Integer>();
                for (char c : text.toCharArray()) {
                    row.add(Character.getNumericValue(c));
                }
                intBoard.add(0, row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return intBoard;
    }

}
