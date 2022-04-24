import net.dv8tion.jda.api.EmbedBuilder;
import org.jcmds.JAPI;
import org.jcmds.commands.lambda.legacy.LegacyCommand;
import org.jcmds.error.JAPIException;
import org.jetbrains.annotations.NotNull;
import javax.security.auth.login.LoginException;

public class Start {
    public static void main(String @NotNull [] args) throws LoginException, InterruptedException, JAPIException {
        JAPI.initialize(args[0]);
        JAPI.setGuildID(args[1]);
        JAPI.setLegacyCommandPrefix("!");
        new LegacyCommand("help", "help command" , 0, event -> {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setAuthor("Help");
            for (var cmd : LegacyCommand.commands) {
                builder.addField(cmd.getName(), cmd.getDescription(), false);
            }
            event.replyEmbeds(builder.build());
        });
        new LegacyCommand("name", "description", 0, event -> event.reply("Hello world!"));
    }
}
