public class NotifierTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        Notifier smsAndEmail = new SMSNotifierDecorator(notifier);
        Notifier allChannels = new SlackNotifierDecorator(smsAndEmail);

        allChannels.send("Server maintenance scheduled at midnight");
    }
}
