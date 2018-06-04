package me.dire.direbot.listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class guildmemberevent extends ListenerAdapter{
	
	public void onguildmemberjoin(GuildMemberJoinEvent e) {
		
		//Objects
		Guild guild = e.getGuild();
		Member member = e.getMember();
		
		//Send Message to Welcome channel welcoming new member
		TextChannel chan = guild.getDefaultChannel();
		chan.sendMessage("Welcome to DireClan " + member.getAsMention()).queue();
	}

	public void onguildmemberleave(GuildMemberLeaveEvent e) {
		
		//Objects
		Guild guild = e.getGuild();
		Member member = e.getMember();
		
		//Send Message to Welcome channel saying farewell to an old member
		TextChannel chan = guild.getDefaultChannel();
		chan.sendMessage("Farewell from all at DireClan " + member.getAsMention() + ", hope you come back soon").queue();	
	}
	
}
