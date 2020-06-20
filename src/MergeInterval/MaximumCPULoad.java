package MergeInterval;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};
public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Job> jobs) {
        Collections.sort(jobs,(a,b)->Integer.compare(a.start,b.start));
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(),(a,b)->Integer.compare(a.end,b.end));
        int maxCPULoad = 0;
        int currentCPULoad = 0;
        for(Job job:jobs)
        {
            while (!minHeap.isEmpty() &&  minHeap.peek().end < job.start)
            {
                currentCPULoad-=minHeap.poll().cpuLoad;
            }
            currentCPULoad += job.cpuLoad;
            maxCPULoad = Math.max(maxCPULoad,currentCPULoad);
            minHeap.offer(job);
        }

        return maxCPULoad;

    }
}
