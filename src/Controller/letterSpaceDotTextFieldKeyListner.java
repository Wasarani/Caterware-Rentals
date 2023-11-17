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
public class letterSpaceDotTextFieldKeyListner extends KeyAdapter {
     @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        // Allow letters (both uppercase and lowercase), space,
        if (!Character.isLetter(c) && c != ' ' && c != '.') {
            e.consume(); // Ignore the key event
        }
    }
}
    

