package org.jcmds.util;

import org.jcmds.commands.lambda.event.LegacyCommandReceivedEvent;

import java.util.function.Consumer;

public interface Legacy {
    String getName();
    String getDescription();
    int getRequiredArgCount();
    Consumer<LegacyCommandReceivedEvent> getEvent();
    void onInteraction(LegacyCommandReceivedEvent event);
}
