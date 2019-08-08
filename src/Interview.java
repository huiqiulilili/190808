import java.util.List;

class ListCode{
    int val;
    ListCode next;

    ListCode(int val){
        this.val = val;
    }

    public String toString(){
        return String.format("Node(%d)",val);
    }
}

class Review{
    public static ListCode pusgFront(ListCode head,int val){
        ListCode newListCode = new ListCode(val);
        newListCode.next = head;
        return newListCode;
    }

    public static ListCode popBack(ListCode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return null;
        }
        ListCode lastLast = head;
        while (lastLast.next.next != null){
            lastLast = lastLast.next;
        }
        lastLast.next = null;
        return head;
    }
}

class Solution{
    public static ListCode reverseList(ListCode head){
        ListCode result = null;
        ListCode cur = head;
        while(cur != null){
            ListCode next = cur.next;

            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    public static ListCode removeElements(ListCode head,int val){
        if(head == null){
            return null;
        }
        ListCode prev = head;
        ListCode cur = head.next;
        while(cur != null){
            if(cur.val ==val){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }

    public static ListCode removeElements2(ListCode head,int val){
        ListCode result = null;
        ListCode last = null;
        ListCode cur = head;
        while (cur != null){
            if(cur.val != val){
                if(result == null){
                    result = cur;
                }else {
                    last.next = cur;
                }
                last = cur;
            }
            cur = cur.next;
        }
        if(last != null){
            last.next = null;
        }
        return result;
    }

    public static ListCode FindKthToTail(ListCode head,int k){
        int length = 0;
        for(ListCode cur = head;cur != null;cur = cur.next){
            length++;
        }
        if(length < k){
            return null;
        }
        int n = length - k;
        ListCode kth = head;
        for(int i = 0;i < n;i ++){
            kth = kth.next;
        }
        return kth;
    }
}
public class Interview {
}
