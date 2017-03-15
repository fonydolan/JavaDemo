package com.dolan.springbatch;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDate;


/*Also note that we have used JAXB annotations in order to map the class properties to XML tags.
Since we are using Joda-Time LocalDate API, we need to tell JAXB about how to perform the conversion.
Below is the Adpater class for the same:*/
public class LocalDateAdapter extends XmlAdapter<String,LocalDate> {

	@Override
	public String marshal(LocalDate arg0) throws Exception {
		// TODO Auto-generated method stub
		return arg0.toString();
	}

	@Override
	public LocalDate unmarshal(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return new LocalDate(arg0);
	}

	
}
