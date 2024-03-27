import java.util.*;
public class Encoder{
    public String  encoderIt(String msg,HashMap<Character,String> encoder)
    {
        int[] freq=new int[256];
        this.countChar(freq,msg);

        PriorityQueue<Node> queue=new PriorityQueue<>();
        this.insertInQueue(freq,queue);
        this.getHuffmanTree(queue);

        StringBuilder sb=new StringBuilder();
        Node head=queue.poll();
        this.getEncBits(head,sb,encoder);

        StringBuilder encodedMsg=new StringBuilder();
        this.encMsg(msg,encoder,encodedMsg);
        return encodedMsg.toString();
    }
    public void countChar(int[] freq,String msg)
    {
        for(int i=0;i<msg.length();i++)
        {
            char ch=msg.charAt(i);
            freq[(int)ch]++;
        }
    }
    public void insertInQueue(int[] freq,PriorityQueue<Node> queue)
    {
        for(int i=0;i<256;i++)
        {
            if(freq[i]==0)
                continue;
            queue.add(new Node((char)i,freq[i]));
        }
    }

    public void getHuffmanTree(PriorityQueue<Node> queue)
    {
        if(queue.size()==1)
            return;
        Node left=queue.remove();
        Node right=queue.remove();

        int totalFreq=left.count+right.count;
        queue.add(new Node('*',totalFreq,left,right));
        getHuffmanTree(queue);
    }

    public void getEncBits(Node head,StringBuilder sb,HashMap<Character,String> encoder)
    {
        Node left=head.left;
        Node right=head.right;
        if(left==null && right==null)
        {
            encoder.put(head.ch,sb.toString());
            return;
        }
        getEncBits(left,sb.append("0"),encoder);
        sb.delete(sb.length()-1,sb.length());
        getEncBits(right,sb.append("1"),encoder);
        sb.delete(sb.length()-1,sb.length());
    }

    public void encMsg(String msg,HashMap<Character,String> encoder,StringBuilder encodedMsg)
    {
        for(int i=0;i<msg.length();i++)
        {
            char ch=msg.charAt(i);
            String e= encoder.get(ch);
            encodedMsg.append(e);
        }
    }
}
