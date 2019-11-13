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
import PageJson;



public class FileJson 
{
    String name;
    Long   size;
    String creationTS;
    String readTS;
    String writeTS;
    int referenceCount;
    int numberOfPages;
    ArrayList<PageJson> pages;
    public FileJson()
    {
        
    }

    public FileJson(String fileName){
        name = fileName;
        size = 0;
        creationTS = 0;
        readTS = 0;
        writeTS = 0;
        referenceCount = 0;
        numberOfPages = 0;
        pages = new ArrayList<PageJson>();
    }

    // getters
    public Long getGuid(){
        return this.guid;
    }
    public Long getSize(){
        return this.size;
    }
    public String getCreationTS(){
        return this.creationTS;
    }
    public String getReadTS(){
        return this.readTS;
    }
    public String getWriteTS(){
        return this.writeTS;
    }
    public int getReferenceCount(){
        return this.referenceCount;
    }
    public int getNumberOfPages(){
        return this.numberOfPages;
    }
    // setters
    public void setGuid(Long guid){
        this.guid = guid;
    }
    public void setSize(Long size){
        this.size = size;
    }
    public void setCreationTS(String creationTS){
        this.creationTS = creationTS;
    }
    public void setReadTS(String readTS){
        this.readTS = readTS;
    }
    public void setWriteTS(String writeTS){
        this.writeTS = writeTS;
    }
    public void setReferenceCount(int referenceCount){
            this.referenceCount = referenceCount;
    }
    public void setNnumberOfPages(int numberOfPages){
            this.numberOfPages = numberOfPages;
    }

};