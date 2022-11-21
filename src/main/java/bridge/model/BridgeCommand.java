package bridge.model;

public class BridgeCommand {

    private final String command;

    private BridgeCommand(String command) {
        validateRetry(command);
        this.command = command;
    }

    public static BridgeCommand createBridgeCommand(String command) {
        return new BridgeCommand(command);
    }

    public boolean getCommand() {
        return command.equals(Command.RETRY.getDescription());
    }

    public void validateRetry(String command) {
        if (isRetryFormatCorrect(command)) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.RETRY_NON_FORMAT_ERROR_MESSAGE.getMessage());
    }

    private static boolean isRetryFormatCorrect(String command) {
        return command.equals("R") || command.equals("Q");
    }
}