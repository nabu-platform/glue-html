/*
* Copyright (C) 2015 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package be.nabu.glue.html;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.nabu.glue.core.impl.methods.ScriptMethods;
import be.nabu.libs.evaluator.annotations.MethodProviderClass;
import be.nabu.libs.scraper.Configuration;
import be.nabu.libs.scraper.Scraper;

@MethodProviderClass(namespace = "html")
public class HTMLMethods {
	
	public static String scrape(Object html, Object config) throws IOException, JAXBException, SAXException, ParserConfigurationException {
		String content = ScriptMethods.string(html, false);
		Configuration configuration = (Configuration) (config instanceof Configuration ? config : Configuration.createUnmarshaller().unmarshal(new StringReader(ScriptMethods.string(config, false))));
		Scraper scraper = new Scraper(new ByteArrayInputStream(content.getBytes()));
		return scraper.rewrite(configuration).toString();
	}
	
}
