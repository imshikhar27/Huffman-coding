public class Node implements Comparable<Node>{

        char ch;
        int count;
        Node left,right;
        Node(char ch,int count)
        {
            this.ch=ch;
            this.count=count;
        }
        Node(char ch,int count,Node left,Node right)
        {
            this.ch=ch;
            this.count=count;
            this.left=left;
            this.right=right;
        }

    @Override
    public int compareTo(Node o) {
            if(this.count>o.count)
                return 1;
            if(this.count<o.count)
               return -1;
            return 0;
    }
}

