package com.DizasterX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import com.mongodb.Block;

import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Root resource (exposed at "data" path)
 * 
 * The api provides query:
 * @ Number : disasterNumber int
 * 
 * @ Date   : declaration    String
 *            fyDeclared     int
 *            begin          String
 *            end            String
 *            closeout       String
 *            lastrefresh    String
 * @ Place:   state          String
 *            county         String
 *            palceCode      int
 * 
 * @ Type   : incident       String
 *            disaster       String
 * 
 * @ Title                   String
 * @ Hash                    String
 * 
 */
@Path("data")
public class MyResource {
    /**
     * Method handling declaration date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the declaration date
     */
    @GET
    @Path("/declarationDate")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByDeclarationDate(@QueryParam("year") String year, 
                                       @QueryParam("month") String month,
                                       @QueryParam("day") String day) {
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

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("declarationDate", yearPattern), 
                            regex("declarationDate", monthPattern),
                            regex("declarationDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Declartion Date Query")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling fiscal year declared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the fiscal year
     */
    @GET
    @Path("/fyDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByFyDeclared(@QueryParam("year") int year) {
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

        // Find exact year
        collection.find(eq("fyDeclared", year)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Fiscal Year Declared Query")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling begin date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the declaration date
     */
    @GET
    @Path("/incidentBeginDate")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIncidentBeginDate(@QueryParam("year") String year, 
                                         @QueryParam("month") String month,
                                         @QueryParam("day") String day) {
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

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("incidentBeginDate", yearPattern), 
                            regex("incidentBeginDate", monthPattern),
                            regex("incidentBeginDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Incident Begin Date Query")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling end date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the declaration date
     */
    @GET
    @Path("/incidentEndDate")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIncidentEndDate(@QueryParam("year") String year, 
                                       @QueryParam("month") String month,
                                       @QueryParam("day") String day) {
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

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("incidentEndDate", yearPattern), 
                            regex("incidentEndDate", monthPattern),
                            regex("incidentEndDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Incident End Date Query")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling close out date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the declaration date
     */
    @GET
    @Path("/disasterCloseOutDate")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByDisasterCloseOutDate(@QueryParam("year") String year, 
                                            @QueryParam("month") String month,
                                            @QueryParam("day") String day) {
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

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("disasterCloseOutDate", yearPattern), 
                            regex("disasterCloseOutDate", monthPattern),
                            regex("disasterCloseOutDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Incident End Date Query")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling last refresh date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the declaration date
     */
    @GET
    @Path("/lastRefresh")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByLastRefresh(@QueryParam("year") String year, 
                                            @QueryParam("month") String month,
                                            @QueryParam("day") String day) {
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

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("lastRefresh", yearPattern), 
                            regex("lastRefresh", monthPattern),
                            regex("lastRefresh", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Incident End Date Query")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling disaster title
     * 
     * @param Title support fuzzy matching and case insensitive. 
     *        i.e. "tornado"/"tor" will return all contain
     *        "TORNADO"
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

        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        collection.find(regex("title", pattern)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Title Query")
                        .append("status", "ok")
                        .append("size", entries.size())
                        .append("entries", entries);

        mongoClient.close();
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
        
        mongoClient.close();
        return res.toJson();
    }
}
