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
 * The api provides:
 * @ Number : disasterNumber int
 * 
 * @ Date   : declaration    String
 *            fyDeclared     int
 *            begin          String
 *            end            String
 *            closeout       String
 *            lastrefresh    String
 * @ Place:   state          String
 *            county         String   not all
 *            palceCode      int      not all
 * 
 * @ Type   : incident       String
 *            disaster       String
 * 
 * @ Program: IH             int
 *            IA             int
 *            PA             int
 *            HM             int
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
        Document res = new Document("name", "Declartion Date")
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
    public String getByFyDeclared(@QueryParam("value") int value) {
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
        collection.find(eq("fyDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Fiscal Year Declared")
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
     * @return A list of entries match the begin date
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
        Document res = new Document("name", "Incident Begin Date")
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
     * @return A list of entries match the end date
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
        Document res = new Document("name", "Incident End Date")
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
     * @return A list of entries match the close out date
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
        Document res = new Document("name", "Incident End Date")
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
     * @return A list of entries match last refresh date
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
        Document res = new Document("name", "Last Update")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling state
     * 
     * if params are null return all results
     * @param state state abbreviation
     * @return A list of entries match the state
     */
    @GET
    @Path("/state")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByState(@QueryParam("value") String value) {
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
        collection.find(regex("state", pattern)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "State")
                                    .append("status", "ok")
                                    .append("size", entries.size())
                                    .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling county
     * 
     * if params are null return all results
     * @param state state abbreviation
     * @return A list of entries match county name
     */
    @GET
    @Path("/county")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByCounty(@QueryParam("value") String value) {
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
        collection.find(regex("state", pattern)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "County")
                                    .append("status", "ok")
                                    .append("size", entries.size())
                                    .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling place code
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the place code
     */
    @GET
    @Path("/placeCode")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByPlaceCode(@QueryParam("value") int value) {
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

        // Find exact plcae code
        collection.find(eq("placeCode", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Place Code")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling ihProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the ihProgramDeclared
     */
    @GET
    @Path("/ihProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIHProgram(@QueryParam("value") int value) {
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

        // find exact ih program value
        collection.find(eq("ihProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "IH Program")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling iaProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the iaProgramDeclared
     */
    @GET
    @Path("/iaProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIAProgram(@QueryParam("value") int value) {
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

        // find exact ia program value
        collection.find(eq("iaProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "IA Program")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling paProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the paProgramDeclared
     */
    @GET
    @Path("/paProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByPAProgram(@QueryParam("value") int value) {
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

        // find exact PA program value
        collection.find(eq("paProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "PA Program")
                                   .append("status", "ok")
                                   .append("entries", entries);

        mongoClient.close();
        return res.toJson();
    }

    /**
     * Method handling hmProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the hmProgramDeclared
     */
    @GET
    @Path("/hmProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByHMProgram(@QueryParam("value") int value) {
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

        // find exact hm program value
        collection.find(eq("hmProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "HM Program")
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
        Document res = new Document("name", "Title")
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
        Document res = new Document("name", "Hash")
                        .append("status", "ok")
                        .append("entries", entries);
        
        mongoClient.close();
        return res.toJson();
    }
}
