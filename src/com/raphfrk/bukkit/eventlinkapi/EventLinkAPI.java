package com.raphfrk.bukkit.eventlinkapi;

import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public interface EventLinkAPI {
	
	/**
	 * Tests if a player is listed on the admin_list for the eventlink.txt file
	 *
	 * @param player Player to test
	 * @return true if the player is on the admin list or is an Op
	 */

	public boolean isAdmin(Player player);

	/**
	 * Sends an event to a single server servers.  
	 * 
	 * NOTE: The packet may be lost en-route even if the function returns true
	 *
	 * @param target destination servers.
	 * @return true if a route exists to the target
	 */

	public boolean sendEvent(String target, Event event);

	/**
	 * Sends an event to multiple servers.  This will only send the  
	 * packet once to each directly connected server.  This has the 
	 * potential to improve broadcast bandwidth usage.
	 *
	 * NOTE: The packet may be lost en-route even if the function returns true
	 *
	 * @param target Array of destination servers.
	 * @return true if a route exists to the target
	 */

	public boolean sendEvent(String[] target, Event event);

	/**
	 * Route entries are markers that can be seen (and routed to) by
	 * all other servers.
	 * 
	 * There are 3 reserved table
	 * 
	 * "servers":  The servers that are online
	 * "players":  The players that are online
	 * "worlds":   The worlds for all connected servers
	 * 
	 * NOTE: If there is a collision, then the closest entry will be routed to.
	 * 
	 * This means that unique names should be used for servers and worlds.
	 * 
	 * This tables are auto-updated and shouldn't be modified by other plugins
	 *
	 * NOTE: The packet may be lost en-route even if the function returns true
	 *
	 *
	 */

	/**
	 * Adds a route entry for the local server.
	 * 
	 * This will be visible by all the other servers in the cluster
	 * 
	 * @param table This is the table name/type of route entry
	 * @param name This is the specific name of the entry
	 * @return true if the entry was added locally
	 */

	public boolean addRouteEntry(String table, String name);

	/**
	 * Deletes a route entry for the local server.
	 * 
	 * This will be deleted for all the other servers in the cluster
	 * 
	 * @param table This is the table name/type of route entry
	 * @param name This is the specific name of the entry
	 * @return true if the entry was deleted
	 */

	public boolean deleteRouteEntry(String table, String name);

	/**
	 * Gets the current location of a routing entry
	 * 
	 * If there is more than one match, the closest entry will be returned
	 * 
	 * @param table This is the table name/type of route entry
	 * @param name This is the specific name of the entry
	 * @return the name of the server where the entry is located
	 */

	public String getEntryLocation(String table, String name);

	/**
	 * Copies the names of all entries in a particular table
	 * 
	 * The name only appears once, even if there are multiple entries with
	 * the same name
	 * 
	 * @param table This is the table name/type of route entry
	 * @return A set containing all the entry names for the table
	 */

	public Set<String> copyEntries(String table);

	/**
	 * This gives the name of the current server
	 * 
	 * @return The name of the server
	 */

	public String getServerName();
	
	/**
	 * Sends a message to a given player
	 * 
	 * @param toPlayerName the player to send the message to
	 * @param message the message to send
	 * @return Returns true if the message is sent
	 */

	public boolean sendMessage(String toPlayerName, String message);
	
	/**
	 * Sends a message to a given player
	 * 
	 * @param fromPlayerName the name of the sender
	 * @param toPlayerName the name of the recipient
	 * @return Returns true if the message is sent
	 */

	public boolean sendMessage(String fromPlayerName, String toPlayerName, String message);
	

}
