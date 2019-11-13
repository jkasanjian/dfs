import java.rmi.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.math.BigInteger;
import java.security.*;
import com.google.gson.Gson;
import java.io.InputStream;
import java.util.*;

/* JSON Format

{"file":
  [
     {"name":"MyFile",
      "size":128000000,
      "pages":
      [
         {
            "guid":11,
            "size":64000000
         },
         {
            "guid":13,
            "size":64000000
         }
      ]
      }
   ]
} 
*/


public class DFS
{
    
    int port;
    Chord  chord;
    
    
    private long md5(String objectName)
    {
        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(objectName.getBytes());
            BigInteger bigInt = new BigInteger(1,m.digest());
            return Math.abs(bigInt.longValue());
        }
        catch(NoSuchAlgorithmException e)
        {
                e.printStackTrace();
                
        }
        return 0;
    }
    
    
    
    public DFS(int port) throws Exception
    {
        
        
        this.port = port;
        long guid = md5("" + port);
        chord = new Chord(port, guid);
        Files.createDirectories(Paths.get(guid+"/repository"));
        Files.createDirectories(Paths.get(guid+"/tmp"));
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                chord.leave();
            }
        });
        
    }
    
  
/**
 * Join the chord
  *
 */
    public void join(String Ip, int port) throws Exception
    {
        chord.joinRing(Ip, port);
        chord.print();
    }
    
    
   /**
 * leave the chord
  *
 */ 
    public void leave() throws Exception
    {        
       chord.leave();
    }
  
   /**
 * print the status of the peer in the chord
  *
 */
    public void print() throws Exception
    {
        chord.print();
    }
    
/**
 * readMetaData read the metadata from the chord
  *
 */
    public FilesJson readMetaData() throws Exception
    {
        FilesJson filesJson = null;
        try {
            Gson gson = new Gson();
            long guid = md5("Metadata");

            System.out.println("GUID " + guid);
            ChordMessageInterface peer = chord.locateSuccessor(guid);
            RemoteInputFileStream metadataraw = peer.get(guid);
            metadataraw.connect();
            Scanner scan = new Scanner(metadataraw);
            scan.useDelimiter("\\A");
            String strMetaData = scan.next();
            System.out.println(strMetaData);
            filesJson = gson.fromJson(strMetaData, FilesJson.class);
        } catch (Exception ex)
        {
            filesJson = new FilesJson();
        }
        return filesJson;
    }
    
/**
 * writeMetaData write the metadata back to the chord
  *
 */
    public void writeMetaData(FilesJson filesJson) throws Exception
    {
        long guid = md5("Metadata");
        ChordMessageInterface peer = chord.locateSuccessor(guid);
        
        Gson gson = new Gson();
        peer.put(guid, gson.toJson(filesJson));
    }
   
/**
 * Change Name
  *
 */
    public void move(String oldName, String newName) throws Exception
    {
        // TODO:  Change the name in Metadata
        FilesJson md = readMetaData();
        List<FileJson> files = md.getFile();
        for ( FileJson fjson: files) {
            if( fjson.name == oldName ){
                fjson.setName(newName);
                break;
            }
        }

        // Write Metadata
        md.setFile( files );
        writeMetaData(md);
    }

  
/**
 * List the files in the system
  *
 * @param filename Name of the file
 */
    public String lists() throws Exception
    {
        FilesJson fileJson = readMetaData();
        String listOfFiles = "";
 
        return listOfFiles;
    }

/**
 * create an empty file 
  *
 * @param filename Name of the file
 */
    public void create(String fileName) throws Exception
    {
        // Retrieving Metadata as FilesJson Object
        FilesJson metadata = readMetaData();

        // Creating JSONFile object for new file
        FileJson newFile = new FileJson(fileName);

        // Appending new JSONFile object into metadata files list
        metadata.addFile(newFile);

        // Entering new file entry into Metadata
        writeMetaData(metadata);

    }
    
/**
 * delete file 
  *
 * @param filename Name of the file
 */
    public void delete(String fileName) throws Exception
    {
        FilesJson md = readMetaData();

        for( int i = 0; i < md.){

        }
        
    }
    
/**
 * Read block pageNumber of fileName 
 *
 * @param filename Name of the file
 * @param pageNumber number of block. 
 */
    public RemoteInputFileStream read(String fileName, int pageNumber) throws Exception
    {
        return null;
    }
    
 /**
 * Add a page to the file                
  *
 * @param filename Name of the file
 * @param data RemoteInputStream. 
 */
    public void append(String filename, RemoteInputFileStream data) throws Exception
    {
        FilesJson mfs = readMetaData();
        Long key = mfs.append(filename);

        chord.locateSuccessor(key).put(key, data);
        writeMetaData(mfs);
    }
    
}
