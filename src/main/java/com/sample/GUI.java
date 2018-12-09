package com.sample;
import javax.swing.*;
import java.util.ArrayList;

public class GUI {
	public static String askWindow(JFrame frame, String question, ArrayList variants) {
		Object[] options = {variants.get(0),
                            variants.get(1)};
                            
		int response = JOptionPane.showOptionDialog(frame,
                                             question,
                                             "Netflix",
                                             JOptionPane.YES_NO_OPTION,
                                             JOptionPane.QUESTION_MESSAGE,
                                             null,
                                             options,
                                             options[0]);
		
		switch (response) {
    		case JOptionPane.YES_OPTION: return (String)variants.get(0);
    		case JOptionPane.NO_OPTION: return (String)variants.get(1);
    		default: return "";
    	}
	}

	public static void recommendWindow(JFrame frame, String recommendation) {
		int n = JOptionPane.showConfirmDialog(null,
											recommendation,
											"Recommendation",
											JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void initWindow(JFrame frame) {
		int n = JOptionPane.showConfirmDialog(null,
											"Welcome to the program which can help you with dealing with the problem: \n"
											+ "                      \"What should I watch today on Netflix?\"\n "
											+ "Just answer the questions and the program will help you to chose." ,
											"Netflix",
											JOptionPane.PLAIN_MESSAGE);
	}
}
