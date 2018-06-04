package me.dire.direbot.listeners;

import me.dire.direbot.config;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class messageevent extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		
		//Objects
		Message msg = e.getMessage();
		User author = msg.getAuthor();
		String[] args = msg.getContentRaw().split(" ");
			
		if(args[0].equalsIgnoreCase(config.prefix + "addrole")) {
			Member member = msg.getMentionedMembers().get(0);
			Role role = msg.getMentionedRoles().get(0);
			
			e.getGuild().getController().addRolesToMember(member, role).complete();
			msg.getChannel().sendMessage(author.getName() + " added " + role.getName() + " to " + member.getNickname()).queue();
		}
		
		if(args[0].equalsIgnoreCase(config.prefix + "removerole")) {
			Member member = msg.getMentionedMembers().get(0);
			Role role = msg.getMentionedRoles().get(0);
			
			e.getGuild().getController().removeRolesFromMember(member, role).complete();
			msg.getChannel().sendMessage(author.getName() + " removed " + role.getName() + " from " + member.getNickname()).queue();
		}
	}
}
