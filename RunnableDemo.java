import edu.redwoods.singleton.LazyInitializedSingleton;

import java.util.Random;

class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;
    private Random random = new Random();

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        int sleeper = random.nextInt(200)+100;
        try {
            for(int i = 4; i>0; i--) {
                System.out.println("Thread: "+threadName+", "+i);
                //have thread sleep for random time
                Thread.sleep(sleeper);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread "+threadName+" interrupted.");
        }
        System.out.println("Thread "+threadName+" exiting.");

        LazyInitializedSingleton singleton = LazyInitializedSingleton.getInstance();
        System.out.println(singleton.hashCode());
    }

    public void start () {
        System.out.println("Starting "+threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}