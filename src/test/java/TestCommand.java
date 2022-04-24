import org.jcmds.commands.extendable.legacy.LegacyCommand;
import org.jcmds.commands.extendable.slash.SlashCommand;
import org.jcmds.commands.lambda.event.LegacyCommandReceivedEvent;
import org.jcmds.commands.lambda.event.SlashCommandEvent;

public class TestCommand extends LegacyCommand {
    public TestCommand() {
        super("name", "description", 0);
    }
    @Override
    public void onInteraction(LegacyCommandReceivedEvent event) {
        event.reply("Nah");
    }
}