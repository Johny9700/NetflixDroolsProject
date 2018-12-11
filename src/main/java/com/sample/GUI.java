package com.sample;

import javax.swing.*;
import java.util.ArrayList;

public class GUI {
    public static String askWindow(JFrame frame, String question, ArrayList<String> variants) {
        Object[] options = { variants.get(0), variants.get(1) };

        int response = JOptionPane.showOptionDialog(frame, question, "Netflix", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (response) {
        case JOptionPane.YES_OPTION:
            return (String) variants.get(0);
        case JOptionPane.NO_OPTION:
            return (String) variants.get(1);
        default:
            return "";
        }
    }

    public static void recommendWindow(JFrame frame, String recommendation) {
        ImageIcon icon = new ImageIcon("src/main/resources/img/film_icon_48.png");
        JOptionPane.showConfirmDialog(null, recommendation, "Recommendation", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon);
    }

    public static boolean initWindow(JFrame frame) {
        ImageIcon icon = new ImageIcon();
        int response = JOptionPane.showConfirmDialog(null,
                "Welcome to the program which will help you dealing with the problem: \n"
                        + "                             \"What should I watch today on Netflix?\"\n "
                        + "       Just answer the questions and the program will help you to choose.\n" + "\n"
                        + "               Inf132212 - Jan Dudziak                  Inf132235 - Dariusz Grynia",
                "Netflix", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
        if (response == JOptionPane.CLOSED_OPTION)
            return false;
        return true;
    }
}
