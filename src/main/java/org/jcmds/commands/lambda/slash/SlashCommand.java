package org.jcmds.commands.lambda.slash;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jcmds.JAPI;
import org.jcmds.commands.lambda.event.SlashCommandEvent;
import org.jcmds.error.JAPIException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class SlashCommand {

    public static final List<SlashCommand> commands = new ArrayList<>();

    private final boolean guildOnly;
    private final String name;
    private final String description;
    private final Option[] options;
    private final Consumer<SlashCommandEvent> event;

    public SlashCommand(String name, String description, Option[] options, Consumer<SlashCommandEvent> event) throws JAPIException {
        this.name = name;
        this.description = description;
        this.options = options;
        this.event = event;
        this.guildOnly = false;
        commands.add(this);

        List<OptionData> data = new ArrayList<>();
        for (var option : options) {
            List<Command.Choice> choices = new ArrayList<>();
            for (var choice : option.getChoices()) {
                choices.add(new Command.Choice(choice.getName(), choice.getDescription()));
            }
            data.add(new OptionData(option.getType(), option.getName(), option.getDescription()).addChoices(choices));
        }

        JAPI.getJDA().updateCommands().addCommands(Commands.slash(name, description).addOptions(data)).queue();
    }
    public SlashCommand(String name, String description, Consumer<SlashCommandEvent> event) throws JAPIException {
        this.name = name;
        this.description = description;
        this.options = new Option[0];
        this.event = event;
        this.guildOnly = false;
        commands.add(this);
        JAPI.getJDA().updateCommands().addCommands(Commands.slash(name, description)).queue();
    }
    public SlashCommand(String name, String description, Option[] options, boolean guildOnly, Consumer<SlashCommandEvent> event) throws JAPIException {
        this.name = name;
        this.description = description;
        this.options = options;
        this.event = event;
        this.guildOnly = guildOnly;
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
    public SlashCommand(String name, String description, boolean guildOnly, Consumer<SlashCommandEvent> event) throws JAPIException {
        this.name = name;
        this.description = description;
        this.options = new Option[0];
        this.event = event;
        this.guildOnly = guildOnly;
        commands.add(this);
        JAPI.getJDA().getGuildById(JAPI.getGuildID()).updateCommands().addCommands(Commands.slash(name, description)).queue();
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Option[] getOptions() {
        return options;
    }
    public Consumer<SlashCommandEvent> getEvent() {
        return event;
    }
}
