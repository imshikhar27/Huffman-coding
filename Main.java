import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //Receiving message from user
        System.out.println("Enter you message:");
        String msg=sc.nextLine();

        //map to store encoded term for each character
        HashMap<Character,String> encoderMap=new HashMap<>();
        Encoder enc=new Encoder();
        //Sending message to Encoder class and receiving encoded message
        String encodedMsg=enc.encoderIt(msg,encoderMap);
        System.out.println("Encoded Message: "+encodedMsg);

        //creating decoder map
        HashMap<String,Character> decoderMap=new HashMap<>();
        for(char ch:encoderMap.keySet())
        {
            decoderMap.put(encoderMap.get(ch),ch);
        }
        Decoder dec=new Decoder();
        //sending encoded message to Decoder class and retrieving the message
        String decodedMsg=dec.decodeIt(encodedMsg,decoderMap);
        System.out.println("Decoded Message: "+decodedMsg);

    }
}
