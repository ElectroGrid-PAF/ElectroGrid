package com;
import model.OutageNotice;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/OutageNotice")
public class OutageNoticeService
{
	OutageNotice noticeObj = new OutageNotice();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readNotices()
	{
		return "Hello";
	}
}	
