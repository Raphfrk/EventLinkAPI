package com.raphfrk.bukkit.eventlinkapi;

import org.bukkit.event.Event;

public class EventLinkSetupEvent extends Event {

	private static final long serialVersionUID = 1L;
	private EventLinkAPI eventLinkAPI = null;
	
	public EventLinkSetupEvent() {
		super("EventLinkSetupEvent");
	}
	
	public EventLinkAPI getEventLinkAPI() {
		return eventLinkAPI;
	}
	
	public void setEventLinkAPI(EventLinkAPI eventLinkAPI) {
		this.eventLinkAPI = eventLinkAPI;
	}
}
