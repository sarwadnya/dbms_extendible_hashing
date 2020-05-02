import java.util.*;
public class DBMS {
    public static void main(String[] args) {
        int global_depth=1;
        //  int local_depth;
        int bfr = 3;
        // System.out.println("enter the values of bfr,global and local depth");
        // Scanner sc=new Scanner(System.in);
        // bfr = sc.nextInt();
        // global_depth = sc.nextInt();
        // local_depth =sc.nextInt();
        // sc.close();
        int Directory_Size=(int)(Math.pow(2,global_depth));
        List<SinglyLinkedList> Directory = new ArrayList<SinglyLinkedList>();
        // List<LinkedList<Integer>> D = new ArrayList<LinkedList<Integer>>();
        // List<Integer> Local_Depth = new ArrayList<Integer>();
        List<SinglyLinkedList> ll = new ArrayList<SinglyLinkedList>();
        for (int i = 0; i < Directory_Size; i += 1)
        {
            SinglyLinkedList Sll = new SinglyLinkedList();
     //       Sll.setIndex(i);
      //      Sll.setLocalDepth(1);
            ll.add(Sll);
            Directory.add(Sll);
        }
        int[] myNum = {7,16,5,4,6,22,24,15}; //sample inputs, enter one by one and check output each time
        for(int i = 0;i < myNum.length; i++){

            int last_bits = getLastBits(myNum[i],global_depth);  

            Directory.get(last_bits).insertLast(myNum[i]);
            Directory.get(last_bits).setIndex(last_bits);
            if(Directory.get(last_bits).size()>bfr){
                if(global_depth==Directory.get(last_bits).getlocaldepth()){
                    global_depth = global_depth+1;
                    ll = change_ll(ll,Directory.get(last_bits),last_bits,global_depth);
                    Directory = restructure(Directory, ll, global_depth, last_bits);
                }
            //     else
            //         Directory = restructure(Directory, gd, ld);
            }
            for(int k = 0;k < ll.size(); k++){
                System.out.println(ll.get(k).getIndex());
                System.out.println("------------");
                ll.get(k).printLinkedList();
            System.out.println("*************");
            }
        }

 
    }
    static int getLastBits(int num,int d){        
        int number=(int)(Math.pow(2.00000,d)); 
        number--;
        return num&number;     // bitwise and 
    }
    static int find_second(int num){
        int i = 1;
        while(i<=num){
            i = i*2;
        }
        return i;
    }
    static List<SinglyLinkedList> restructure(List<SinglyLinkedList> Directory,List<SinglyLinkedList> ll, int gd, int ld){
        List<SinglyLinkedList> D = new ArrayList<SinglyLinkedList>();
        return D;
    }
    static List<SinglyLinkedList> change_ll(List<SinglyLinkedList> ll,SinglyLinkedList sll, int lb, int global_depth){
       // List<SinglyLinkedList> new_ll = new ArrayList<SinglyLinkedList>();
        SinglyLinkedList new_sll1 = new SinglyLinkedList();
        SinglyLinkedList new_sll2 = new SinglyLinkedList();
        for(int i = 0;i < ll.size(); i++){
            if(i==lb){

                int first_index = lb;
                int second_index = (int)Math.pow(2,(global_depth-1))+lb;
 

                sll.split(new_sll1,new_sll2, first_index, second_index, global_depth);

            }
        }
        //new_sll2.printLinkedList();
        ll.remove(sll);
        ll.add(new_sll1);
        ll.add(new_sll2);
        return ll;
    }
    
}