package Lab_13_Task;
//////////////////
import JSONObject.JSONObject;
///////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.*;

// To open new frame on click (New Frame code)
class C extends JFrame {
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8;

    JLabel name, roll_no, section, batch, gender, qualification, address, country;
    public C() {
        setSize(620, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.ORANGE);

        jl1 = new JLabel("Name: ");
        jl2 = new JLabel("Roll No: ");
        jl3 = new JLabel("Batch: ");
        jl4 = new JLabel("Section: ");
        jl5 = new JLabel("Gender: ");
        jl6 = new JLabel("Qualification: ");
        jl7 = new JLabel("Address: ");
        jl8 = new JLabel("Country: ");
        name = new JLabel();
        roll_no = new JLabel();
        batch = new JLabel();
        section = new JLabel();
        gender = new JLabel();
        qualification = new JLabel();
        address = new JLabel();
        country = new JLabel();

        jl1.setBounds(50, 50, 75, 25);
        jl2.setBounds(50, 100, 75, 25);
        jl3.setBounds(50, 150, 75, 25);
        jl4.setBounds(50, 200, 75, 25);
        jl5.setBounds(50, 250, 75, 25);
        jl6.setBounds(50, 300, 80, 25);
        jl7.setBounds(50, 350, 75, 25);
        jl8.setBounds(50, 400, 75, 25);

        name.setBounds(150, 50, 250, 25);
        roll_no.setBounds(150, 100, 250, 25);
        batch.setBounds(150, 150, 250, 25);
        section.setBounds(150, 200, 250, 25);
        gender.setBounds(150, 250, 250, 25);
        qualification.setBounds(150, 300, 250, 25);
        address.setBounds(150, 350, 400, 25);
        country.setBounds(150, 400, 250, 25);




//        jl2.setText(roll_no.getText());
//        jl3.setText(batch.getText());
//        jl3.setText(section.getText());

        add(jl1);    add(name);
        add(jl2);    add(roll_no);
        add(jl3);    add(batch);
        add(jl4);    add(section);
        add(jl5);    add(gender);
        add(jl6);    add(qualification);
        add(jl7);    add(address);
        add(jl8);    add(country);


        setVisible(true);
    }
    public void my_update(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8){
        name.setText(str1);
        roll_no.setText(str2);
        batch.setText(str3);
        section.setText(str4);
        gender.setText(str5);
        qualification.setText(str6);
        address.setText(str7);
        country.setText(str8);
    }
}     // end of class C

// Actual frame code when program will be run
class Form extends JFrame implements ActionListener {
    static String str1, str2, str3, str4, str5, str6, str7, str8;
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8;
    JTextField roll_no, name, batch, section;
    JRadioButton jb1, jb2;
    JButton b1, b2, insert, fetch;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    JTextArea address;
    JComboBox country;

    public Form() {
        setSize(620, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);

        jl1 = new JLabel("Name ");
        jl2 = new JLabel("Roll No ");
        jl3 = new JLabel("Batch ");
        jl4 = new JLabel("Section ");
        jl5 = new JLabel("Gender ");
        jl6 = new JLabel("Qualification ");
        jl7 = new JLabel("Address ");
        jl8 = new JLabel("Country");
        jl1.setBounds(50, 50, 75, 25);
        jl2.setBounds(50, 100, 75, 25);
        jl3.setBounds(50, 150, 75, 25);
        jl4.setBounds(50, 200, 75, 25);
        jl5.setBounds(50, 250, 75, 25);
        jl6.setBounds(50, 300, 75, 25);
        jl7.setBounds(50, 400, 75, 25);
        jl8.setBounds(50, 450, 75, 25);

        roll_no = new JTextField(20);
        name = new JTextField(20);
        batch = new JTextField(20);
        section = new JTextField(20);
        name.setBounds(125, 50, 200, 25);
        roll_no.setBounds(125, 100, 200, 25);
        batch.setBounds(125, 150, 200, 25);
        section.setBounds(125, 200, 200, 25);

        jb1 = new JRadioButton("Male");
        jb2 = new JRadioButton("Female");
        jb1.setBackground(Color.yellow);
        jb2.setBackground(Color.yellow);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);
        bg.add(jb2);
        jb1.setBounds(150, 250, 80, 25);
        jb2.setBounds(250, 250, 80, 25);

