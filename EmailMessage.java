import java.util.Arrays;

public class EmailMessage {
    private String recipient;
    private String message;
    private String sender;
    private static int numTotal;
    private static String[] storageVault = new String[100000];

    public EmailMessage(String recipient, String message, String sender) {
        this.recipient = recipient;
        this.message = message;
        this.sender = sender;
        numTotal += 3; // totalMessage = 3
    }

    /**
     * Stores all parameters in an array
     * 
     * @param recipient who the message is for
     * @param message   the message being sent
     * @param sender    sender
     */
    public static void Storage(String recipient, String message, String sender) {
        storageVault[numTotal - 3] = recipient;
        storageVault[numTotal - 2] = message;
        storageVault[numTotal - 1] = sender;
    }

    /**
     * checks if recipient is in list of email
     * 
     * @param recipient who the message is for
     * @return Return true if exist, false otherwise
     */
    public static boolean checkRecipient(String recipient) // Checks if recipient exist
    {
        if (Arrays.asList(Account.getEmail()).indexOf(recipient) == -1) // if email not in system
        {
            return false;
        } else // if email is in system
        {
            return true;
        }
    }

    public static String[] getRecipient() // need to fix
    {
        String[] usedStorage = new String[numTotal];
        String[] recipientStorage = new String[numTotal / 3];
        System.arraycopy(storageVault, 0, usedStorage, 0, usedStorage.length);
        int pos = 0;
        int x = 0;
        while (x < usedStorage.length) {
            recipientStorage[pos] = usedStorage[x];
            pos++;
            x += 3;
        }
        return recipientStorage;
    }

    public static String[] getMessage() {
        String[] usedStorage = new String[numTotal];
        String[] messageStorage = new String[numTotal / 3];
        System.arraycopy(storageVault, 0, usedStorage, 0, usedStorage.length);
        int pos = 0;
        int x = 1;
        while (x < usedStorage.length) {
            messageStorage[pos] = usedStorage[x];
            pos++;
            x += 3;
        }
        return messageStorage;
    }

    public static String[] getSender() {
        String[] usedStorage = new String[numTotal];
        String[] senderStorage = new String[numTotal / 3];
        System.arraycopy(storageVault, 0, usedStorage, 0, usedStorage.length);
        int pos = 0;
        int x = 2;
        while (x < usedStorage.length) {
            senderStorage[pos] = usedStorage[x];
            pos++;
            x += 3;
        }
        return senderStorage;
    }

    /**
     * Finds all the index of the parameter.
     * 
     * @param recipient who the message is for
     * @return returns int array with values of all indexs of recipient
     */
    public static int[] emailIndex(String recipient) // all index of the recipent
    {
        int[] allIndex = new int[10000];
        int pos = 0;
        for (int index = 0; index < getRecipient().length; index++) {
            if (getRecipient()[index].equals(recipient)) {
                allIndex[pos] = index;
                pos++;
            }
        }
        int[] newAll = new int[pos];
        System.arraycopy(allIndex, 0, newAll, 0, pos);
        return newAll;
    }

    /**
     * Values for inbox
     * 
     * @param index int array of all index
     * @return all messages of a recipient
     */
    public static String inbox(int[] index) {
        String inboxMessages = "";

        for (int i : index) {
            inboxMessages += "From: " + getSender()[i] + "\n" + getMessage()[i]
                    + "\n-----------------------------------------------------------------------------------------------";
        }
        return inboxMessages;
    }
    /*
     * From: 123Test@email.com
     * Message Here
     */

    public static int[] reverse(int[] input) {
        int[] newArr = new int[input.length];
        int pos = 0;
        for (int x = input.length - 1; x >= 0; x--) {
            newArr[pos] = input[x];
            pos++;
        }
        return newArr;
    }

    // {email, messageNum0, email, messageNum1 ...}
    public String toString() // recipient1, message2, sender3, etc etc...
    {
        String[] copyStorage = new String[numTotal];
        System.arraycopy(storageVault, 0, copyStorage, 0, copyStorage.length);
        return Arrays.toString(copyStorage);
    }

}