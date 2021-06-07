import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
class makeVideoTXT {
  public static void main(String[] args)throws IOException{

    // creates a file object
    File file = new File("videos");
    File result = new File("videos.txt");
    result.createNewFile();
    FileWriter temp = new FileWriter(result);
    // returns an array of all files

    String[] fileList = file.list();    
    for(String str : fileList) {
      String line = "videos/" + str + "\n";
      temp.write(line);
    }
    temp.flush();
    temp.close();
  }
}
