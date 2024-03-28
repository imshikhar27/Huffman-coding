import java.util.*;
public class Encoder{
    public String  encoderIt(String msg,HashMap<Character,String> encoder)
    {
        int[] freq=new int[256];
        //counting frequency of characters in msg
        this.countChar(freq,msg);

        PriorityQueue<Node> queue=new PriorityQueue<>();
        //inserting character nodes in priority queue
        this.insertInQueue(freq,queue);
        //building huffman tree
        this.getHuffmanTree(queue);

        StringBuilder sb=new StringBuilder();
        Node head=queue.poll();
        //creating encoded term for each charcter using Huffman tree
        this.getEncBits(head,sb,encoder);

        StringBuilder encodedMsg=new StringBuilder();
        //generating encoded msg
        this.encMsg(msg,encoder,encodedMsg);
        return encodedMsg.toString();
    }
    public void countChar(int[] freq,String msg)
    {
        for(int i=0;i<msg.length();i++)
        {
            char ch=msg.charAt(i);
            freq[ch]++;
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
        //removing two nodes with the least frequency
        Node left=queue.remove();
        Node right=queue.remove();

        //Adding a new node in queue with total frequency as sum of left and right
        //and assigning left node to left pointer of new node and right node to right pointer of new node respectively
        int totalFreq=left.count+right.count;
        queue.add(new Node('\0',totalFreq,left,right));
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
