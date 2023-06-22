package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void timeAListConstruction() {
        AList<Integer> A = new AList();
        AList<Integer> Ns = new AList<>();

        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(12800000);

        AList<Double> stopwatch_times = new AList();

        for (int i=0;i<Ns.size();i++){
            Stopwatch sw = new Stopwatch();
            for(int j=0;j<Ns.get(i);j++){
                A.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();
            stopwatch_times.addLast(timeInSeconds);
        }


        printTimingTable(Ns ,stopwatch_times,Ns);
    }

    public static void main(String[] args) {

        timeAListConstruction();
    }
}
