package com.DizasterX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

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
     * Method handling disaster title
     * 
     * @param Declaration Date i.e."1979-04-11T00:00:00.000Z"
     * @return A list of entries match the declaration date
     */
    @GET
    @Path("/declarationDate")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByDeclarationDate(@QueryParam("value") String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };
        
        collection.find(eq("declarationDate", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Declartion Date Query")
                        .append("status", "ok")
                        .append("entries", entries);

        return res.toJson();
    }


    /**
     * Method handling disaster title
     * 
     * @param Title i.e. "TORNADO"
     * @return A list of entries match the title name.
     */
    @GET
    @Path("/title")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByTitle(@QueryParam("value") String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };
        
        collection.find(eq("title", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Title Query")
                        .append("status", "ok")
                        .append("entries", entries);

        return res.toJson();
    }

    /**
     * Method handling disaster hash
     * 
     * @param Hash
     * @return One entry match the hash value
     */
    @GET
    @Path("/hash")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByHash(@QueryParam("value") String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        Document entries = collection.find(eq("hash", value)).first();

        // Packaging
        Document res = new Document("name", "Hash Query")
                        .append("status", "ok")
                        .append("entries", entries);

        return res.toJson();
    }
}
