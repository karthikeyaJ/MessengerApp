package org.karthik.javabrain.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.karthik.javabrain.messenger.database.DatabaseClass;
import org.karthik.javabrain.messenger.exception.DataNotFoundException;
import org.karthik.javabrain.messenger.model.Message;

public class MessageService {

	private static Map<Long,Message> messages=DatabaseClass.getMessages();

	public MessageService()
	{
		messages.put(1L, new Message(1L,"Welcome to my first app","Karthikeya"));
		
		messages.put(2L, new Message(2L,"Hope you are learning","Karthikeya2"));

	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	
	
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message> messagesForYear= new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		
		for(Message message:messages.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
		
		
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size)
	{
		ArrayList<Message> list=new ArrayList<Message>(messages.values());
		if(start+size>list.size())
			return new ArrayList<Message>();
		return list.subList(start, start+size);
		
	}
	
	
	
	public Message getMessage(long Id){
		Message message=messages.get(Id);
		if(message == null)
			throw new DataNotFoundException("The message with id is: "+ Id+" Not found");
		return message;
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
			return null;
		else
			messages.put(message.getId(), message);
		return message;
		
	}
	
	public void deleteMessage(long Id)
	{
		 messages.remove(Id);
	}
	
}
