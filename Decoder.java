import java.util.*;
public class Decoder {
    public String decodeIt(String encodedMsg,HashMap<String,Character> decoder)
    {
        StringBuilder temp=new StringBuilder();
        StringBuilder decodedMsg=new StringBuilder();
        for(int i=0;i<encodedMsg.length();i++)
        {
            char ch=encodedMsg.charAt(i);
            temp.append(ch);
            String tp=temp.toString();
            if(decoder.containsKey(tp)) {
                char eCh = decoder.get(tp);
                decodedMsg.append(eCh);
                temp.delete(0,temp.length());
            }
        }
        return decodedMsg.toString();
    }
}
