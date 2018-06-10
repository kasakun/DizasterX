package com.DizasterX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Root resource (exposed at "data" path)
 * 
 * The api provides query:
 * @ Number : disasterNumber
 * 
 * @ Date   : declaration
 *            fyDeclared
 *            begin
 *            end 
 *            closeout
 *            lastupdate
 * @ Type   : incident
 *            disaster
 * 
 * @ Title  
 * @ Hash
 * 
 */
@Path("data")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTitle(@PathParam("title") String title) {
        System.out.println(title);
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        Document doc = collection.find(eq("title", "TORNADO")).first();
        return doc.toJson();
    }
}
