package com.moneta.converter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/converter")
public class ConverterService {
	
	public static final String VOWELS = "aeiouAEIOU·ÈÌÛ˙¡…Õ”⁄";
		
		@Path("{input}")
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public static Response convert(@PathParam("input") String input)  {
			
			StringBuilder sb = new StringBuilder();
			
			String sanitizedInput = input.replaceAll("\\s{2,}", " ");
			
			for (int i=0; i<sanitizedInput.length(); i++) {
				if (VOWELS.indexOf(sanitizedInput.charAt(i))!=-1) {
					sb.append(Character.toUpperCase(sanitizedInput.charAt(sanitizedInput.length()-i-1)));
				} else {
					sb.append(Character.toLowerCase(sanitizedInput.charAt(sanitizedInput.length()-i-1)));
				}
			}
			
			return Response.status(200).entity(sb.toString()).build();
			
		}
	
}
