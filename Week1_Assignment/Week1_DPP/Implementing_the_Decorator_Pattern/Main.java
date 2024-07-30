public class Main {
    
    // Notifier Interface
    public interface Notifier {
        void send(String message);
    }

    // EmailNotifier Class
    public static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending Email with message: " + message);
        }
    }

    // NotifierDecorator Class
    public static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        @Override
        public void send(String message) {
            wrappedNotifier.send(message);
        }
    }

    // SMSNotifierDecorator Class
    public static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS with message: " + message);
        }
    }

    // SlackNotifierDecorator Class
    public static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSlackMessage(message);
        }

        private void sendSlackMessage(String message) {
            System.out.println("Sending Slack message: " + message);
        }
    }

    // Main method to test the decorators
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier emailAndSMSNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier emailAndSMSAndSlackNotifier = new SlackNotifierDecorator(emailAndSMSNotifier);

        System.out.println("Sending notification via Email:");
        emailNotifier.send("Hello via Email!");

        System.out.println("\nSending notification via Email and SMS:");
        emailAndSMSNotifier.send("Hello via Email and SMS!");

        System.out.println("\nSending notification via Email, SMS, and Slack:");
        emailAndSMSAndSlackNotifier.send("Hello via Email, SMS, and Slack!");
    }
}
