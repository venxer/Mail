/**
 * @author Edwin Zhao
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.*;

public class GUI implements ActionListener
{
    private static int x = 0;
    private static String currentAdminMail;
    private static String currentAdminPass;
    //E-Mail Frame + Panel
    private static JFrame UIFrame; //DO NOT HIDE
    private static JPanel UIPanel; //DO NOT HIDE
    //Login UI
    private static JLabel username;
    private static JLabel password;
    private static JLabel accountAlreadyExist;
    private static JLabel loginSuccess;
    private static JLabel incorrectPassword;
    private static JLabel accountCreated;
    private static JLabel accountDoesNotExist1;
    private static JLabel accountDoesNotExist2;
    private static JTextField passwordField;
    private static JTextField usernameField;
    private static JButton loginButton;
    private static JButton newAccountButton;
    // EMAIL GUI
    private static JLabel recipient;
    private static JLabel emailLabel;
    private static JLabel sent;
    private static JLabel noRecipient1;
    private static JLabel noRecipient2;
    private static JTextField recipientField;
    private static JTextArea messageBox;
    private static JButton sendMessageButton;
    private static JButton signOutButton;
    private static JButton viewInboxButton;
    // INBOX SCREEN
    private static JFrame inboxFrame;
    private static JPanel inboxPanel;
    private static JTextArea inboxText;
    private static JScrollPane inboxTextScroll;
    private static JLabel inboxLabel;
    // ADMIN SCREEN
    private static JFrame adminFrame;
    private static JPanel adminPanel;
    private static JTextArea adminText;
    private static JScrollPane adminTextScroll;
    private static JButton adminSignOut;
    private static JButton adminChangeInfo;
    private static JLabel adminAccLabel;
    // CHANGE ADMIN INFO SCREEN
    private static JFrame adminChangeInfoFrame;
    private static JPanel adminChangeInfoPanel;
    private static JLabel newAdminusername;
    private static JTextField newAdminUsernameField;
    private static JLabel newAdminPassword;
    private static JButton adminChangeInfoButton;
    private static JPasswordField newAdminPasswordField;

    //creates frame
    public static void GUI()
    {
        //Initalize UI
        UIFrame = new JFrame("E-Mail");
        UIPanel = new JPanel();
        UIFrame.setSize(450, 250);
        UIFrame.setResizable(false);
        UIFrame.add(UIPanel);
        UIFrame.setLocationRelativeTo(null);
        UIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIPanel.setLayout(null);
        
        //Login
        username = new JLabel("E-Mail:"); // email label
        username.setBounds(30, 20, 80, 20);
        UIPanel.add(username);

        usernameField = new JTextField(); // field for email
        usernameField.setBounds(100, 20, 220, 20);
        UIPanel.add(usernameField);

        password = new JLabel("password:"); // password label
        password.setBounds(30, 50, 80, 20);
        UIPanel.add(password);

        passwordField = new JPasswordField(); // field for passoword
        passwordField.setBounds(100, 50, 220, 20); //390-100
        UIPanel.add(passwordField);

        loginButton = new JButton("Log In"); // Login button 
        loginButton.setBounds(100, 80, 100, 20);
        loginButton.addActionListener(new GUI()); // allows Log In button to check login when clicked
        UIPanel.add(loginButton);

        newAccountButton = new JButton("Create Acc"); // Create New Account Button
        newAccountButton.setBounds(220, 80, 100, 20);
        newAccountButton.addActionListener(new GUI());
        UIPanel.add(newAccountButton);

        accountAlreadyExist = new JLabel("Email Used");
        accountAlreadyExist.setBounds(325, 20, 100, 20);
        UIPanel.add(accountAlreadyExist);

        loginSuccess = new JLabel("Login Success");
        loginSuccess.setBounds(325, 20, 100, 20);
        UIPanel.add(loginSuccess);

        incorrectPassword = new JLabel("Incorrect Pass");
        incorrectPassword.setBounds(325, 50, 100, 20);
        UIPanel.add(incorrectPassword);
        
        accountCreated = new JLabel("Account Created");
        accountCreated.setBounds(325, 20, 100, 20);
        UIPanel.add(accountCreated);
        
        accountDoesNotExist1 = new JLabel("Account Does");
        accountDoesNotExist1.setBounds(325, 20, 100, 20);
        UIPanel.add(accountDoesNotExist1);

        accountDoesNotExist2 = new JLabel("Not Exist");
        accountDoesNotExist2.setBounds(325, 40, 100, 20);
        UIPanel.add(accountDoesNotExist2);

        // sets visibility to false. True when message needs to be shown 
        accountAlreadyExist.setVisible(false);
        loginSuccess.setVisible(false);
        incorrectPassword.setVisible(false);
        accountCreated.setVisible(false);
        accountDoesNotExist1.setVisible(false);
        accountDoesNotExist2.setVisible(false);

        //Email
        recipient = new JLabel("Recipient:");
        recipient.setBounds(100, 26, 100, 20);
        UIPanel.add(recipient);
        recipient.setVisible(false);

        recipientField = new JTextField();
        recipientField.setBounds(165, 26, 175, 20);
        UIPanel.add(recipientField);
        recipientField.setVisible(false);

        messageBox = new JTextArea(240, 100);
        messageBox.setBounds(100, 50, 240, 100);
        messageBox.setLineWrap(true);
        messageBox.setWrapStyleWord(true);
        UIPanel.add(messageBox);
        messageBox.setVisible(false);

        emailLabel = new JLabel();
        emailLabel.setBounds(100, 5, 300, 20);
        UIPanel.add(emailLabel);
        emailLabel.setVisible(false);

        sendMessageButton = new JButton("Send");
        sendMessageButton.setBounds(100, 160, 100, 20);
        UIPanel.add(sendMessageButton);
        sendMessageButton.addActionListener(new GUI());
        sendMessageButton.setVisible(false);

        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(5, 160, 90, 20);
        UIPanel.add(signOutButton);
        signOutButton.addActionListener(new GUI());
        signOutButton.setVisible(false);

        sent = new JLabel("Sent!");
        sent.setBounds(350, 75, 100, 20);
        UIPanel.add(sent);
        sent.setVisible(false);

        noRecipient1 = new JLabel("Email Does");
        noRecipient1.setBounds(350, 75, 100, 20);
        UIPanel.add(noRecipient1);
        noRecipient1.setVisible(false);

        noRecipient2 = new JLabel("Not Exist");
        noRecipient2.setBounds(355, 95, 100, 20);
        UIPanel.add(noRecipient2);
        noRecipient2.setVisible(false);

        viewInboxButton = new JButton("View Inbox");
        viewInboxButton.setBounds(240, 160, 100, 20);
        UIPanel.add(viewInboxButton);
        viewInboxButton.addActionListener(new GUI());
        viewInboxButton.setVisible(false);

        UIFrame.setVisible(true);

        //Inbox
        inboxFrame = new JFrame("Inbox");
        inboxPanel = new JPanel();
        inboxFrame.add(inboxPanel);
        inboxFrame.setSize(450, 700);   
        inboxFrame.setResizable(false);

        inboxLabel = new JLabel("Inbox");
        inboxPanel.add(inboxLabel);
        inboxLabel.setFont(new Font("Null", Font.BOLD, 17));

        inboxText = new JTextArea(37, 35);
        inboxText.setLineWrap(true);
        inboxText.setWrapStyleWord(true);
        inboxText.setEditable(false);
        inboxTextScroll = new JScrollPane(inboxText);
        inboxTextScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        inboxPanel.add(inboxTextScroll);

        //Admin Screen
        adminFrame = new JFrame("Admin Inbox");
        adminPanel = new JPanel();
        adminFrame.add(adminPanel);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(450, 700);
        adminFrame.setResizable(false);

        adminAccLabel = new JLabel("Admin Account");
        adminPanel.add(adminAccLabel);
        adminAccLabel.setFont(new Font("Null", Font.BOLD, 17));

        adminText = new JTextArea(36, 35);
        adminText.setLineWrap(true);
        adminText.setWrapStyleWord(true);
        adminText.setEditable(false);
        adminTextScroll = new JScrollPane(adminText);
        adminTextScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        adminPanel.add(adminTextScroll);

        adminSignOut = new JButton("Sign Out");
        adminPanel.add(adminSignOut);
        adminSignOut.addActionListener(new GUI());
        adminSignOut.setVisible(false);

        adminChangeInfo = new JButton("Change Admin Login");
        adminPanel.add(adminChangeInfo);
        adminChangeInfo.addActionListener(new GUI());
        adminChangeInfo.setVisible(false);
        
        //Change Admin Info
        adminChangeInfoFrame = new JFrame("Change Admin Login");
        adminChangeInfoPanel = new JPanel();
        adminChangeInfoFrame.setSize(450, 250);
        adminChangeInfoFrame.setResizable(false);
        adminChangeInfoFrame.add(adminChangeInfoPanel);
        adminChangeInfoFrame.setLocationRelativeTo(null);
        adminChangeInfoPanel.setLayout(null);

        newAdminusername = new JLabel("E-Mail:"); // email label
        newAdminusername.setBounds(30, 20, 80, 20);
        adminChangeInfoPanel.add(newAdminusername);

        newAdminUsernameField = new JTextField(); // field for email
        newAdminUsernameField.setBounds(100, 20, 220, 20);
        adminChangeInfoPanel.add(newAdminUsernameField);

        newAdminPassword = new JLabel("password:"); // password label
        newAdminPassword.setBounds(30, 50, 80, 20);
        adminChangeInfoPanel.add(newAdminPassword);

        newAdminPasswordField = new JPasswordField(); // field for passoword
        newAdminPasswordField.setBounds(100, 50, 220, 20); //390-100
        adminChangeInfoPanel.add(newAdminPasswordField);

        adminChangeInfoButton = new JButton("Change Admin Login");
        adminChangeInfoPanel.add(adminChangeInfoButton);
        adminChangeInfoButton.addActionListener(new GUI());
        adminChangeInfoButton.setBounds(130, 80, 150, 20);
        adminChangeInfoButton.setVisible(true);

        adminChangeInfoFrame.setVisible(false);
    }

    private static void hideLoginAlerts()
    {
        loginSuccess.setVisible(false);
        accountAlreadyExist.setVisible(false);
        incorrectPassword.setVisible(false);
        accountCreated.setVisible(false);
        accountDoesNotExist1.setVisible(false);
        accountDoesNotExist2.setVisible(false);
    }

    private static void showLoginGUI()
    {
        username.setVisible(true);
        password.setVisible(true);
        accountAlreadyExist.setVisible(true);
        loginSuccess.setVisible(true);
        incorrectPassword.setVisible(true);
        accountCreated.setVisible(true);
        accountDoesNotExist1.setVisible(true);
        accountDoesNotExist2.setVisible(true);
        passwordField.setVisible(true);
        usernameField.setVisible(true);
        loginButton.setVisible(true);
        newAccountButton.setVisible(true);
    }
    private static void hideLoginGUI()
    {
        username.setVisible(false);
        password.setVisible(false);
        accountAlreadyExist.setVisible(false);
        loginSuccess.setVisible(false);
        incorrectPassword.setVisible(false);
        accountCreated.setVisible(false);
        accountDoesNotExist1.setVisible(false);
        accountDoesNotExist2.setVisible(false);
        passwordField.setVisible(false);
        usernameField.setVisible(false);
        loginButton.setVisible(false);
        newAccountButton.setVisible(false);
    }

    private static void hideEmailAlerts()
    {
        sent.setVisible(false);
        noRecipient1.setVisible(false);
        noRecipient2.setVisible(false);
    }

    private static void showEmailGUI()
    {
        emailLabel.setVisible(true);
        recipient.setVisible(true);
        recipientField.setVisible(true);
        messageBox.setVisible(true);
        UIPanel.setAlignmentX(Component.CENTER_ALIGNMENT); //Centers recipient and recipientField
        // messageBoxScroll.setVisible(true);
        sendMessageButton.setVisible(true);
        signOutButton.setVisible(true);
        viewInboxButton.setVisible(true);
    }
    private static void hideEmailGUI()
    {
        emailLabel.setVisible(false);
        recipient.setVisible(false);
        recipientField.setVisible(false);
        messageBox.setVisible(false);
        UIPanel.setAlignmentX(Component.CENTER_ALIGNMENT); //Centers recipient and recipientField
        // messageBoxScroll.setVisible(true);
        sendMessageButton.setVisible(false);
        signOutButton.setVisible(false);
        viewInboxButton.setVisible(false);
    }

    private static void showAdminGUI()
    {
        adminFrame.setVisible(true);
        adminSignOut.setVisible(true);
        adminChangeInfo.setVisible(true);

    }
    private static void hideAdminGUI()
    {
        adminFrame.setVisible(false);
        adminSignOut.setVisible(false);
        adminChangeInfo.setVisible(false);

    }

    public static int indexOf(String[] arr, String i) //indexOf 
    {
        for(int y = 0; y < arr.length; y++)
        {
            if (arr[y].equals(i))
            {
                return y;
            }
        }
        return -1;
    }

    public static String mostCommonString(String[] input)
    {
        int newCount = 0;
        int oldCount = 0; 
        String common = input[0];
        for(int x = 0; x < input.length; x++)
        {
            for(int i = 0; i < input.length; i++)
            {
                if(input[x].equals(input[i]))
                {
                    newCount++;
                }
            }
            if(newCount > oldCount)
            {
                common = input[x];
                oldCount = newCount;
            }
        }
        return common;
    }

    public void actionPerformed(ActionEvent e)
    {
        String email = usernameField.getText();
        String password = passwordField.getText();
        String recipient = recipientField.getText();
        String message = messageBox.getText();

        String adminUsernameField = newAdminUsernameField.getText();
        String adminPasswordField = newAdminPasswordField.getText();

        String adminEmailOriginal = adminUsernameField;
        String adminPassOriginal = adminPasswordField;
        if (x < 1) //run once
        {
            adminEmailOriginal = "admin";
            adminPassOriginal = "admin";
            currentAdminMail = adminEmailOriginal;
            currentAdminPass = adminPassOriginal;
        }
        if (!adminUsernameField.equals("") && !adminPasswordField.equals(""))
        {
            currentAdminMail = adminEmailOriginal;
            currentAdminPass = adminPassOriginal;
        }
        String[] currentAdminMailArr = {currentAdminMail};
        String[] currentAdminPassArr = {currentAdminPass};
        Account admin = new Account(currentAdminMailArr, currentAdminPassArr);
        Account.Storage(adminEmailOriginal, adminPassOriginal, true);
        AdminAccount adminAcc = new AdminAccount(admin);

        // String[] adminEmail = {"test"};
        // String[] adminPass = {"test"};
        // String[] adminEmail2 = {"new"};
        // String[] adminPass2 = {"new"};

        // Account admin = new Account(adminEmail, adminPass);
        // Account.Storage("test", "test");
        // AdminAccount adminAcc = new AdminAccount(admin);
        // System.out.println("original:" + Arrays.toString(adminAcc.getAdminMail()));
        // System.out.println("original:" + Arrays.toString(adminAcc.getAdminPass()));

        // adminAcc.setAdminMail(adminEmail2);
        // adminAcc.setAdminPass(adminPass2);
        // System.out.println("new:" + Arrays.toString(adminAcc.getAdminMail()));
        // System.out.println("new:" + Arrays.toString(adminAcc.getAdminPass()));

        if (e.getSource() == loginButton)
        {
            if(email.equals(adminAcc.getAdminMail()[0]) && password.equals(adminAcc.getAdminPass()[0]))
            {
                usernameField.setText("");
                passwordField.setText("");
                UIFrame.setVisible(false);
                System.out.println("Log: Hid Login Window");
                showAdminGUI();
                System.out.println("Log: Opened Admin Interface");
                adminText.setText(AdminAccount.allInfo());
                if(EmailMessage.getRecipient().length != 0)
                {
                    System.out.println("Log: Most Common Recipient: " + mostCommonString(EmailMessage.getRecipient()) );
                }
                else
                {
                    System.out.println("Log: Most Common Recipient: N/A");
                }
            }
            // else if(Arrays.asList(Account.getEmail()).indexOf(email) != -1) // Checks if Email is in the System
            else if(indexOf(Account.getEmail(), email) != -1) // Checks if Email is in the System
            {
                if(Account.checkPass(email, password)) //loginSuccess
                {
                    hideLoginAlerts();
                    loginSuccess.setVisible(true);
                    System.out.println("Log: Login Successful");
                    hideLoginGUI();
                    System.out.println("Log: Hid Login Window");
                    showEmailGUI();
                    System.out.println("Log: Opened Email Interface");
                    emailLabel.setText("Email: " + email);
                    // System.out.println("Log: Recipient: " + recipient);
                    // System.out.println("Log: Message: " + message);
                }
                else //incorrectPassword
                {
                    hideLoginAlerts();
                    incorrectPassword.setVisible(true);
                    System.out.println("Log: Incorrect Password");
                }
            }
            else //accountDoesNotExist
            {
                hideLoginAlerts();
                accountDoesNotExist1.setVisible(true);
                accountDoesNotExist2.setVisible(true);
                System.out.println("Log: Account Does Not Exist");
            }
        }
        else if (e.getSource() == newAccountButton) /*CASE SENSITIVE*/
        {
            if(Arrays.asList(Account.getEmail()).indexOf(email) == -1) //accountCreated
            {
                usernameField.setText("");
                passwordField.setText("");
                System.out.println("Log: Cleared Fields");
                hideLoginAlerts();
                accountCreated.setVisible(true);
                Account account = new Account(email, password);
                Account.Storage(email, password, false); // adds account to storage
                System.out.println("Log: New Account Created\nLog: " + email + ":" + password);
            }
            else // accountAlreadyExist
            {
                hideLoginAlerts();
                accountAlreadyExist.setVisible(true);
                System.out.println("Log: Account Already Exist");
            }
        }
        else if (e.getSource() == signOutButton)
        {
            usernameField.setText("");
            passwordField.setText("");
            recipientField.setText("");
            messageBox.setText("");
            hideEmailGUI();
            showLoginGUI();
            hideLoginAlerts();
            hideEmailAlerts();
            inboxFrame.setVisible(false);
            inboxFrame.dispose();
            inboxFrame.setDefaultCloseOperation(inboxFrame.DISPOSE_ON_CLOSE);
            System.out.println("Log: Signed Out"); 
        }
        else if (e.getSource() == sendMessageButton)
        {
            if(EmailMessage.checkRecipient(recipient)) //false if not in system. True otherwise
            {
                hideEmailAlerts();
                sent.setVisible(true);
                EmailMessage EM = new EmailMessage(recipient, message, email);
                EmailMessage.Storage(recipient, message, email); //email = sender
                System.out.println("Log: " + email + " Sending To " + recipient);
                System.out.println("Log: Recipients: " + Arrays.toString(EmailMessage.getRecipient()));
                System.out.println("Log: Messages: " + Arrays.toString(EmailMessage.getMessage()));
                System.out.println("Log: Senders: " + Arrays.toString(EmailMessage.getSender()));   
                System.out.println("Log: Clearing Message Field");
                messageBox.setText("");
            }
            else
            {
                hideEmailAlerts();
                noRecipient1.setVisible(true);
                noRecipient2.setVisible(true);
                System.out.println("Log: Recipient Does Not Exist");
            }
        }
        else if (e.getSource() == viewInboxButton)
        {
            inboxFrame.setVisible(true);
            inboxText.setText(EmailMessage.inbox(EmailMessage.emailIndex(email)));
            System.out.println("Log: View Inbox");
        }
        else if (e.getSource() == adminSignOut)
        {
            hideLoginAlerts();
            loginButton.setVisible(true);
            newAccountButton.setVisible(true);
            adminChangeInfoButton.setVisible(false);
            hideAdminGUI();
            UIFrame.setVisible(true);
            System.out.println("Log: Admin Signed Out");
            adminChangeInfoFrame.setVisible(false);
            adminChangeInfoFrame.dispose();
            adminChangeInfoFrame.setDefaultCloseOperation(adminChangeInfoFrame.DISPOSE_ON_CLOSE);
            System.out.println("Log: Closed Change Info Frame");

        }
        else if (e.getSource() == adminChangeInfo)
        {
            System.out.println("Log: Change Admin Info Clicked");
            adminChangeInfoFrame.setVisible(true);
            adminChangeInfoButton.setVisible(true);
            hideLoginAlerts();
        }
        else if (e.getSource() == adminChangeInfoButton)
        {
            System.out.println(adminEmailOriginal);
            System.out.println(adminPassOriginal);
            if(Arrays.asList(Account.getEmail()).indexOf(email) == -1) //email not in system
            {
                if(!adminUsernameField.equals("") && !adminPasswordField.equals(""))
                {
                    String[] newAdminEmailArr = {adminUsernameField};
                    String[] newAdminPassArr = {adminPasswordField};
                    adminAcc.setAdminMail(newAdminEmailArr);
                    currentAdminMail = adminUsernameField;
                    System.out.println("Log: setting New admin email: " + Arrays.toString(newAdminEmailArr));
                    adminAcc.setAdminPass(newAdminPassArr);
                    currentAdminPass = adminPasswordField;
                    System.out.println("Log: setting New admin pass: " + Arrays.toString(newAdminPassArr));
                    x++;
                }
                System.out.println(Arrays.toString(adminAcc.getAdminMail()));
                System.out.println(Arrays.toString(adminAcc.getAdminPass()));
                System.out.println("Log: Changed Admin Login Info");
                newAdminUsernameField.setText("");
                newAdminPasswordField.setText("");
                adminChangeInfoFrame.setVisible(false);
                adminChangeInfoFrame.dispose();
                adminChangeInfoFrame.setDefaultCloseOperation(adminChangeInfoFrame.DISPOSE_ON_CLOSE);
            }
            else
            {
                newAdminUsernameField.setText("");
                newAdminPasswordField.setText("");
                System.out.println("Log: Cannot Set Admin Login Info");
            }
        }
    }
}