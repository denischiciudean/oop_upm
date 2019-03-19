import java.util.*;


class OpMatrici {

  public static int inst = 0;

  public OpMatrici(){
    inst += 1;
  }


  public static void main(String args[]){
  }

  public static int sum(int _one[], int _two[]){
    int rezultat = 0;
    for (int i = 0; i < _one.length; i++) {
    rezultat += _one[i] + _two[i];
    }
    return rezultat;
  }

  public static int diff(int _one[], int _two[]){
    int rezultat = 0;
    for (int i = 0; i < _one.length; i++) {
    rezultat -= _one[i] - _two[i];
    }
    return rezultat;

  }

  public static int multiply(int _one[], int _two[]){
    int rezultat = 1;
    for (int i = 0; i < _one.length; i++) {
    rezultat *= _one[i] * _two[i];
    }
    return rezultat;

  }

  public static double divide(int _one[], int _two[]){
    double rezultat = 1;
    for (int i = 0; i < _one.length; i++) {
      rezultat /= _one[i] / _two[i];
    }
    return rezultat;
  }

}

class ExtendedOpMatrici extends OpMatrici {

  private int[] vec;

  public ExtendedOpMatrici(int n){
    vec = new int[n];
    for (int i = 0; i < n; i++) {
      vec[i] = 0;
    }
  }

  public int ext_sum(int[] _one){
    int rezultat = 0;
    int _rezultat = 0;

    for (int i = 0;i < _one.length ; i++) {
      _rezultat = _one[i] + vec[i];
      vec[i] = _rezultat;
      rezultat += _rezultat;
    }
    return rezultat;
  }

  public int ext_diff(int[] _one, int[] _two){
    int rezultat = 0;
    int _rezultat = 0;

    for (int i = 0;i < _one.length ; i++) {
      _rezultat = _one[i] - vec[i];
      vec[i] = _rezultat;
      rezultat -= _rezultat;
    }
    return rezultat;
  }

  public int ext_mul(int[] _one, int[] _two){
    int rezultat = 1;
    int _rezultat = 1;
    for (int i = 0;i < _one.length ; i++) {
      _rezultat = _one[i] * vec[i];
      vec[i] = _rezultat;
      rezultat *= _rezultat;
    }
    return rezultat;
  }

  public int ext_div(int[] _one, int[] _two){
    int rezultat = 1;
    int _rezultat = 1;

    for (int i = 0;i < _one.length ; i++) {
      _rezultat = _one[i] / vec[i];
      vec[i] = _rezultat;
      rezultat /= _rezultat;
    }
    return rezultat;
  }

  public void displayVector(){
    System.out.println("");

    System.out.print("[");
    for (int i = 0; i<vec.length; i++ ) {
      if(i == vec.length-1){
        System.out.print(vec[i]);
      }else{
        System.out.print(vec[i] + ", ");
      }
    }
    System.out.print("]");
  }

}

class OpMatriciCountInstances extends ExtendedOpMatrici{

  public OpMatriciCountInstances(int n){
    super(n);
  }

  public static int getNumInst(){
      return inst;
  }
}

class Laborator4 {

  public static void main(String args[]){

    Scanner sc = new Scanner(System.in);

    System.out.println("Dimensiune vectori :");
    int n = sc.nextInt();

    int[] vector_1 = new int[n];
    int[] vector_2 = new int[n];

    for (int i = 0; i < n;  i++) {
      System.out.println("Vector 1 - " + i);
      vector_1[i] = sc.nextInt();
    }
    for (int i = 0; i < n;  i++) {
      System.out.println("Vector 2 - " + i);
      vector_2[i] = sc.nextInt();
    }

    ExtendedOpMatrici ex = new ExtendedOpMatrici(n);

    OpMatriciCountInstances counting = new OpMatriciCountInstances(n);

    //op.displayVector();
    //System.out.println(op.ext_sum(vector_1));
    //op.displayVector();
    //System.out.println(op.ext_sum(vector_1));
    //op.displayVector();

     System.out.println(OpMatriciCountInstances.getNumInst());

    // System.out.println(ExtendedOpMatrici.sum(vector_1, vector_2));
    // System.out.println(OpMatrici.diff(vector_1, vector_2));
    // System.out.println(OpMatrici.multiply(vector_1, vector_2));
    // System.out.println(OpMatrici.divide(vector_1, vector_2));

  }
}
