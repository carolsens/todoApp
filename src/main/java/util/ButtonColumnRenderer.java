/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author Carolina
 */
public class ButtonColumnRenderer extends DefaultTableCellRenderer{
       
    private String buttonType;

    public ButtonColumnRenderer(String buttonType){
        this.buttonType = buttonType;
    }
    
    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int col) {
    
            JLabel label;
            label = (JLabel) super.getTableCellRendererComponent(table, 
                    value, isSelected, hasFocus, row, col);
            
            label.setHorizontalAlignment(JLabel.CENTER);
            
           label.setIcon(new javax.swing.ImageIcon(getClass().
                   getResource("/" + buttonType + ".png")));
            
        return label;
}
    
    
    
}
