import java.io.*;

public class test {
   public static void main(String[] args) throws IOException {
   		if (args.length != 1) 
   			System.err.println("Args error");
   		else {
   			System.out.print("Your IP Address is: " + args[0]);
   			try (InputStreamReader cin = new InputStreamReader(System.in)) {
   				char c;
   				while (true) switch (c = (char) cin.read()) {
   						case 'R':
   							System.out.print("Card reader is ready"); 
   							break;
   						case 'P':
   							System.out.print("Max Mustermann, debil, 20");
   							break;
   						case 'T':
   							System.out.print("Pseudo Ecard");
   							break;
   						case 'Q':
   							cin.close();
   							System.exit(-1);
   							break;
   						default:
   							System.err.print("Wrong command code");
   					}
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   }
}
