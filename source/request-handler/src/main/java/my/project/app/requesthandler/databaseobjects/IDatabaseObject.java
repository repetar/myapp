package my.project.app.requesthandler.databaseobjects;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public interface IDatabaseObject {

    public BasicDBObject createDBObject();

   // public IDatabaseObject createJavaObject(final DBCursor cursor);
}
