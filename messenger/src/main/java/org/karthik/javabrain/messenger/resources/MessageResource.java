package org.karthik.javabrain.messenger.resources;

import java.net.URI;
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
import javax.ws.rs.core.UriInfo;

import org.karthik.javabrain.messenger.model.Message;
import org.karthik.javabrain.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(@QueryParam ("year") int year,@QueryParam ("start") int start,@QueryParam ("size") int size) {
		if(year>0)
			return messageService.getAllMessagesForYear(year);
		else if(start >=0 && size>0)
			return messageService.getAllMessagesPaginated(start, size);
		else
		return messageService.getMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessageById(@PathParam("messageId") long messageId)
	{
		return messageService.getMessage(messageId);
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addMessages(Message message,@Context UriInfo uriInfo) {
		Message newMessage=messageService.addMessage(message);
		String newId=String.valueOf(message.getId());
         URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        
		return Response.created(uri).entity(newMessage).build();
				       
				
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessageById(@PathParam("messageId") long messageId ,Message message)
	{
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public void deleteMessageById(@PathParam("messageId") long messageId)
	{
		messageService.deleteMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource test()
	{
		return new CommentResource();
	}	
	

	
	
}
