import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class Laborator2{
  public static void main(String args[]){
      ContBancar account = new ContBancar(500);
      Random rn = new Random();
      int n = rn.nextInt(1000);
      account.deposit(300);
      System.out.println(account.getSold());


      for (int i = 0; i <= n; i++) {

        int op = rn.nextInt(2);

        double cash = ThreadLocalRandom.current().nextDouble(0, 100);
        if(op % 2 == 0){
            account.deposit(cash);
        }else{
            account.withdraw(cash);
        }
        System.out.println(account.getSold());
      }
  }
}
