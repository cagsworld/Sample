package FileParse;
import java.io.*;

//----------------------------------------------------------------------------//
// FileInputHandler
//
// Summary: simplified file input
//
// Provides a simplified means of reading data (as a String) from 
// a file one line at a time.

class FileInputHandler
{
  private final BufferedReader reader;
  private final String filename;

  public FileInputHandler( String filename ) 
  {
    this.filename = filename;

    try 
    {
      reader = new BufferedReader( new FileReader( filename ) );
    } 
    catch (Exception e) 
    {
      System.err.println("FileInputHandler: Error opening file named \"" + 
			 filename + "\" for reading: " + e);
      throw new RuntimeException( 
	                 "FileInputHandler: Error opening file named \"" + 
			 filename + "\" for reading" );
    }
  }

  //-----------------------------------------------------------------
  // readLine() returns the first unread line from the file each time
  // it is called -- i.e., the first call returns the first line, the 
  // second call returns the second line, etc.  When all the lines 
  // have been read, readLine() returns null.
  
  public String readLine() 
  {
    String s = null;

    try 
    {
      s = reader.readLine();
    } 
    catch (Exception e) 
    {
      System.err.println("FileInputHandler: Error reading file named \"" + 
			 filename + "\" for reading: " + e);
      throw new RuntimeException( 
	                 "FileInputHandler: Error reading file named \"" + 
			 filename + "\" for reading" );
    }
    return s;
  }

  public void close() 
  {
    try 
    {
      reader.close();
    } 
    catch (Exception e) 
    {}
  }

  protected void finalize() throws Throwable
  {
    try 
    {
      reader.close();
    } 
    finally
    {
      super.finalize();
    }
  }
}
