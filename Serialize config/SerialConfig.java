import java.io.*;
public class SerialConfig extends ObjectOutputStream {

    public SerialConfig(OutputStream os) throws IOException {
        super(os);
    }
    
    protected void writeStreamHeader() throws IOException {
        reset(); 
    }

}