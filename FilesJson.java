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

public class FilesJson 
{
        List<FileJson> file;
        public FilesJson() 
        {
            
        }
    // getters
    public List<FileJson> getFile(){
        return this.file;
    }
    // setters
    public void setFile(List<FileJson> file){
        this.file = file;
    }
};

    