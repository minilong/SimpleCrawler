package shannon.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Crawler {

	private XMLStreamReader xmlReader;
	
	public Crawler(){};
	
	public Crawler(InputStream stream) throws XMLStreamException{
		XMLInputFactory factory = XMLInputFactory.newInstance();
		xmlReader = factory.createXMLStreamReader(stream);
	}
	
	public Crawler(URL url) throws XMLStreamException, IOException{
		this(url.openStream());
	}
	
	public char[] crawl() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			while(xmlReader.hasNext()){
				int event = xmlReader.next();
				if(event == XMLStreamConstants.START_ELEMENT){
					if(xmlReader.getLocalName().equals("div") && xmlReader.hasText()){
						System.out.println(xmlReader.getElementText());
						sbuilder.append(xmlReader.getElementText());
					}
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return sbuilder.toString().toCharArray();
	}
	
	
	
}
