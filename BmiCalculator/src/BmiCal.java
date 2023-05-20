import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BmiCal extends JFrame {
    String message;
    float BMI;
    private JPanel BmiGui;
    private JLabel PanWeight;
    private JLabel PanHeight;
    private JTextField txtWeight;
    private JTextField txtHeight;
    private JButton btnSubmit;
    private JButton btnClear;
    private JLabel LblHead;
    private JRadioButton RBPoundsInches;
    private JRadioButton RBkgM;
    private JLabel LblDisplay;

    public BmiCal(){
        add(BmiGui);
        setVisible(true);
        setTitle("BMI Calculator");
        setSize(350,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float weight=Float.parseFloat(txtWeight.getText());
                float height=Float.parseFloat(txtHeight.getText());
                if(RBkgM.isSelected()){
                    BMI=weight/(height*height);
                }else if(RBPoundsInches.isSelected()) {
                    BMI=(weight * 703 )/( height* height);
                }else{
                    message="Select an option";
                }
                if(BMI<18.5){
                    message=BMI+" UnderWeight";
                }else if(BMI<25){
                    message=BMI+" Normal";
                }else if(BMI<30){
                    message=BMI+" OverWeight";
                }else if(BMI>30){
                    message=BMI+" Obese";
                }
                LblDisplay.setText(message);
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtHeight.setText("");
                txtWeight.setText("");
                LblDisplay.setText("");
            }
        });
    }

    public static void main(String[] args) {
        BmiCal cal=new BmiCal();
    }
}
