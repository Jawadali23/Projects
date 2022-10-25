import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class QuizApplication extends JFrame implements ActionListener {
    JLabel label, jLabel;
    JRadioButton[] radioButtons = new JRadioButton[5];
    JButton btnBack, btnNext, btnResult;
    ButtonGroup bg;
    int count = 0, current = 0;
    public void clock() {
        Thread clock = new Thread() {
            @Override
            public void run() {
                jLabel = new JLabel();
                add(jLabel);

                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                      /*  int day =cal.get(Calendar.DAY_OF_MONTH);
                        int month=cal.get(Calendar.MONTH);
                        int year=cal.get(Calendar.YEAR);
                        */
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        jLabel.setText("Time " + hour + ":" + minute + ":" + second);
                        jLabel.setBounds(290, 150, 190, 100);
                    sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
    QuizApplication(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();

        for (int i = 0; i < 5; i++) {
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnBack = new JButton("Back");
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnBack.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30, 40, 450, 20);
        radioButtons[0].setBounds(50, 80, 450, 20);
        radioButtons[1].setBounds(50, 110, 200, 20);
        radioButtons[2].setBounds(50, 140, 200, 20);
        radioButtons[3].setBounds(50, 170, 200, 20);
        btnBack.setBounds(100, 240, 100, 30);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        clock();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(150, 50);
        setVisible(true);
        setSize(600, 350);

    }

    void setData() {
        radioButtons[4].setSelected(true);
        if (current == 0) {
            label.setText("Q1 :Which of the following is not an OOPS concept in Java? ");
            radioButtons[0].setText("Polymorphism");
            radioButtons[1].setText("Inheritance");
            radioButtons[2].setText("Compilation");
            radioButtons[3].setText("Encapsulation");
        }
        if (current == 1) {
            label.setText("Q2: Who invented Java Programming language? ");
            radioButtons[0].setText("Guido van Rossum");
            radioButtons[1].setText("James Gosling");
            radioButtons[2].setText("Dennis Richie");
            radioButtons[3].setText("Bjarne Stroustrup");
        }
        if (current == 2) {
            label.setText("Q3: What is the extension of java code files?");
            radioButtons[0].setText(".jv");
            radioButtons[1].setText(".txt");
            radioButtons[2].setText(".class");
            radioButtons[3].setText(".java");
        }
        if (current == 3) {
            label.setText("Q4: Which of these are selection statements in Java?");
            radioButtons[0].setText("continue");
            radioButtons[1].setText("break");
            radioButtons[2].setText("for()");
            radioButtons[3].setText("if()");
        }
        if (current == 4) {
            label.setText("Q5: Which one of the following is not an access modifier?");
            radioButtons[0].setText("Protected");
            radioButtons[1].setText("void");
            radioButtons[2].setText("Public");
            radioButtons[3].setText("Private");
        }
        if (current == 5) {
            label.setText("Q6: What is the numerical range of a char data type in Java?");
            radioButtons[0].setText("-128 To 127");
            radioButtons[1].setText("0 To 4852");
            radioButtons[2].setText("0 To 8475");
            radioButtons[3].setText("0 To 65535");

        }
        if (current == 6) {
            label.setText("Q7: Which component is used to compile, debug and execute the java programs?");
            radioButtons[0].setText("JRE");
            radioButtons[1].setText("JIT");
            radioButtons[2].setText("JDK");
            radioButtons[3].setText("JVM");
        }
        if (current == 7) {
            label.setText("Q8: Which of these cannot be used for a variable name in Java?");
            radioButtons[0].setText("Identifier");
            radioButtons[1].setText("Keyword");
            radioButtons[2].setText("Identifier and Keyword");
            radioButtons[3].setText("None of these");
        }
        if (current == 8) {
            label.setText("Q9: Which of this method of class String is used to obtain a length of String object?");
            radioButtons[0].setText("get()");
            radioButtons[1].setText("SizeOf()");
            radioButtons[2].setText("lengthOf()");
            radioButtons[3].setText("length()");
        }
        if (current == 9) {
            label.setText("Q10: Which of these operators can be used to concatenate two or more String objects?");
            radioButtons[0].setText("+");
            radioButtons[1].setText("*");
            radioButtons[2].setText("||");
            radioButtons[3].setText("&");
        }

        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButtons[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    boolean checkAns() {
        if (current == 0) {
            return (radioButtons[2].isSelected());
        }
        if (current == 1) {
            return (radioButtons[1].isSelected());
        }
        if (current == 2) {
            return (radioButtons[3].isSelected());
        }
        if (current == 3) {
            return (radioButtons[3].isSelected());
        }
        if (current == 4) {
            return (radioButtons[1].isSelected());
        }
        if (current == 5) {
            return (radioButtons[3].isSelected());
        }
        if (current == 6) {
            return (radioButtons[2].isSelected());
        }
        if (current == 7) {
            return (radioButtons[1].isSelected());
        }
        if (current == 8) {
            return (radioButtons[3].isSelected());
        }
        if (current == 9) {
            return (radioButtons[0].isSelected());
        }
        return false;
    }
    public static void main(String[] args) {
        new QuizApplication("Simple Quiz App");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnNext){
            if (checkAns())
                count=count+1;
            current++;
            setData();
            if(current==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");

            }
        }
        if (e.getActionCommand().equals("Result")){
            if (checkAns())
                count=count+1;
            current++;
            JOptionPane.showConfirmDialog(this,"Correct Answers are "+count);
            System.exit(0);

        }
    }
}
