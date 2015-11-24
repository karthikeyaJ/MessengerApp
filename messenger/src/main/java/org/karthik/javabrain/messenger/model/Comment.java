package org.karthik.javabrain.messenger.model;

import java.util.Date;

public class Comment {
 private long Id;
 private String message;
 private Date created;
 private String author;
 
 public Comment()
 {
	 
 }
 public Comment(long Id,String message,String author)
 {
	this.Id=Id;
	this.message=message;
	this.author=author;
	this.created=new Date();
 }
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
 
}
