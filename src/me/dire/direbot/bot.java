package me.dire.direbot;

import me.dire.direbot.listeners.guildmemberevent;
import me.dire.direbot.listeners.messageevent;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class bot {
	
	public static void main(String[] args) throws Exception
	{
		JDA jda = new JDABuilder(AccountType.BOT)
				.setToken(config.token)
				.buildBlocking();
		
		jda.addEventListener(new guildmemberevent());
		jda.addEventListener(new messageevent());	
	}
}
