package com.sample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */



public class DroolsTest{
	
	static JFrame frame;
	static JLabel textLabel;
	static JButton YesButton;
	static JButton NoButton;
	static JPanel panel;
	static int width = 800;
	static int height = 400;
	
	
	private static void createWindow() {
    	frame = new JFrame("Netflix"); 
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setPreferredSize(new Dimension(width, height));
    	
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);    	
    	
    	frame.setLayout(null);
    	frame.setBackground(Color.WHITE);
    	frame.getContentPane().setBackground(Color.WHITE);
    	
    	textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER); 
    	textLabel.setBounds(200, 150, 300, 40);
    	textLabel.setFont(new Font(textLabel.getFont().getName(), textLabel.getFont().getStyle(), 20));
    	panel.add(textLabel);
    	
    	//------------BUTTONS-------------
    	YesButton = new JButton("Yes");
    	YesButton.setBounds(200, 300, 80, 40);
    	YesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println("YES");
            }
    	});
    	
    	//frame.add(YesButton, BorderLayout.EAST);
    	panel.add(YesButton);
    	
    	NoButton = new JButton("No");
    	NoButton.setBounds(550, 300, 80, 40);
    	NoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println("NO");
            }
    	});
    	//frame.add(NoButton, BorderLayout.SOUTH);
    	panel.add(NoButton);
    	
    	//------------BUTTONS-------------
    	
    	frame.setLocationRelativeTo(null);  
    	frame.pack(); 
    	frame.setVisible(true); 
    	
	}
	
	public static class changeLabel{
		public static void change(String newLabel) {
			textLabel.setText(newLabel);
			textLabel.setBounds((width/2 - (newLabel.length()*12)), (height/2 - 80), 300, 40);
		}
	}
	

    public static void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	createWindow();
        	changeLabel.change("coscoscos");
            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }
    

}
