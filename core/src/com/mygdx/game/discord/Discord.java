package com.mygdx.game.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class Discord {
	private DiscordRPC discord;
	private DiscordRichPresence rpc;
	
	public Discord () {
		discord = DiscordRPC.INSTANCE;
		String appId = "1036816576609001573";
		String steamId = "";
		
		DiscordEventHandlers handlers = new DiscordEventHandlers();
		discord.Discord_Initialize(appId, handlers, true, steamId);
		
		rpc = new DiscordRichPresence();
		rpc.startTimestamp = System.currentTimeMillis() / 1000;
		rpc.largeImageKey = "spacenav_icon";
	}
	
	public void setEstadoJuego(int ronda, int puntaje) {
		discord.Discord_UpdatePresence(rpc);
		rpc.details = "Ronda " + ronda;
		rpc.state = "Puntaje: " + puntaje;
	}
	
	public void setEstadoDefault() {
		discord.Discord_UpdatePresence(rpc);
		rpc.details = "";
		rpc.state = "";
	}

}
