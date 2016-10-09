package be.nabu.glue.html;

import java.util.ArrayList;
import java.util.List;

import be.nabu.glue.core.api.StaticMethodFactory;

public class HTMLStaticMethodFactory implements StaticMethodFactory {

	@Override
	public List<Class<?>> getStaticMethodClasses() {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(HTMLMethods.class);
		return classes;
	}
	
}
