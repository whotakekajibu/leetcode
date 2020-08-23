package offers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description
 * @Date 2020/5/22 0:23
 **/
class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || !minHeap.isEmpty() && num <= minHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance(maxHeap, minHeap);
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        }
        if (minHeap.isEmpty()) {
            return maxHeap.peek();
        }
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public void balance(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
        while (maxHeap.size() - minHeap.size() >= 2) {
            int top = maxHeap.poll();
            minHeap.add(top);
        }
        while (minHeap.size() > maxHeap.size()) {
            int top = minHeap.poll();
            maxHeap.add(top);
        }
        while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int max = maxHeap.poll();
            int min = minHeap.poll();
            maxHeap.add(min);
            minHeap.add(max);
        }
    }

    class MedianFinderElegant {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinderElegant() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        }

        public void addNum(int num) {
            if (minHeap.size() != maxHeap.size()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
        }
    }
}
