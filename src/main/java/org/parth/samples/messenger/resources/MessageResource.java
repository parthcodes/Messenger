package org.parth.samples.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Produces(MediaType.APPLICATION_JSON)
public List<Message> getMessages(){
	return messageService.getAllMessages();
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Message addMesssage(Message message){

	return messageService.addMessage(message); 
}

@PUT
@Path("/{messageId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Message updateMessage(@PathParam("messageId") long messageId, Message message){
	message.setId(messageId);
	return messageService.updateMessage(message);
}

@DELETE
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteMessage(@PathParam("messageId") long messageId){
	messageService.removeMessage(messageId);
}
 

@GET
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)   
public Message test(@PathParam("messageId") long messageId){
	return messageService.getMessage(messageId);
}


} 
 