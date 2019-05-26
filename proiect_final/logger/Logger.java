package logger;

import java.io.FileWriter;
import java.util.*; //Has Date (class that contains information about the current date) (Uses system time in milliseconds)
import java.text.*; //Has DateFormat (Formatter for class Date)

public class Logger {

    private static Logger log = null;

    public static Logger getInstance() {
        if (log == null) {
            log = new Logger();
            log.initalize();
        }
        return log;
    }

    private FileWriter writer = null;

    public void initalize() {
        try {
            this.writer = new FileWriter("./logs/log.txt");
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    public void logMessage(String _s) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        Date date = new Date();
        try {
            this.writer.write("[" + dateFormat.format(date) + "] INFO: " + _s + "\n");
        } catch (Exception e) {
            System.out.println("Could not write to file");
        }

    }

    public static void LogStaticMessage(String _s){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        Date date = new Date();

        Logger log = getInstance();

        try {
            log.writer.write("[" + dateFormat.format(date) + "] INFO: " + _s + "\n");
        } catch (Exception e) {
            System.out.println("Could not write to file");
        }
    }

    public void close() {
        try {
            this.writer.close();
        } catch (Exception e) {
            System.out.println("Could not close file");
        }
    }

}