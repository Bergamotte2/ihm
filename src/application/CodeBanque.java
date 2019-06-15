package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CodeBanque extends JPanel {
	
	String code = "";
	
	public CodeBanque(JFrame frame) {
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.RED);
		
		JLabel message = new JLabel();
		message.setForeground(Color.BLACK);
		message.setFont(new Font("Serif", Font.PLAIN, 40));
		
		frame.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char tape = e.getKeyChar();
				if (Character.isDigit(tape) && code.length()<4)
				{
					code+=tape;
					message.setText(message.getText()+" * ");
					System.out.println(code);
				}
				else if (e.getKeyCode()==8)
				{
					if (code.length() > 0) {
						code = code.substring(0, code.length() - 1);
						message.setText(message.getText().substring(0, message.getText().length() - 3));
					}
				}
			}
		});
		
		JPanel codeContainer = new JPanel();
		codeContainer.setPreferredSize(new Dimension(250, 50));
		codeContainer.setBackground(Color.WHITE);
		codeContainer.add(message);
		this.add(codeContainer);
	}
	
	public String getCode() {
		return code;
	}
}
