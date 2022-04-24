import org.jcmds.commands.extendable.slash.SlashCommand;
import org.jcmds.commands.lambda.event.SlashCommandEvent;

public class TestCommand extends SlashCommand {
    public TestCommand() {
        super("name", "description", true);
    }
    @Override
    public void onInteraction(SlashCommandEvent event) {
        event.reply("Nah");
    }
}
