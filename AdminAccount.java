import java.util.Arrays;

public class AdminAccount 
{
    private Account account;
    public AdminAccount(Account a)
    {
        account = new Account(a.getAdminMail(), a.getAdminPass());
        Account.addEmailPlusPassword(-2);
    }

    public void setAdminMail(String[] a)
    {
        account.setAdminMail(a);
    }
    public void setAdminPass(String[] a)
    {
        account.setAdminPass(a);
    }

    public String[] getAdminMail()
    {
        return account.getAdminMail();
    }

    public String[] getAdminPass()
    {
        return account.getAdminPass();
    }

    public static String allInfo()
    {
        String allInfo = "";
        for(int x = 0; x < EmailMessage.getMessage().length; x++)
        {
            allInfo += "From: " + EmailMessage.getSender()[x] + "\nTo: " + EmailMessage.getRecipient()[x] + "\nMessage: " + EmailMessage.getMessage()[x] + "\n-----------------------------------------------------------------------------------------------";
        }
        return allInfo;
    }

    public String toString()
    {
        return Arrays.toString(account.getAdminMail()) + ":" + Arrays.toString(account.getAdminPass());
    }
}
