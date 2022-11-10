import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.jcommands.DiscordAPI;
import org.jcommands.DiscordClient;

public class Main {
    public static void main(String[] args) {
        DiscordClient client = DiscordAPI.createNewDiscordBot(args[0]).build();
        client.login();
        client.setStatus(OnlineStatus.DO_NOT_DISTURB);
        client.setActivity(Activity.listening("to your mom"));
    }
}
