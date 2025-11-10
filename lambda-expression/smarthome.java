interface LightAction {
    void activate();
}

public class SmartHome {
    public static void main(String[] args) {
        // Different light patterns using lambda expressions
        LightAction motionTrigger = () -> System.out.println("Lights ON with motion sensor pattern!");
        LightAction nightTrigger = () -> System.out.println("Lights dimmed for night mode.");
        LightAction voiceCommand = () -> System.out.println("Voice command: Set party lights!");

        // Simulate triggers
        motionTrigger.activate();
        nightTrigger.activate();
        voiceCommand.activate();
    }
}
