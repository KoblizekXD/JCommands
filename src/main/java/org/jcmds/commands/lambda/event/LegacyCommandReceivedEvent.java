package org.jcmds.commands.lambda.event;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jcmds.error.JAPIException;
import org.jcmds.util.Message;

public class LegacyCommandReceivedEvent {
    private final MessageReceivedEvent event;
    private final String[] args;

    public LegacyCommandReceivedEvent(MessageReceivedEvent event) {
        this.event = event;
        this.args = event.getMessage().getContentRaw().split(" ");
    }

    /**
     * Returns argument on defined position
     * 0 = command itself
     * 1< = all arguments
     *
     * @param position
     * @return String
     */
    public String getArgument(int position) throws JAPIException {
        if (position>args.length) throw new ArrayIndexOutOfBoundsException("Position too big");
        return args[position];
    }
    public String getStringContent() {
        return event.getMessage().getContentRaw();
    }
    public void reply(CharSequence message) {
        event.getMessage().reply(message).queue();
    }
    public void replyEmbeds(MessageEmbed embed, MessageEmbed ... embeds) {
        event.getMessage().replyEmbeds(embed, embeds).queue();
    }
    public void replyEmbed(MessageEmbed embed) {
        event.getMessage().replyEmbeds(embed).queue();
    }
    public void sendMessageToSameTextChannel(CharSequence message) {
        event.getMessage().getTextChannel().sendMessage(message).queue();
    }
    public void sendMessageToSameTextChannel(Message message) {
        event.getMessage().getTextChannel().sendMessage(message.toJDAMessage()).queue();
    }
    public TextChannel getTextChannel() {
        return event.getTextChannel();
    }
    public User getAuthor() {
        return event.getAuthor();
    }
    public Member getAuthorAsMember() {
        return event.getMember();
    }
    public Guild getGuild() {
        return event.getGuild();
    }
}
