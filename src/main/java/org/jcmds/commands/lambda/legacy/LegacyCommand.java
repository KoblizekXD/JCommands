package org.jcmds.commands.lambda.legacy;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jcmds.JAPI;
import org.jcmds.commands.lambda.event.LegacyCommandReceivedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class LegacyCommand {
    public static final List<LegacyCommand> commands = new ArrayList<>();
    private final String name;
    private final String description;
    private final int requiredArgCount;
    private final Consumer<LegacyCommandReceivedEvent> event;

    public LegacyCommand(String name, String description, int requiredArgCount, Consumer<LegacyCommandReceivedEvent> event) {
        this.name = name;
        this.description = description;
        this.requiredArgCount = requiredArgCount;
        this.event = event;
        commands.add(this);
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getRequiredArgCount() {
        return requiredArgCount;
    }
    public Consumer<LegacyCommandReceivedEvent> getEvent() {
        return event;
    }
}
