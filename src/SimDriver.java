import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
// import java.util.ArrayIndexOutOfBoundsException;

public class SimDriver {
	public static void main(String[] args) {
		/** Circular list of stations in kitchen */
		CList<CookingStation> stations = new CList<CookingStation>();


		//Reading file, taken from ReadFile.java on class site
		Scanner infile = null;
        boolean inerror = false;

        try {
            System.out.println("0 " + args[0] + " should be input filename");
            infile = new Scanner(new FileReader(args[0]));
        } catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("must give input filename at command line");
            inerror = true;
        } catch (IOException f) {
            System.err.println("can't open that file, try again");
            inerror = true;
        }
        if (inerror) {
            System.err.println("exiting...");
            System.exit(1);
        }
        
        Scanner inline;
        String line;
        String name, item;
        int time, under, over;
        while (infile.hasNext()) {
            name = infile.nextLine();

            CookingStation c = new CookingStation(name);
            stations.insert(c);

            line = infile.nextLine();
            while (!line.equals("")) {
                inline = new Scanner(line);
                item = inline.next();
                time = inline.nextInt();
                under = inline.nextInt();
                over = inline.nextInt();
                
                CookingItem i = new CookingItem(item, time, under, over);
                c.addItem(i);
                //name += " " + item + " " + time + " " + under + " " + over;
                line = infile.nextLine();
            }
            //System.out.println(name);
        }

        String str = "[ ";
        while(!stations.isAtEnd()) {
        	str += stations.getValue().toString();
        }
        str += "]";
        System.out.println(str);


	}
	
}