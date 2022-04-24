import org.jcmds.commands.extendable.legacy.LegacyCommand;
import org.jcmds.commands.lambda.event.LegacyCommandReceivedEvent;

public class TestCommand extends LegacyCommand {
    public TestCommand() {
        super("name", "description", 0);
    }
    @Override
    public void onInteraction(LegacyCommandReceivedEvent event) {
        event.reply("Nah");
    }
}