package org.jcmds.commands.extendable.slash;

import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jcmds.JAPI;
import org.jcmds.commands.lambda.event.SlashCommandEvent;
import org.jcmds.commands.lambda.slash.Option;
import org.jcmds.util.Slash;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class SlashCommand implements Slash {
    private final String name;
    private final String description;
    private final boolean guildOnly;
    private final Option[] options;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public boolean isGuildOnly() {
        return guildOnly;
    }

    @Override
    public Option[] getOptions() {
        return options;
    }
    @Override
    public Consumer<SlashCommandEvent> getEvent() {
        return null;
    }

    public SlashCommand(String name, String description, boolean guildOnly) {
        org.jcmds.commands.lambda.slash.SlashCommand.commands.add(this);

        this.name = name;
        this.description = description;
        this.guildOnly = guildOnly;
        this.options = new Option[0];

        JAPI.getJDA().getGuildById(JAPI.getGuildID()).updateCommands().addCommands(Commands.slash(name, description)).queue();
    }
    public SlashCommand(String name, String description, boolean guildOnly, Option[] options) {
        org.jcmds.commands.lambda.slash.SlashCommand.commands.add(this);

        this.name = name;
        this.description = description;
        this.guildOnly = guildOnly;
        this.options = options;

        List<OptionData> data = new ArrayList<>();
        for (var option : options) {
            List<Command.Choice> choices = new ArrayList<>();
            for (var choice : option.getChoices()) {
                choices.add(new Command.Choice(choice.getName(), choice.getDescription()));
            }
            data.add(new OptionData(option.getType(), option.getName(), option.getDescription()).addChoices(choices));
        }

        JAPI.getJDA().getGuildById(JAPI.getGuildID()).updateCommands().addCommands(Commands.slash(name, description).addOptions(data)).queue();
    }
    public abstract void onInteraction(SlashCommandEvent event);
}
