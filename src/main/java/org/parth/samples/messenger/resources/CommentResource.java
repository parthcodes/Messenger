package org.parth.samples.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.parth.samples.messenger.model.Message;
import org.parth.samples.messenger.service.MessageService;


@Path("/")
public class CommentResource {

	MessageService messageService = new MessageService();
	@GET
	public List<Message> getComment(){
		return messageService.getAllMessages();
	}
}
