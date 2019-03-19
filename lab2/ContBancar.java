public class ContBancar{
  private double sold = 0.0;

  public ContBancar(double _sold){
      sold = _sold;
  }

  public void deposit(double cash){
    sold += cash;
  }

  public double getSold(){
    return sold;
  }

  public boolean withdraw(double cash){
    if(sold >= cash){
      sold -= cash;
      return true;
    }
    return false;
  }
}
