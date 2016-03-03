package org.parth.samples.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.parth.samples.messenger.model.Message;
import org.parth.samples.messenger.service.MessageService;


@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MessageResource {
	
	MessageService messageService = new MessageService();
	
@GET
public List<Message> getMessages(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size") int size){
	if(year>0){
	return	messageService.getAllMessagesForYear(year);
	}
	if(start >=0 && size>=0){
		return	messageService.getAllMessagesPaginated(start, size);

	}
	return messageService.getAllMessages();
}

@POST

public Response addMesssage(Message message, @Context UriInfo uriInfo) throws URISyntaxException{

	Message newMessage = messageService.addMessage(message); 
	return Response.created(new URI(uriInfo.getAbsolutePath().toString()+newMessage.getId())).entity(newMessage).build();
	 
}

@PUT
@Path("/{messageId}")

public Message updateMessage(@PathParam("messageId") long messageId, Message message){
	message.setId(messageId);
	return messageService.updateMessage(message);
}

@DELETE 
@Path("/{messageId}")

public void deleteMessage(@PathParam("messageId") long messageId){
	messageService.removeMessage(messageId);
}
 

@GET
@Path("/{messageId}")
public Message getMessage(@Context UriInfo uriInfo, @PathParam("messageId") long messageId){
	Message message = messageService.getMessage(messageId);
	getUriInfo(uriInfo, message);
	
	return message;
	
	
}

private void getUriInfo(UriInfo uriInfo, Message message) {
	message.addLink(uriInfo.getAbsolutePath().toString(), "self");
}


@Path("/{messageId}/comments/")
public CommentResource getCommentResource(){
	return new CommentResource();
	}

} 
 