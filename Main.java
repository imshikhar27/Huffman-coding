import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter you message:");
        String msg=sc.nextLine();

        HashMap<Character,String> encoderMap=new HashMap<>();
        Encoder enc=new Encoder();
        String encodedMsg=enc.encoderIt(msg,encoderMap);
        System.out.println("Encoded Message: "+encodedMsg);


        HashMap<String,Character> decoderMap=new HashMap<>();
        for(char ch:encoderMap.keySet())
        {
            decoderMap.put(encoderMap.get(ch),ch);
        }
        Decoder dec=new Decoder();
        String decodedMsg=dec.decodeIt(encodedMsg,decoderMap);
        System.out.println("Decoded Message: "+decodedMsg);

    }
}
