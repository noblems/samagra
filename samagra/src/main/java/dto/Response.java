package dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Response")
public class Response{
	@JacksonXmlProperty
	List<Object> objects;
	public Response createResponse(Object o){
		this.objects.add(o);
		return this;
	}
	public List<Object> getObjects() {
		return objects;
	}

	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}
	
	
}
