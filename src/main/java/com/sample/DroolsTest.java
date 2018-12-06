package com.sample;
import javax.swing.*;
import java.awt.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */

public class DroolsTest{
	
	private static void createWindow() {
    	JFrame frame = new JFrame("Netflix"); 
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER); 
    	textLabel.setPreferredSize(new Dimension(800, 600));
    	frame.getContentPane().add(textLabel, BorderLayout.CENTER);
    	frame.setLocationRelativeTo(null);  
    	frame.pack(); 
    	frame.setVisible(true); 
	}

    public static void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	createWindow();
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
    
//    public static class Question{
//    	private String question;
//    	private boolean answer;
//    	
//    	public void setQuestion(String sentence) {
//    		this.question = sentence;    	
//    	}
//    	
//    	public void setAnswer(boolean ans) {
//    		this.answer = ans;
//    	}
//    }
    

}
