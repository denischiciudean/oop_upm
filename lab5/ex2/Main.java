import java.io.FileWriter;
import java.util.*;
import java.lang.*;
import java.text.*;

class Logger {
  public static Logger log = null;

  public static Logger getInstance(){
    if(log == null) {
      log = new Logger();
    }
    return log;
  }

  public String filePath  = null;

  public FileWriter writer = null;

  public void initalize(String filePath){
    try{
    this.writer = new FileWriter(filePath);
    }catch(Exception e){
      System.out.println("File not found!");
    }
  }

  public void logMessage(String _s){
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
    Date date = new Date();
    try{
      this.writer.write("["+dateFormat.format(date)+"] INFO: " + _s + "\n");
    }catch(Exception e){
      System.out.println("Could not write to file");
    }

  }

  public void close(){
    try{
    this.writer.close();
  }catch(Exception e){
      System.out.println("Could not close file");
    }
  }

}

class LoggerEx {

  public FileWriter writer = null;

  public void initalize(String filePath){
    try{
    this.writer = new FileWriter(filePath);
    }catch(Exception e){
      System.out.println("File not found!");
    }
  }

  public void logMessage(String _s){
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
    Date date = new Date();
    try{
      this.writer.write("["+dateFormat.format(date)+"] INFO: " + _s + "\n");
    }catch(Exception e){
      System.out.println("Could not write to file");
    }

  }

  public void close(){
    try{
    this.writer.close();
  }catch(Exception e){
      System.out.println("Could not close file");
    }
  }

}

class Main{
  public static void main(String args[]){

    Scanner sc = new Scanner(System.in);

    LoggerEx lg = new LoggerEx();

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    lg.initalize("/tmp/java/logger-" +dateFormat.format(date)+".log");

    int n = sc.nextInt();

    for (int i = 0;i <= n; i++) {
      lg.logMessage(sc.nextLine());
    }

    lg.close();
  }
}
