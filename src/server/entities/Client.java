package server.entities;

public class Client {
   final double RATE = 0.035;
   private long accNumber;
   private String name;
   private double balance;

   public Client(){
   }

   public Client(long accNumber, String name, double balance){
       this.accNumber = accNumber;
       this.name = name;
       this.balance = balance;
   }

   public Client(long accNumber, String name){
       this.accNumber = accNumber;
       this.name = name;
   }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\"" + accNumber + "\",\"" + name + "\",\"" + balance + "\"";
    }
}
