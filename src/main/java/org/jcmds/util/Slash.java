package org.jcmds.util;

import org.jcmds.commands.lambda.event.SlashCommandEvent;
import org.jcmds.commands.lambda.slash.Option;

import java.util.function.Consumer;

public interface Slash {
    String getName();
    String getDescription();
    Option[] getOptions();
    Consumer<SlashCommandEvent> getEvent();
    void onInteraction(SlashCommandEvent event);
}
