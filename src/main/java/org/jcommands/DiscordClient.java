package org.jcommands;

import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordClient {
    private final String token;
    private final int cooldown;
    private final boolean allowLegacy;
    private final char prefix;
    private final GatewayIntent[] intents;

    public DiscordClient(String token, int cooldown, boolean allowLegacy, char prefix, GatewayIntent[] intents) {
        this.token = token;
        this.cooldown = cooldown;
        this.allowLegacy = allowLegacy;
        this.prefix = prefix;
        this.intents = intents;
    }
    public void login() {

    }
}
