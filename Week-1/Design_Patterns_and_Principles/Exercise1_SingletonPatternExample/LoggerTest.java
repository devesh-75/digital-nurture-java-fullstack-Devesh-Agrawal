public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");
        logger2.log("Fetching data");

        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("Total logs recorded: " + logger1.getLogCount());
    }
}
