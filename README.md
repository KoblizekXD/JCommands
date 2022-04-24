# JCommands
JCommands is library for JDA, that helps you do things easier!  

Example bot with ping slash command:
```java
public class Start {
    public static void main(String[] args) throws LoginException, InterruptedException, JAPIException {
        JAPI.initialize("Token");
        new SlashCommand("ping", "ping command", true, event -> {
            event.reply("Pong!");
        }); 
    }
}
```  

## Installation  
Latest version can be found in [`Releases`](https://github.com/KoblizekXD/JCommands/releases)  

## Creating the Bot  
To use the JCommands, you must initialize JAPI first:
```java
JAPI.initialize("token of your bot");
```  
##### Slash commands
```java
new SlashCommand("name of command", "description of command", false, event -> {
    event.reply("I replied lol!");
});
```  
To make loading interactions faster you should use guildOnly,  
loading interactions normally could take up to 1 hour!  
When you make it guildOnly, the interactions will respond only in specified server!  
Example:  
```java
JAPI.setGuildID("id of ur server/guild");
new SlashCommand("name of command", "description of command", true, event -> {
    event.reply("I replied lol!");
});
```  
##### Legacy commands/Normal commands  
It is also possible to create normal commands!  
To do that, you'll have to specify prefix:  
```java
JAPI.setLegacyCommandPrefix("Prefix u want");
```  
And then just create the command:  
```java
new LegacyCommand("name", "description", 0, event -> {
    event.reply("Hi lol!");
});
```  
The argument with 0 means how many command arguments it should expect.  