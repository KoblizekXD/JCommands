import net.dv8tion.jda.api.EmbedBuilder;
import org.jcmds.JAPI;
import org.jcmds.commands.lambda.legacy.LegacyCommand;
import org.jcmds.error.JAPIException;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Start {
    public static void main(String @NotNull [] args) throws LoginException, InterruptedException, JAPIException {
        JAPI.initialize(args[0]);
        JAPI.setGuildID("947145508395311176");
        JAPI.setLegacyCommandPrefix("!");
        new LegacyCommand("help", "help command" , 0, event -> {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setAuthor("Help");
            for (var cmd : LegacyCommand.commands) {
                builder.addField(cmd.getName(), cmd.getDescription(), false);
            }
            event.getMessage().replyEmbeds(builder.build()).queue();
        });
        new LegacyCommand("ping", "replies with bot ping", 0, event -> {
            event.getMessage().reply(event.getJDA().getRestPing().complete().toString()).queue();
        });

    }
}
