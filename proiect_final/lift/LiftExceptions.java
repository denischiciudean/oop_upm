package lift;

public class LiftExceptions extends Exception {

    private String text;

    LiftExceptions(Integer errorCode) {
        if (errorCode == 101) {
            text = "Input floor is either way to high, or way to low";
        }
    }

    public String toString() {
        return "CustomException[" + text + "]";
    }
}
