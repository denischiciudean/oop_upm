package lift;

public class Lift {

    public Integer currentFloor = 2;

    private Integer maxFloor;

    public Lift(Integer maxFloors) {
        maxFloors = maxFloor;
    }

    public void callLift(Integer yourFloor) {

        if (yourFloor < currentFloor) {

            for (; currentFloor > yourFloor; currentFloor--) {
                System.out.println("Changin floor");
                System.out.println(currentFloor);
                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }


            }

        } else if (yourFloor > currentFloor) {
            for (; yourFloor > currentFloor; currentFloor++) {
                System.out.println(currentFloor);
                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

        }

    }

    public void goToFloor(Integer destination) {

        if (currentFloor > destination) {
            for (; currentFloor > destination; currentFloor--) {
                System.out.println(currentFloor);
                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        } else if (currentFloor < destination) {
            for (; currentFloor < destination; currentFloor++) {
                System.out.println(currentFloor);
                try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

        }

    }

}
