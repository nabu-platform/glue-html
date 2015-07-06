package be.nabu.glue.html;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.nabu.glue.impl.methods.ScriptMethods;
import be.nabu.libs.evaluator.annotations.MethodProviderClass;
import be.nabu.libs.scraper.Configuration;
import be.nabu.libs.scraper.Scraper;

@MethodProviderClass(namespace = "html")
public class HTMLMethods {
	
	public static String scrape(Object html, Object config) throws IOException, JAXBException, SAXException, ParserConfigurationException {
		String content = ScriptMethods.string(html);
		Configuration configuration = (Configuration) (config instanceof Configuration ? config : Configuration.createUnmarshaller().unmarshal(new StringReader(ScriptMethods.string(config))));
		Scraper scraper = new Scraper(new ByteArrayInputStream(content.getBytes()));
		return scraper.rewrite(configuration).toString();
	}
	
}
