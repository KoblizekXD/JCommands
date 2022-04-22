package org.jcmds;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jcmds.error.JAPIException;
import org.jcmds.listeners.DefaultAdapter;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public final class JAPI {
    private JAPI() {}

    private static JDA api;
    private static String guildID;
    private static List<ListenerAdapter> adapters;
    private static boolean initialized = false;
    private static String prefix;

    /**
     * Initialize the bot and starts it
     *
     * @param token Token of the bot.
     * @throws LoginException When the token is invalid
     * @throws InterruptedException When error occurs in creating bot
     * @throws JAPIException When API is initialized multiple times
     *
     * @see #initialize(JDA)
     */
    public static void initialize(String token) throws LoginException, InterruptedException, JAPIException {
        if (initialized) throw new JAPIException("Cannot initialize the API multiple times.");
        api = JDABuilder.createDefault(token).build().awaitReady();
        adapters = new ArrayList<>();
        adapters.add(new DefaultAdapter());
        api.addEventListener(adapters.toArray());
        initialized = true;
    }

    /**
     * Initialize the bot and starts it
     * Can throw LoginException & InterruptedException as well
     *
     * @param jda JDA custom interface
     * @throws JAPIException When API is initialized multiple times
     * @see #initialize(String)
     */
    public static void initialize(JDA jda) {
        if (initialized) throw new JAPIException("Cannot initialize the API multiple times.");
        api = jda;
        initialized = true;
    }
    public static void setGuildID(String guildId) {
        guildID = guildId;
    }
    public static String getGuildID() {
        return guildID;
    }
    private static boolean isNotInitialized() {
        return !initialized;
    }
    /**
     * Adds custom adapter to JDA
     *
     * @param adapter adds provided adapter to JDA
     */
    public static void addEventListener(ListenerAdapter adapter) {
        api.addEventListener(adapter);
        adapters.add(adapter);
    }
    /**
     * Adds custom adapter to JDA
     *
     * @param adapter adds provided array of adapters to JDA
     */
    public static void addEventListener(ListenerAdapter ... adapter) {
        api.addEventListener((Object[]) adapter);
        adapters.addAll(List.of(adapter));
    }

    /**
     * Adds custom adapter to JDA
     *
     * @param adapter adds provided collection of adapters to JDA
     */
    public static void addEventListener(Collection<ListenerAdapter> adapter) {
        api.addEventListener(adapter);
        adapters.addAll(adapter);
    }

    /**
     * Returns JDA
     *
     * @return current JDA
     * @throws JAPIException when JDA isn't initialized
     */
    public static JDA getJDA() {
        if (api!=null) return api;
        else throw new JAPIException("requested JDA cannot be null.");
    }
    public static void setLegacyCommandPrefix(String prefix1) {
        prefix = prefix1;
    }
    public static String getLegacyCommandPrefix() {
        return prefix;
    }
}
