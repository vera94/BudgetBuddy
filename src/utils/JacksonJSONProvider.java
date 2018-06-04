package utils;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JsonMapperConfigurator;

import javax.ws.rs.core.MediaType;

@Provider 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON) 
public class JacksonJSONProvider extends com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider { 

    public JacksonJSONProvider() { 
        super(); 
        setMapper(new ObjectMapper()); //Your mapper 
    } 

} 
