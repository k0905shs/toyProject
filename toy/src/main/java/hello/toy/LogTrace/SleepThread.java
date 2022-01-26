package hello.toy.LogTrace;

public class SleepThread {
    public static void sleep(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

