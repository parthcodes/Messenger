package org.parth.samples.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.parth.samples.messenger.database.DatabaseClass;
import org.parth.samples.messenger.model.*;
public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages(); // get the static instance of the message Map and do different operations on it
	
	public MessageService(){
		
		messages.put(1L,  new Message(1,"Hello World",new Date(), "Parth"));
		messages.put(2L,  new Message(2,"Hello Siddharth",new Date(), "Parth"));

	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar c = Calendar.getInstance();
		
		for(Message message:messages.values()){
			c.setTime(message.getCreated());
			if(c.get(Calendar.YEAR)==year)
				messagesForYear.add(message); 
		}
		
		return messagesForYear;
		
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		
		//check is messages size is less than asked
		if(list.size()<start+size) return new ArrayList<Message>();
		
		return list.subList(start, start+size);
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
