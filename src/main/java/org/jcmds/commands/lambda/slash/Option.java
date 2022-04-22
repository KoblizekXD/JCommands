package org.jcmds.commands.lambda.slash;

import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.util.ArrayList;
import java.util.List;

public class Option {
    private final OptionType type;
    private final String name;
    private final String description;
    private final boolean isRequired;
    private final List<Choice> choices;

    public Option(OptionType type, String name, String description, boolean isRequired) {
        this.name = name;
        this.description = description;
        this.isRequired = isRequired;
        this.type = type;
        choices = new ArrayList<>();
    }
    public Option addChoice(String name, String description) {
        choices.add(new Choice(name, description));
        return this;
    }
    public Option addChoices(Choice ... choice) {
        choices.addAll(List.of(choice));
        return this;
    }
    public List<Choice> getChoices() {
        return choices;
    }
    public OptionType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean isRequired() {
        return isRequired;
    }
}
