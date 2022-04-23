package org.jcmds.commands.lambda.event;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jcmds.commands.lambda.slash.Option;
import org.jcmds.util.Message;

public class SlashCommandEvent {
    private final SlashCommandInteractionEvent event;
    public SlashCommandEvent(SlashCommandInteractionEvent event) {
        this.event = event;
    }
    public void reply(CharSequence text) {
        event.reply(String.valueOf(text)).queue();
    }
    public void reply(CharSequence text, boolean ephemeral) {
        event.reply(String.valueOf(text)).setEphemeral(ephemeral).queue();
    }
    public void sendMessageToSameTextChannel(CharSequence message) {
        event.getTextChannel().sendMessage(message).queue();
    }
    public void sendMessageToSameTextChannel(Message message) {
        event.getTextChannel().sendMessage(message.toJDAMessage()).queue();
    }
    public User getAuthor() {
        return event.getUser();
    }
    public TextChannel getTextChannel() {
        return event.getTextChannel();
    }
    public Member getAuthorAsMember() {
        return event.getMember();
    }
    public Guild getGuild() {
        return event.getGuild();
    }
    public void replyEmbeds(MessageEmbed embed, MessageEmbed ... embeds) {
        event.replyEmbeds(embed, embeds).queue();
    }
    public void replyEmbed(MessageEmbed embed) {
        event.replyEmbeds(embed).queue();
    }
    public OptionMapping getOption(String name) {
        return event.getOption(name);
    }
    public SlashCommandInteractionEvent getEventAsSlashCommandInteraction() {
        return event;
    }
}
