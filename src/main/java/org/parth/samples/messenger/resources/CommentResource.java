package org.parth.samples.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.parth.samples.messenger.model.Message;
import org.parth.samples.messenger.service.MessageService;


@Path("/")
public class CommentResource {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getComment(){
		return messageService.getAllMessages();
		
	}
	
	@GET
	@Path("/{commentId}")
	public String getCommentById(@PathParam("commentId") long id, @PathParam("messageId") long messageId){
		return "id" + id +"with message id" + messageId;
		
	}
	
	
}
