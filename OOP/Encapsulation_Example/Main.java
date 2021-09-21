import java.util.HashMap;
import java.util.UUID;

public class Main {
  public static void main(String[] args) {
    Banking_Service Bank = new Banking_Service();
    UUID AccountId = Bank.RequestCreateNewAccount();
    System.out.println("New Account Id : " + AccountId);
    System.out.println(Bank.RequestAccountBalance(AccountId));
    System.out.println(Bank.RequestAddCoinsToAccount(AccountId, 150));
    System.out.println(Bank.RequestAccountBalance(AccountId));
    System.out.println(Bank.RequestWithdrawCoinsFromAccount(AccountId, 100));
    System.out.println(Bank.RequestAccountBalance(AccountId));
    System.out.println(Bank.RequestWithdrawCoinsFromAccount(AccountId, 100));
    System.out.println(Bank.RequestAccountBalance(AccountId));
    System.out.println(Bank.RequestDisableAccount(AccountId));
    System.out.println(Bank.RequestEnableAccount(AccountId));
    System.out.println(Bank.RequestAddCoinsToAccount(AccountId, 100));
    System.out.println(Bank.RequestWithdrawCoinsFromAccount(AccountId, 100));
    System.out.println(Bank.RequestDeleteAccount(AccountId));
    System.out.println(Bank.RequestAccountBalance(AccountId));
  }
}

public class Banking_Service {
  private final HashMap<UUID, Account> AccountList = new HashMap<>();

  public Banking_Service() {
    System.out.println("Banking Service : Start.");
  }

  public UUID RequestCreateNewAccount() {
    System.out.println("Banking Service : Request Create New Account.");
    return AddNewAccount();
  }

  private UUID AddNewAccount() {
    UUID NewAccountId = UUID.randomUUID();
    Account NewAccount = new Account(NewAccountId);
    AccountList.put(NewAccountId, NewAccount);
    System.out.println("Banking Service : New Account Created.");
    return NewAccountId;
  }

  public String RequestDeleteAccount(UUID AccountId) {
    System.out.println("Banking Service : Request Delete Account.");
    return DeleteAccount(AccountId);
  }

  private String DeleteAccount(UUID AccountId) {
    String Message;
    if (AccountExist(AccountId)) {
      AccountList.remove(AccountId);
      Message = new String("The Account ").concat(String.valueOf(AccountId));
      Message = Message.concat(" was Deleted.");
    } else {
      Message = "Sorry, Your Account does not Exist.";
    }
    return Message;
  }

  public String RequestAccountBalance(UUID AccountId) {
    System.out.println("Banking Service : Request Account Balance.");
    return FindAccountBalance(AccountId);
  }

  private String FindAccountBalance(UUID AccountId) {
    String Message;
    if (AccountExist(AccountId)) {
      Message = "Your balance is ";
      Message = Message.concat(AccountList.get(AccountId).GetCoinsAmount());
      Message = Message.concat(" Coins");
    } else {
      Message = "Sorry, Your Account does not Exist.";
    }
    return Message;
  }

  public String RequestAddCoinsToAccount(UUID AccountId, long Amount) {
    System.out.println("Banking Service : Request Add Coins To Account.");
    return AddCoins(AccountId, Amount);
  }

  private String AddCoins(UUID AccountId, long Amount) {
    String Message;
    if (AccountExist(AccountId)) {
        Message = AccountList.get(AccountId).AddCoinsToAccount(Amount);
    } else {
        Message = "Sorry, Your Account does not Exist.";
    }
    return Message;
  }

  public String RequestWithdrawCoinsFromAccount(UUID AccountId, long Amount) {
    System.out.println("Banking Service : Requst Withdrawn Coins From Account.");
    return WithdrawCoins(AccountId, Amount);
  }

  private String WithdrawCoins(UUID AccountId, long Amount) {
    String Message;
    if (AccountExist(AccountId)) {
      Message = AccountList.get(AccountId).WithdrawCoinsFromAccount(Amount);
    } else {
      Message = "Sorry, Your Account does not Exist.";
    }
    return Message;
  }

  public String RequestDisableAccount(UUID AccountId) {
    System.out.println("Banking Account : Request Disable Account.");
    return DisableAccount(AccountId);
  }

  private String DisableAccount(UUID AccountId) {
    String Message;
    if (AccountExist(AccountId)) {
      AccountList.get(AccountId).SetAccountEnabled(false);
      Message = new String("The Account ").concat(String.valueOf(AccountId));
      Message = Message.concat(" was Disabled.");
    } else {
      Message = "Sorry, Your Account does not Exist.";
    }
    return Message;
  }

  private boolean AccountExist(UUID AccountId) {
    return AccountList.containsKey(AccountId);
  }

  public String RequestEnableAccount(UUID AccountId) {
    System.out.println("Banking Service : Request Enable Account.");
    return EnableAccount(AccountId);
  }

  private String EnableAccount(UUID AccountId) {
    String Message;
    if (AccountExist(AccountId)) {
      Message = "Sorry, at this time the system is out of service.";
      Message = Message.concat("\nIf you need to contact us you can do it on Wednesdays and Sundays");
      Message = Message.concat("\nBetween 3 AM and 6 AM at the number 555-55555.");
      Message = Message.concat("\nHave a nice day.");
    } else {
      Message = "Sorry, Your Account does not Exist.";
    }
    return Message;
  }
}

public class Account {
  private UUID AccountId;
  private long CoinsAmount = 0;
  private boolean AccountEnabled = true;

  public Account(UUID AccountId) {
    this.AccountId = AccountId;
  }

  public boolean AccountEnabled() {
    return AccountEnabled;
  }

  public void SetAccountEnabled(boolean Enabled) {
    AccountEnabled = Enabled;
  }

  public String GetCoinsAmount() {
    return String.valueOf(CoinsAmount);
  }

  public String AddCoinsToAccount(long Amount) {
    return AddCoins(Amount);
  }

  private String AddCoins(long Amount) {
    String Message;
    if (AccountEnabled) {
        CoinsAmount += Amount;
        Message = String.valueOf(Amount).concat(" Coins Successfully added to your Account.");
    } else {
      Message = "Sorry, Your Account is Disabled.";
    }
    return Message;
  }

  public String WithdrawCoinsFromAccount(long Coins) {
      return WithdrawCoins(Coins);
  }

  private String WithdrawCoins(long Coins) {
    String Message;
    if (AccountEnabled) {
      if (CanWithdrawThisAmmount(Coins)) {
        CoinsAmount -= Coins;
        Message = new String("You have Successfully Withdrawn ");
        Message = Message.concat(String.valueOf(Coins));
        Message = Message.concat(" Coins from your Account.");
      } else {
        Message = "Sorry, Your Account does not have the Necessary Balance to carry out this Operation.";
      }
    } else{
      Message = "Sorry, Your Account is Disabled.";
    }
    return Message;
  }

  private boolean CanWithdrawThisAmmount(long Amount) {
    return ((CoinsAmount - Amount) >= 0);
  }
}
