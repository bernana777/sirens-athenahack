import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Scanner;

public class ReadNetFile
{

    public static Scanner readNetFile(String filename){
        Scanner in = null; //null is not sensible. Please change
            try
        {
            File file = new File(filename);
            in = new Scanner(file);
        }
            catch (
        FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return in;

    }

    public static Net initNet(Scanner in){
        Net net = new Net();

        while (in.hasNext()) //run loop until at the end of the file
        {
            //reads line from file
            String fileSplit = in.nextLine();
            Scanner line = new Scanner(fileSplit);
            double longitude = line.nextDouble();
            double latitude = line.nextDouble();
            Time time = Time.valueOf(line.next());
            Location location = new Location(longitude, latitude, time);
            net.addLocation(location);
            net.setID(Net.getCount());
        }
        return net;
    }
}
