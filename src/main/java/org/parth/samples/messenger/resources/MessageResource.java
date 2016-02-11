package org.parth.samples.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.parth.samples.messenger.model.Message;
import org.parth.samples.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
@GET
@Produces(MediaType.APPLICATION_XML)
public List<Message> getMessages(){
	return messageService.getAllMessages();
}

@GET
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_XML)   
public Message test(@PathParam("messageId") long messageId){
	return messageService.getMessage(messageId);
}


} 
 