        checkBox1 = new JCheckBox("Matric");
        checkBox2 = new JCheckBox("Intermediate");
        checkBox3 = new JCheckBox("Graduate");
        checkBox4 = new JCheckBox("Post Graduate");
        checkBox1.setBackground(Color.yellow);
        checkBox2.setBackground(Color.yellow);
        checkBox3.setBackground(Color.yellow);
        checkBox4.setBackground(Color.yellow);

        checkBox1.setBounds(150, 300, 80, 25);
        checkBox2.setBounds(250, 300, 120, 25);
        checkBox3.setBounds(150, 350, 100, 25);
        checkBox4.setBounds(250, 350, 130, 25);

        address = new JTextArea();
        address.setLineWrap(true);
        address.setWrapStyleWord(true);
        address.setBounds(150, 400, 220, 40);

        String[] countries = {"Pakistan", "India", "China"};
        country = new JComboBox(countries);
        country.setBounds(150, 450, 160, 25);

        b1 = new JButton("Save");
        b2 = new JButton("Print");
        insert = new JButton("Insert");
        fetch = new JButton("Fetch");
        b1.setFocusable(false);
        b2.setFocusable(false);
        insert.setFocusable(false);
        fetch.setFocusable(false);
        b1.setBounds(50, 500, 75, 25);
        b2.setBounds(150, 500, 75, 25);
        insert.setBounds(250, 500, 75, 25);
        fetch.setBounds(350, 500, 75, 25);

        add(jl1);
        add(name);
        add(jl2);
        add(roll_no);
        add(jl3);
        add(batch);
        add(jl4);
        add(section);
        add(jl5);
        add(jb1);
        add(jb2);
        add(jl6);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(checkBox4);
        add(jl7);
        add(address);
        add(jl8);
        add(country);
        add(b1);
        add(b2);
        add(insert);
        add(fetch);

