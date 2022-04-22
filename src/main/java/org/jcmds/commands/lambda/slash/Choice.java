package org.jcmds.commands.lambda.slash;

public class Choice {
    private final String name;
    private final String description;

    public Choice(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
