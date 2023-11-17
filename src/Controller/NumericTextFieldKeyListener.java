/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JTextField;
/**
 *
 * @author r m s rathnayake
 */
public class NumericTextFieldKeyListener extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        // Allow digits and a single dot
        if (!Character.isDigit(c) && c != '.') {
            e.consume(); // Ignore the key event
        }

        // Allow the dot character only once and not at the beginning
        JTextField textField = (JTextField) e.getSource();
        if (c == '.' && textField.getText().contains(".")) {
            e.consume(); // Ignore the key event
        }
    }
    
}
    

