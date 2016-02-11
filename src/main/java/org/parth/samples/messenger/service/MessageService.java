package org.parth.samples.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.parth.samples.messenger.database.DatabaseClass;
import org.parth.samples.messenger.model.*;
public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages(); // get the static instance of the message Map and do different operations on it
	
	public MessageService(){
		
		messages.put(1L,  new Message(1,"Hello World", "Parth"));
		messages.put(2L,  new Message(2,"Hello Siddharth", "Parth"));

	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	
	public Message getMessage(long id){
		return (messages.get(id));
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message){
		
		if(message.getId()<=0){
			return null;
		}
		else{
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	

}
