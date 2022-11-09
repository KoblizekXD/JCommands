package org.jcommands;

import net.dv8tion.jda.api.requests.GatewayIntent;

public final class DiscordAPI {
    private DiscordAPI() {}

    public static Builder createNewDiscordBot(String token) {
        return new Builder().setToken(token);
    }
    public static Builder createNewDiscordBot() {
        return new Builder();
    }
    public static class Builder {
        private String token;
        private int seconds;
        private char prefix;
        private boolean allowMessages = false;
        private GatewayIntent[] intents;

        private Builder() {}
        public Builder setToken(String token) {
            this.token = token;
            return this;
        }
        public Builder setCommandCooldown(int seconds) {
            this.seconds = seconds;
            return this;
        }
        public Builder allowMessageCommands(char prefix) {
            this.prefix = prefix;
            this.allowMessages = true;
            return this;
        }
        public Builder setIntents(GatewayIntent[] intents) {
            this.intents = intents;
            return this;
        }
        public DiscordClient build() {
            return new DiscordClient(token, seconds, allowMessages, prefix, intents);
        }
    }
}
