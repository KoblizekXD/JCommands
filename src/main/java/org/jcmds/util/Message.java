package org.jcmds.util;

import net.dv8tion.jda.api.MessageBuilder;

public class Message {
    private final MessageBuilder builder;

    public Message() {
        this.builder = new MessageBuilder();
    }
    public void setText(CharSequence text) {
        builder.setContent(String.valueOf(text));
    }
    public void appendText(CharSequence text) {
        builder.append(String.valueOf(text));
    }
    public net.dv8tion.jda.api.entities.Message toJDAMessage() {
        return builder.build();
    }
}
