package org.jcmds.listeners;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jcmds.JAPI;
import org.jcmds.commands.lambda.event.LegacyCommandReceivedEvent;
import org.jcmds.commands.lambda.event.SlashCommandEvent;
import org.jcmds.commands.lambda.legacy.LegacyCommand;
import org.jcmds.commands.lambda.slash.SlashCommand;
import org.jetbrains.annotations.NotNull;

public class DefaultAdapter extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        LegacyCommand.commands.forEach(cmd -> {
            if (event.getMessage().getContentRaw().startsWith(JAPI.getLegacyCommandPrefix()+cmd.getName()) && (event.getMessage().getContentRaw().split(" ").length-1)>=cmd.getRequiredArgCount())
                cmd.getEvent().accept(new LegacyCommandReceivedEvent(event));
        });
    }
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        SlashCommand.commands.forEach(cmd -> {
            if (event.getName().equals(cmd.getName()) && cmd.getEvent() != null)
                cmd.getEvent().accept(new SlashCommandEvent(event));
            else
                cmd.onInteraction(new SlashCommandEvent(event));
        });
    }
}
