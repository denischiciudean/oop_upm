import java.util.*;

public class Ex3{

  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
  //  System.out.println("N instante : ");
    int instante = sc.nextInt();
    sc.nextLine();
    Car volvo_alb = new Car("volvo", "alb", 200);

    Car[] masini = new Car[instante];

    for (int i = 0; i< instante; i++ ) {

      System.out.println("["+i+"] "+"Set type :");
      String type = sc.nextLine();

      System.out.println("["+i+"] "+"Set colour :");
      String colour = sc.nextLine();

      System.out.println("["+i+"] "+"Set speed :");
      double speed = sc.nextDouble();
      sc.nextLine();
      masini[i] = new Car(type,colour, speed);

    }

    for (int i = 0; i < instante ; i++ ) {
        System.out.println(masini[i].toString());
    }
  }

}

public class Car{
  private String type;
  private String colour;
  private double speed;

  public Car(String _type, String _colour, double _speed){
    type = _type;
    colour = _colour;
    speed = _speed;
  }

  public String getType(){
      return type;
  }
  public void setType(String _type){
      type = _type;
  }


  public String getColour(){
      return colour;
  }
  public void setColour(String _colour){
    colour = _colour;
  }


  public double getSpeed(){
    return speed;
  }
  public void setSpeed(double _speed){
    speed = _speed;
  }

  public String toString(){
    return type + " - " + colour + " - " + speed;
  }

}
