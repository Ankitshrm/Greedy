import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class meeting{
    int start;
    int end;
    int pos;

    meeting(int start,int end,int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}


class meetingCompare implements Comparator<meeting>{
    @Override
    public int compare(meeting o1, meeting o2) {
       if(o1.end<o2.end) return -1;
       else if(o1.end>o2.end) return 1;
       else if(o1.pos<o2.pos) return -1;
       return 1;
    }
    
}
public class njob{

    private static void sol(int start[],int end[],int pos){
        ArrayList<meeting> meet =new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meet.add(new meeting(start[i], end[i], i+1));
        }
        meetingCompare mc =new meetingCompare();
        Collections.sort(meet,mc);
        ArrayList<Integer> ans =new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit=meet.get(0).end;
        for(int i=1;i<start.length;i++)
        {
            if(meet.get(i).start>limit){
                ans.add(meet.get(i).pos);
                limit=meet.get(i).end;
            }
        }

        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        int start[]={1,0,3,8,5,8};
        int end[]={2,6,4,9,7,9};
        int n=start.length;

        sol(start,end,n);
    }
}