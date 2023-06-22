package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> ops = new AList();
        SLList<Integer> S = new SLList<>();
        AList<Integer> Ns = new AList<>();
        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);

        AList<Double> stopwatch_times = new AList();

        for (int i=0;i<Ns.size();i++){
            System.out.println("i = "+i+"Ns.get(i) ="+Ns.get(i));
            for(int j=0;j<Ns.get(i);j++){
                S.addLast(j);
            }
            Stopwatch sw = new Stopwatch();
            System.out.println("S.size()= "+S.size());
                for(int k=0;k<10000;k++) {
                    S.getLast();
                }
            double timeInSeconds = sw.elapsedTime();
            stopwatch_times.addLast(timeInSeconds);
            ops.addLast(10000);
        }


        printTimingTable(Ns ,stopwatch_times,ops);
    }
    }



