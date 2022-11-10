import org.jcommands.DiscordAPI;
import org.jcommands.DiscordClient;

public class Main {
    public static void main(String[] args) {
        DiscordClient client = DiscordAPI.createNewDiscordBot(args[0]).build();

        client.login();
    }
}
