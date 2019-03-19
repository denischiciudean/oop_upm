import java.util.*;
import org.json.simple.JSONObject;

public class Laborator{

  public void def(){

    Scanner sc = new Scanner(System.in);

    System.out.println("Introduceti numar: ");
    int nr = sc.nextInt();

    Random rn = new Random();

    for (int i = 0; i < nr ; ++i) {
      System.out.println("Urmatorul numar : " + rn.nextInt(255));
    }

  }

  public static void main(String args[]){

    Laborator lab = new Laborator();
  //  lab.def();

    ExercitiuUnu ex = new ExercitiuUnu();
  //  ex.main();

    ExercitiuDoi ex_doi = new ExercitiuDoi();
    //  ex_doi.main();

    ExercitiuTrei ex_trei = new ExercitiuTrei();
    //  ex_trei.main();

    ExercitiuPatru ex_patru = new ExercitiuPatru();
      ex_patru.main();
  }

}

public class ExercitiuUnu{

  public void main(){
    Scanner sc = new Scanner(System.in);

    System.out.println("nr 1");
    int a = sc.nextInt();
    System.out.println("nr 2");
    int b = sc.nextInt();

    System.out.println("Suma : " + this.suma(a, b) + " || Produsul : " + this.produs(a,b));

    Random rn = new Random();
    int random_int = rn.nextInt(255);

    System.out.println("Numar random a : " + (a*random_int) + " || Numar random b : " + (b*random_int));
  }

  public int suma(int a, int b){
    return a+b;
  }

  public int produs(int a, int b){
    return a*b;
  }
}

public class ExercitiuDoi{

  public void main(){

    Scanner sc = new Scanner(System.in);
    int nr = sc.nextInt();

    System.out.println("Last digit parity : " + this.last_parity(nr));
    System.out.println("First digit parity : " + this.first_parity(nr));
    System.out.println("Digit sum : " + this.digit_sum(nr));

  }

  public boolean last_parity(int nr){

    return ((nr % 10 % 2) == 0) ? true : false;
  }

  public boolean first_parity(int nr){

    int first_digit = Integer.parseInt(Integer.toString(nr).substring(0,1));

    return first_digit % 2 == 0 ? true : false;
  }

  public int digit_sum(int nr){

    String s = Integer.toString(nr);
    int sum = 0;

    for(int i = 0; i < s.length(); i++){
     char ch = s.charAt(i);
     sum+= Integer.parseInt(String.valueOf(ch));
    }

    return sum;
  }

}

public class ExercitiuTrei{
  public void main(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Lungime sir numere : ");
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("1. Max | 2. Min | 3. Sum | 4. Sum Prime");
    int switcher = sc.nextInt();

    switch (switcher) {
            case 1:
             System.out.println("Max : " +this.maxim(arr));
                     break;
            case 2:
            System.out.println("Min : " +this.min(arr));
                     break;
            case 3:
            System.out.println("Sum : " +this.sum(arr));
                     break;
            case 4:
            System.out.println("Sum Prime : " +this.sum_prime(arr));
                     break;
    }
  }

  public int maxim(int[] arr){

    int max = 0;

    for (int i = 0; i < arr.length; i++) {

      if(arr[i] > max){
          max = arr[i];
      }

    }

    return max;
  }

  public int min(int[] arr){

    int min = 0;

    for (int i = 0; i < arr.length; i++) {
      if(i == 0){
          min = arr[i];
      }
      if(arr[i] < min){
          min = arr[i];
      }
    }
    return min;
  }

  public int sum(int[] arr){

    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      if(arr[i] % 2 == 0){
          sum+= arr[i];
      }
    }

    return sum;
  }

  public int sum_prime(int[] arr){

    int prods = 1;

    for (int i = 0; i < arr.length; i++) {

      int deviders = 0;

      for (int j = 2; j< arr[i]; j++) {
          if(arr[i] % j == 0){
              deviders++;
          }
      }

      if(deviders == 0){
        System.out.println("Multypling " + arr[i] + " with " + prods);
        prods *= arr[i];
      }

    }

    if(prods == 1) prods = 0;

    return prods;
  }

}

public class ExercitiuPatru{
  public void main(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Lungime matrice numere n x m : ");
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.println("[" + i + "][" + j +"] : ");
        arr[i][j] = sc.nextInt();
      }
    }

    System.out.println("1. Min linii max Coloane | 2. Diagonale principala & secundara | 3. Switch first with last line | 4. Remove column c and line l | 5. Produs Prime");
    int switcher = sc.nextInt();

    switch (switcher) {
            case 1:
             System.out.println("Max : ");
                     break;
            case 2:
            System.out.println("Min : " );
                     break;
            case 3:
            System.out.println("Sum : " );
                     break;
            case 4:
            System.out.println("Sum Prime : ");
                     break;
           case 5:
           System.out.println("Sum Prime : " );
                    break;
    }
  }


//  public JSONObject min_linii_max_coloane(int[][] arr, int n, int m){
    JSONObject obj = new JSONObject();

    int[] lines;

    for (int i = 0; i < n; i++ ) {
      for (int j = 0; j < m; j++ ) {


      }
    }

  }
}
