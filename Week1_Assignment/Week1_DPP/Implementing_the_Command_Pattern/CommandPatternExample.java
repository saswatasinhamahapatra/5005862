public class CommandPatternExample {

    // Command Interface
    public interface Command {
        void execute();
    }

    // Receiver Class
    public static class Light {
        public void turnOn() {
            System.out.println("The light is on");
        }

        public void turnOff() {
            System.out.println("The light is off");
        }
    }

    // Concrete Command for turning the light on
    public static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    // Concrete Command for turning the light off
    public static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Invoker Class
    public static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    // Test the Command Pattern
    public static void main(String[] args) {
        // Create the receiver
        Light light = new Light();

        // Create concrete command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create the invoker
        RemoteControl remote = new RemoteControl();

        // Set and execute the command to turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Set and execute the command to turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
