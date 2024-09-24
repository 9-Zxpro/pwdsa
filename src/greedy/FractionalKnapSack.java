package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int profit;
    int weight;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return profit + " " + weight;
    }
}

public class FractionalKnapSack {

    static int maxProfit(Item[] item, int w) {
        int maxprofit = 0;
        for(int i=0; i< item.length && w > 0; i++) {
//            System.out.println(maxprofit);
            if(item[i].weight <= w) {
                maxprofit += item[i].profit;
                w -= item[i].weight;
            }
            else {
                maxprofit += ((item[i].profit/item[i].weight) * w);
                w = 0;
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {

        int[] profit = {100, 300, 200, 900, 400, 600};
        int[] weight = {10, 20, 15, 20, 10, 5};
        int n = profit.length;

        Item[] item = new Item[n];

        for (int i = 0; i < n; i++) {
            item[i] = new Item(profit[i], weight[i]);
        }

        Comparator<Item> cm = (Item o1, Item o2) -> {
//            double d1 = (double) o1.profit/(double) o1.weight;

            if(o1.profit/ o1.weight < o2.profit/ o2.weight) return 1;
            else return -1;
        };

        Arrays.sort(item, cm);

        int capacity = 40;

        System.out.println(maxProfit(item, capacity));

        for (var i : item) {
//            System.out.println(item[i].profit+" "+item[i].weight);
            System.out.println(i);

        }

    }
}
class Solution {
    public static void sortMeetings(int[] start, int[] end, Meetings[] meetings) {


        Comparator<Meetings> cm = (Meetings m1, Meetings m2) -> {
            if(m1.end < m2.end) return -1;
            else return 1;
        };
        Arrays.sort(meetings, cm);

    }
    public static int maximumMeetings(int []start, int []end) {
        int n = start.length;
        Meetings[] meetings = new Meetings[n];
        for(int i = 0; i<n; i++) {
            meetings[i] = new Meetings(start[i], end[i]);
        }
        sortMeetings(start, end, meetings);
        for (int i=0; i<n; i++) {
            System.out.println(meetings[i].end);
        }
        return 0;
    }
}

class Meetings {
    int start;
    int end;

    Meetings(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString () {
        return start + " " + end;
    }
}