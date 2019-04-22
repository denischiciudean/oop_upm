import java.util.*;
import java.lang.Math.*;
class Singleton {
  public static Singleton instance = null;

  public static Singleton getInstance(){
    if(instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  public void afisareMesaj(String _s){
    System.out.println(_s);
  }

  public void afisareMesaj(String _s, int _i){
    System.out.println(_s.replace("{int}", Integer.toString(_i)));
  }

  public void afisareMesaj(String _s, double _d){
    System.out.println(_s.replace("{double}",Double.toString( _d)));
  }


}

class Main {
  public static void main(String args[]){
    Singleton sing = new Singleton();

    Scanner sc = new Scanner(System.in);
    sing.afisareMesaj("a:");
    int a = sc.nextInt();
    sing.afisareMesaj("b:");
    int b = sc.nextInt();

    sing.afisareMesaj("Rezulatul a*b este : {int}",  a*b);
    sing.afisareMesaj("Rezulatul sqrt(a) este : {double}",  Math.sqrt(a));
    sing.afisareMesaj("Rezulatul a^b este : {double}",  Math.pow(a,b));
    sing.afisareMesaj("Rezulatul a*x+b este : {int}",  a * sc.nextInt() + b);

  }
}
