import java.util.*;

class Main{

  public static void fletcher(String _s){
    byte[] bytes = _s.getBytes();

    byte sum1=0;
    byte sum2=0;

    for (int i = 0;i < bytes.length;i++) {

      sum1 = (byte) ((sum1+bytes[i])%255);
      sum2 = (byte) ((sum1+sum2)%255);

    }

    byte check = (byte)((sum2 << 8) | sum1);

    System.out.println(check);
    System.out.println(sum1);
    System.out.println(sum2);

  }

  public static void testing(int n){

    n = 5;

  }

  public static void main(String args[]){

    // Scanner sc = new Scanner(System.in);

    // String _s = sc.nextLine();

    // fletcher(_s);

    int x = 10;
    testing(x);
    System.out.println(x);

  }
}
