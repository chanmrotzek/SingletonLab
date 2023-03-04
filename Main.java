public class Main {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        RunnableDemo R2 = new RunnableDemo("Thread-2");
        RunnableDemo R3 = new RunnableDemo("Thread-3");

        R1.start();
        R2.start();
        R3.start();

    }
}