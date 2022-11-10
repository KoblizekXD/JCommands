package org.jcommands;

import com.koblizek.logging.LogFactory;
import com.koblizek.logging.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jcommands.listeners.DefaultListener;

import java.util.Arrays;

public class DiscordClient {
    private final String token;
    private final int cooldown;
    private final boolean allowLegacy;
    private final char prefix;
    private final GatewayIntent[] intents;
    private final Logger logger;
    private JDA jda;
    private JDABuilder builder;
    private boolean on = false;

    public DiscordClient(String token, int cooldown, boolean allowLegacy, char prefix, GatewayIntent[] intents) {
        this.token = token;
        this.cooldown = cooldown;
        this.allowLegacy = allowLegacy;
        this.prefix = prefix;
        this.intents = intents;
        this.logger = LogFactory.newAdvanced();
        JDABuilder builder = JDABuilder.createDefault(token);
        if (intents != null) builder.setEnabledIntents(Arrays.asList(intents));
        this.builder = builder;
    }
    public void login() {
        jda = builder.build();
        jda.addEventListener(new DefaultListener());
        try {
            jda.awaitReady();
            on = true;
            logger.info("Logged in as " + jda.getSelfUser().getName());
        } catch (InterruptedException e) {
            logger.exception(e);
        }
    }
    public void setActivity(Activity activity) {
        jda.getPresence().setActivity(activity);
    }
    public void setStatus(OnlineStatus status) {
        jda.getPresence().setStatus(status);
    }
    private boolean isOn() {
        return on;
    }
}
