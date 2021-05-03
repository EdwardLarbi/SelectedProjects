import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
@author Edward Larbi
@version 1.0
*/

public class BankingGui extends JFrame {
    private JLabel bankNameLabel;
    private JLabel enterAmtLabel;
    private JLabel displayLabel;
    private JTextField textField;
    private JTextArea historyTextArea;
    private JButton withdrawBtn;
    private JButton depositBtn;
    private double balance;

    JPanel panel_1;
    JPanel panel_2;
    JPanel panel_3;
    JPanel panel_4;
    JPanel panel_4A;
    JPanel panel_4B;
    JPanel panel_4C;
    JPanel panel_4Ci;
    JPanel panel_4Cii;
    JPanel panel_contacts;

    JLabel phone = new JLabel("PHONE: 404 625 1111");
    JLabel address = new JLabel("ADDRESS: 3251 Panthersville RD, Atlanta, GA");
    JLabel facebook = new JLabel("FACEBOOK: facebook.com/Simple_Banking");
    JLabel twitter = new JLabel("TWITTER: twitter.com/Simple_Banking");
    JLabel gmail = new JLabel("GMAIL: simplyB@gmail.com");
    JLabel instagram = new JLabel ("INSTAGRAM: instagram.com/SimpleBanking");
    JLabel errorMessage = new JLabel("INSUFFICIENT BALANCE!!!");

    private static final int FRAME_WIDTH = 620;
    private static final int FRAME_HEIGHT = 300;
    private static final int INITIAL_BALANCE = 1000;
    private static final int TEXT_FIELD_LENGTH = 20;
    private static final int TEXT_AREA_ROWS = 10;
    private static final int TEXT_AREA_COLS = 10;

    //This is the constructor for the BankingGui class
    public BankingGui(){
        balance = INITIAL_BALANCE;

        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        fillFrame();
    }

    /*This method instantiates the components in the frame and also
    * calls other important methods*/
    public void fillFrame(){
        bankNameLabel = new JLabel("Simple Banking");
        enterAmtLabel = new JLabel("Enter Transaction Amount");
        displayLabel = new JLabel("BALANCE: US$ " + balance);
        ActionListener listener = new BankListener();

        textField = new JTextField(TEXT_FIELD_LENGTH);
        historyTextArea = new JTextArea(TEXT_AREA_ROWS,TEXT_AREA_COLS);
        historyTextArea.setText("Account History \n");

        withdrawBtn = new JButton("WITHDRAW");
        depositBtn = new JButton("DEPOSIT");

        createPanels();
        createFrameLayout();
        designPanels();

        //this adds listeners to the withdraw and deposit buttons.
        withdrawBtn.addActionListener(listener);
        depositBtn.addActionListener(listener);
    }

    /*This is an Event listener inner class.
    * it describes the actions to be performed when the buttons are clicked*/
    class BankListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            double amount = Double.parseDouble(textField.getText());
            if (event.getSource() == withdrawBtn){
                if (amount <= balance){
                    balance -= amount;
                    displayLabel.setText("" + balance);
                    historyTextArea.append("Your balance is $" + balance + "\n");
                    errorMessage.setVisible(false);
                }
                else {
                    errorMessage.setVisible(true); //shows user there isn't enough funds.
                    historyTextArea.append("You do not have sufficient balance \n");

                }

            } else {
                balance += amount;
                displayLabel.setText("" + balance);
                historyTextArea.append("Your balance is $" + balance + "\n");
                errorMessage.setVisible(false);
            }
            textField.setText("");
        }
    }

    /*this method creates all the panels to be added to the frame.*/
    public void createPanels(){
        panel_1 = new JPanel();
        panel_2 = new JPanel();
        panel_3 = new JPanel();
        panel_4 = new JPanel();
        panel_4A = new JPanel();
        panel_4B= new JPanel();
        panel_4C = new JPanel();
        panel_4Ci = new JPanel();
        panel_4Cii = new JPanel();
        panel_contacts = new JPanel();

    }

    /*This method handles adding the various components to the panels
    * and adding the panels to the frames in the right layout*/
    public void createFrameLayout(){
        panel_1.add(bankNameLabel);
        panel_2.setLayout(new BorderLayout());
        panel_2.add(enterAmtLabel,BorderLayout.NORTH);
        panel_2.add(errorMessage,BorderLayout.CENTER);
        errorMessage.setVisible(false);
        panel_3.setLayout(new BorderLayout());
        panel_3.add(new JScrollPane(historyTextArea),BorderLayout.CENTER);
        panel_4.setLayout(new BorderLayout());
        panel_4.add(panel_4A,BorderLayout.NORTH);
        panel_4.add(panel_4B,BorderLayout.SOUTH);
        panel_4.add(panel_4C,BorderLayout.CENTER);
        panel_4A.add(textField);
        panel_4B.add(displayLabel);
        panel_4C.setLayout(new GridLayout(2,1));
        panel_4C.add(panel_4Ci);
        panel_4C.add(panel_4Cii);
        panel_4Ci.add(withdrawBtn);
        panel_4Cii.add(depositBtn);
        panel_contacts.setLayout(new GridLayout(3,2));
        panel_contacts.add(phone);
        panel_contacts.add(address);
        panel_contacts.add(gmail);
        panel_contacts.add(twitter);
        panel_contacts.add(instagram);
        panel_contacts.add(facebook);

        add(panel_1,BorderLayout.NORTH);
        add(panel_2,BorderLayout.WEST);
        add(panel_3,BorderLayout.EAST);
        add(panel_4,BorderLayout.CENTER);
        add(panel_contacts,BorderLayout.SOUTH);
        historyTextArea.setEditable(false); // This ensures that the user cannot edit the account history.

    }

    /*This method handles the adding color to the frame and setting fonts*/
    public void designPanels(){
        panel_contacts.setBackground(Color.lightGray);
        panel_1.setBackground(Color.cyan);
        panel_2.setBackground(Color.cyan);
        historyTextArea.setBackground(Color.cyan);
        panel_4A.setBackground(Color.cyan);
        panel_4B.setBackground(Color.cyan);
        panel_4Ci.setBackground(Color.cyan);
        panel_4Cii.setBackground(Color.cyan);

        Font font_contacts = new Font("Courier New",0,12);
        Font font_bankName = new Font("Lucida Handwriting",1,50);

        bankNameLabel.setForeground(Color.blue);
        errorMessage.setForeground(Color.red);
        bankNameLabel.setFont(font_bankName);
        phone.setFont(font_contacts);
        address.setFont(font_contacts);
        gmail.setFont(font_contacts);
        facebook.setFont(font_contacts);
        twitter.setFont(font_contacts);
        instagram.setFont(font_contacts);
        textField.setBackground(Color.LIGHT_GRAY);

    }

    //This is the main method.
    public static void main(String []args){
        JFrame bankFrame = new BankingGui();
        bankFrame.setTitle("Simple Banking._CSC_1302_GUI");
        bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bankFrame.setVisible(true);
    }
}

/*Overview of what this program does:
* 1. allows user to to enter an amount into the text field for transactional purposes.
* 2. when the user enters alphabets or other unexpected value the console generates an error.
* 3. if the user enters an amount and clicks withdraw, the amount is deducted from balance
* and the new balance is displayed.
* 4. if the user enters an amount and click deposit, the amount is added to the balance and the
* new balance is displayed.
* 5. the "Account History" text Area is uneditable by user, and keeps track of all the transactions
* till the the gui is closed.
* 6. the code runs perfectly!!*/
