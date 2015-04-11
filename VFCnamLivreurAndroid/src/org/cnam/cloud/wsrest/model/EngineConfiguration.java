package org.cnam.cloud.wsrest.model;

import org.restlet.engine.Engine;
import org.restlet.ext.httpclient.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;

public class EngineConfiguration
{
	private static EngineConfiguration	ourInstance	= new EngineConfiguration();

	//public final static String gae_path = "http://mme-mapremiereapp.appspot.com/";
	//public final static String gae_path	= "http://groupe-mini-projet-cnam.appspot.com/";
	public final static String gae_path	= "http://vf-miniprojet-cloud-restlet.appspot.com/";
	
	public static EngineConfiguration getInstance()
	{
		return ourInstance;
	}

	public EngineConfiguration()
	{
		Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
		Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
	}

	public static EngineConfiguration getOurInstance()
	{
		return ourInstance;
	}

	public static void setOurInstance(EngineConfiguration ourInstance)
	{
		EngineConfiguration.ourInstance = ourInstance;
	}
}