        b1.addActionListener(this);
        b2.addActionListener(this);
        insert.addActionListener(this);
        fetch.addActionListener(this);
        setVisible(true);
    }
    public void get() {
        str1 = name.getText();
        str2 = roll_no.getText();
        str3 = batch.getText();
        str4 = section.getText();
        str5 = "";
        str6 = "";

        if (jb1.isSelected())
            str5 = "Male";
        else
            str5 = "Female";
        if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()) {
            str6 = checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText() + " and " + checkBox4.getText();
        } else if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected()) {
            str6 = checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText();
        } else if (checkBox1.isSelected() && checkBox2.isSelected()) {
            str6 = checkBox1.getText() + ", " + checkBox2.getText();
        } else if (checkBox1.isSelected()) {
            str6 = checkBox1.getText();
        } else if (checkBox2.isSelected()) {
            str6 = checkBox2.getText();
        } else if (checkBox3.isSelected()) {
            str6 = checkBox3.getText();
        } else if (checkBox4.isSelected()) {
            str6 = checkBox4.getText();
        }   // end of if else conditional
        str7 = address.getText();
        str8 = (String) country.getSelectedItem();
    }     // end of get
    @Override
    public void actionPerformed(ActionEvent e) {
        Writer writer;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", name.getText());
        jsonObject.put("Roll Number: ", roll_no.getText());
        jsonObject.put("Batch: ", batch.getText());
        jsonObject.put("Section: ", section.getText());
        if (jb1.isSelected()) {
            jsonObject.put("Gender: ", jb1.getText());
        } else {
            jsonObject.put("Gender: ", jb2.getText());
        }
        if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText() + " and " + checkBox4.getText());
        } else if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText());
        } else if (checkBox1.isSelected() && checkBox2.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText());
        } else if (checkBox1.isSelected()) {
            jsonObject.put("Qualification: ", checkBox1.getText());
        } else if (checkBox2.isSelected()) {
            jsonObject.put("Qualification: ", checkBox2.getText());
        } else if (checkBox3.isSelected()) {
            jsonObject.put("Qualification: ", checkBox3.getText());
        } else if (checkBox4.isSelected()) {
            jsonObject.put("Qualification: ", checkBox4.getText());
        }
        jsonObject.put("Country: ", (String) country.getSelectedItem());
        jsonObject.put("Address: ", address.getText());

        if (e.getSource() == b1) {
            try {
                writer = new FileWriter("Task_13.json");
                writer.write(jsonObject.toJSONString());
                try {
                    if (jb1.isSelected()) {
                        jsonObject.put("Gender: ", jb1.getText());
                    } else {
                        jsonObject.put("Gender: ", jb2.getText());
                    }
                    if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText() + " and " + checkBox4.getText());
                    } else if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText() + ", " + checkBox3.getText());
                    } else if (checkBox1.isSelected() && checkBox2.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText() + ", " + checkBox2.getText());
                    } else if (checkBox1.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox1.getText());
                    } else if (checkBox2.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox2.getText());
                    } else if (checkBox3.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox3.getText());
                    } else if (checkBox4.isSelected()) {
                        jsonObject.put("Qualification: ", checkBox4.getText());
                    }   // end of try block
                } catch (Exception ie) {
                    ie.printStackTrace();
                }
                writer.close();
            } catch (Exception ie) {
                ie.printStackTrace();
            }
        }
        else if (e.getSource() == b2) {
            get();
            C obj = new C();
            obj.my_update(str1, str2, str3, str4, str5, str6, str7, str8);
            obj.setVisible(true);
            dispose();
        }      //  end of if-else ladder

        else if(e.getSource()==insert){
            try {
                insertDatabase();
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource()==fetch){
            try {
                fetchData();
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        }      //  end of if-else ladder

    }         //  end of actionPerformed() method
    public void insertDatabase() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";       // where last jdbc is Database name in MySQL
        String uname = "root";
        String pass = "asad56@mysql.com";

        String query = "SELECT * FROM employee";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection(url, uname, pass);        // In XAMPP we have not to store password in getConnection,but rather we use empy string at place of password parameter
        Statement st = com.createStatement();
        ResultSet rs = st.executeQuery(query);
        get();
        int count = st.executeUpdate("INSERT INTO jdbc.`registration` VALUES('"+str1+"', '"+str2+"', '"+str3+"', '"+str4+"', '"+str5+"', '"+str6+"', '"+str7+"', '"+str8+"')");
        System.out.println(count+" Rows affected");

        st.close();
        rs.close();

    }   // end of method database()
    public void fetchData() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";       // where last jdbc is Database name in MySQL
        String uname = "root";
        String pass = "asad56@mysql.com";

        String query = "SELECT * FROM registration";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection(url, uname, pass);        // In XAMPP we have not to store password in getConnection,but rather we use empy string at place of password parameter
        Statement st = com.createStatement();
        ResultSet rs = st.executeQuery(query);
        get();

        while(rs.next()) {
            String name = rs.getString(1);
            String roll_no = rs.getString(2);
            String batch = rs.getString(3);
            String section = rs.getString(4);
            String gender = rs.getString(5);
            String qualification = rs.getString(6);
            String address = rs.getString(7);
            String country = rs.getString(8);

            System.out.print(name+"\t || "+roll_no+"\t || "+batch+"\t || "+section+"\t || "+gender+"\t || "+qualification+"\t || "+address+"\t || ");
            System.out.println(country);
        }
        st.close();
        rs.close();
    }   // end of method fetchData()

}            //   end of class Form

class Student_Registration_Form {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println();
        Form form = new Form();

    }
}

