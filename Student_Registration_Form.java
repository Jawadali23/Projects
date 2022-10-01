package Lab_11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;

class B extends JFrame implements ActionListener{
    JLabel jl1, jl2, jl3, jl4, jl5;
    JTextField roll_no, name, batch, section;
    JRadioButton jb1, jb2;
    JButton b1, b2;
    public B(){
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        jb1 = new JRadioButton("Male: ");
        jb2 = new JRadioButton("Female: ");

        roll_no = new JTextField(30);
        name = new JTextField(30);
        batch = new JTextField(30);
        section = new JTextField(30);

        jl1 = new JLabel("Name: ");
        jl2 = new JLabel("Roll No:");
        jl3 = new JLabel("Batch: ");
        jl4 = new JLabel("Section: ");
        jl5 = new JLabel("Gender: ");
        b1 = new JButton("Save");
        b2 = new JButton("Print");

        add(jl1);   add(name);
        add(jl2);   add(roll_no);       System.out.println();
        add(jl3);   add(batch);         System.out.println();
        add(jl4);   add(section);       System.out.println();

        add(jb1);    add(jb2);
        add(b1);     add(b2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);      bg.add(jb2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Writer writer;
        if(e.getSource()==b1) {
            try {
                writer = new FileWriter("first.txt");
                System.out.println(name.getText());
                writer.write(name.getText() + "\n");
                writer.write(roll_no.getText() + "\n");
                writer.write(batch.getText() + "\n");
                writer.write(section.getText() + "\n");
                try{
                    if(jb1.isSelected()) {
                        writer.write("Male");
                    }
                    else {
                        writer.write("Female");
                    }
                }
                catch (Exception ie){
                    ie.printStackTrace();
                }

                writer.close();
            } catch (Exception ie) {
                ie.printStackTrace();
            }
        }
        else if(e.getSource()==b2) {
            System.out.println(name.getText());
            System.out.println(roll_no.getText());
            System.out.println(batch.getText());
            System.out.println(section.getText());
        }
//

    }
}

public class Student_Registration_Form {
    public static void main(String[] args) {

        B b = new B();
    }
}
