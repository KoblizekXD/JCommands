package org.jcmds.commands.extendable.legacy;

import org.jcmds.commands.lambda.event.LegacyCommandReceivedEvent;
import org.jcmds.util.Legacy;

import java.util.function.Consumer;

public abstract class LegacyCommand implements Legacy {
    private final String name;
    private final String description;
    private final int requiredArgCount;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public int getRequiredArgCount() {
        return requiredArgCount;
    }
    @Override
    public Consumer<LegacyCommandReceivedEvent> getEvent() {
        return null;
    }

    public LegacyCommand(String name, String description, int requiredArgCount) {
        this.name = name;
        this.description = description;
        this.requiredArgCount = requiredArgCount;
        org.jcmds.commands.lambda.legacy.LegacyCommand.commands.add(this);
    }
    @Override
    public abstract void onInteraction(LegacyCommandReceivedEvent event);
}
