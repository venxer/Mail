import java.util.Arrays;

public class Account 
{
    private String email;
    private String password;
    private static int emailPlusPassword = 0;
    private static String[] adminMail;
    private static String[] adminPass;
    private static String[] storageVault = new String [10000];
    private static int adminCount = 0;

    public Account(String email, String password)
    {
        this.email = email;
        this.password = password;
        emailPlusPassword+=2;
    }
    public Account(String[] adminMail, String[] adminPass)
    {
        this.adminMail = adminMail;
        this.adminPass = adminPass;
        emailPlusPassword+=2;
    }
    public void setAdminMail(String[] adminMailsNew)
    {
        adminMail = adminMailsNew; //changes admin email
        storageVault[0] = adminMailsNew[0]; //changes pos 0 of storage vault to admin mail
    }
    public void setAdminPass(String[] adminPassNew)
    {
        adminPass = adminPassNew; //changes admin pass
        storageVault[1] = adminPassNew[0]; //changes pos 1 of storage vault to admin pass
    }
    public String[] getAdminPass()
    {
        return adminPass;
    }
    public String[] getAdminMail()
    {
        return adminMail;
    }

    public static void addEmailPlusPassword(int add) //prevents double adding when creating admin account
    {
        emailPlusPassword+=add;
    }

    public static String[] getEmail()
    {
        String[] usedStorage = new String[emailPlusPassword];
        String[] emailStorage = new String[emailPlusPassword/2];
        System.arraycopy(storageVault, 0, usedStorage, 0, usedStorage.length);
        int pos = 0;
        for(int x = 0; x < usedStorage.length;x+=1)
        {
            if (x % 2 == 0) //even
            {
                emailStorage[pos] = usedStorage[x];
                pos++;
            }
        }
        return emailStorage;
    }

    public static String[] getPassword()
    {
        String[] usedStorage = new String[emailPlusPassword];
        String[] passwordStorage = new String[emailPlusPassword/2];
        System.arraycopy(storageVault, 0, usedStorage, 0, usedStorage.length);
        int pos = 0;
        for(int x = 0; x < usedStorage.length;x+=1)
        {
            if (x % 2 == 1) //odd
            {
                passwordStorage[pos] = usedStorage[x];
                pos++;
            }
        }
        return passwordStorage;
    }

    public static boolean checkPass(String email, String password)
    {
        int emailIndex = Arrays.asList(Account.getEmail()).indexOf(email);
        if(emailIndex == -1) // if email does not exist in system
        {
            return false;
        }
        else // if email exist in system
        {
            return Account.getPassword()[emailIndex].equals(password);
        }   
    }

    public static void Storage(String email, String password, boolean isAdmin) //{email1, pass1, email2, pass2, null, null}
    {
        if(isAdmin)
        {
            if((Arrays.asList(Account.getEmail()).indexOf(email)) == -1 && (adminCount < 1)) // runs once + if email does not exit 
            { // runs once to prevent adding admin acc each time a button is clicked
                storageVault[0] = email;
                storageVault[1] = password;
                adminCount++;
            }
            else //line 406
            {
                emailPlusPassword-=2;
            }
        }
        else
        {
            storageVault[emailPlusPassword-2] = email;
            storageVault[emailPlusPassword-1] = password;
        }
    }

    public String toString() //even email, odd password
    {
        String[] copyStorage = new String[emailPlusPassword];
        System.arraycopy(storageVault, 0, copyStorage, 0, copyStorage.length);
        return Arrays.toString(copyStorage);
    }
}
