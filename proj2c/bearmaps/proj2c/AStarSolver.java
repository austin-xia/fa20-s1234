package bearmaps.proj2c;

import bearmaps.proj2ab.ArrayHeapMinPQ;
import edu.princeton.cs.algs4.Stopwatch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AStarSolver<Vertex> implements ShortestPathsSolver {

    private ArrayHeapMinPQ<Vertex> PQ;
    private AStarGraph<Vertex> input;
    private Vertex start;
    private Vertex end;
    private double timeout;
    private double solutionweight;
    private int numofdequeue;
    private double explorationtime;

    private List<Vertex> PATH; //the final solution path
    private int solnum; //use for determine which outcome should be outputted

    //hashmap to store the distance to source, this will only be changed when be relaxed
    private HashMap<Vertex, Double> distostart;
    //stores the pre-vertex, this will only be changed when be relaxed
    private HashMap<Vertex, Vertex> preVertex;
    //vertex will be marked if it is already removed from the PQ
    private HashMap<Vertex, Boolean> marked;


    public AStarSolver (AStarGraph<Vertex> input, Vertex start, Vertex end, double timeout){
        this.input = input;
        this.start = start;
        this.end = end;
        this.timeout = timeout;
        solutionweight = 0;

        PQ = new ArrayHeapMinPQ<Vertex>();
        PQ.add(start, 0);

        distostart = new HashMap<>();
        distostart.put(start, (double) 0);

        preVertex = new HashMap<>();
        marked = new HashMap<>();

        PATH = new ArrayList<>();

        solution();
    }

    @Override
    public SolverOutcome outcome(){
        if (solnum == -1){
            return SolverOutcome.UNSOLVABLE;
        } else if (solnum == 0){
            return SolverOutcome.SOLVED;
        } else {
            return SolverOutcome.TIMEOUT;
        }
    }


    @Override
    /* there is no (edge to, dist to) help list as the total amount of vertex is unknown
    and also the help list only applies to integar vertex
    there are two hashmap to store the helper message: distostart and preVertex
     */
    public List<Vertex> solution(){

        if (PATH.size() != 0){
            return PATH;
        }

        int currentDQ = -1;
        Stopwatch SW = new Stopwatch();
        double time = 0;
        while (true){
            if (PQ.size() == 0) {
                solnum = -1; //cannot find the path, which means the start/end is not connected
                numofdequeue = currentDQ;
                explorationtime = time;
                break;
            }
            if (PQ.getSmallest() == end){
                solnum = 0; //find the path within time limit
                numofdequeue = currentDQ;
                explorationtime = time;
                solutionweight = PQ.getpriority(end);
                getSolutionlist();
                break;
            }
            if (time >= timeout){
                solnum = 1; //timeout
                numofdequeue = currentDQ;
                explorationtime = time;
                break;
            }
            Vertex P = PQ.removeSmallest();
            currentDQ += 1;
            marked.put(P,true);
            relax(P);
            time = SW.elapsedTime();
        }
        return PATH;
    }

    private void getSolutionlist(){
        getSLhelper(end); //this will put the shortest path into PATH but in reverse order
        reverseList();
    }

    private void getSLhelper (Vertex P){
        if (P == start){
            PATH.add(P);
            return;
        }
        PATH.add(P);
        Vertex PreP = preVertex.get(P);
        getSLhelper(PreP);
    }

    private void reverseList (){
        List<Vertex> Helper = new ArrayList<>();
        for (int N = PATH.size()-1; N >=0 ; N -= 1){
            Helper.add(PATH.get(N));
        }
        PATH = Helper;

    }

    /*private void resize(){
        Vertex[] SList2 = (Vertex[]) Array.newInstance(Object.class,
                SList.length * solutionarrayresizefactor);
        for (int i = 0; i < SList.length; i += 1){
            SList2[i] = SList[i];
        }
        SList = SList2;
    }
    **/

    private void relax(Vertex P){
        List<WeightedEdge<Vertex>> Pedges = input.neighbors(P);

        //get the real weight from the hashmap
        double Pweight = distostart.get(P);

        for (WeightedEdge<Vertex> E : Pedges){
            Vertex calculator = E.to();
            double priority = Pweight + E.weight() + input.estimatedDistanceToGoal(calculator, end);
            if (PQ.contains(calculator)){

                //only relax the vertex if the new priority is less the current
                //change the two helper hashmap here when the vertex is acutally get relaxed
                if (PQ.getpriority(calculator) > priority) {
                    PQ.changePriority(calculator, priority);
                    distostart.put(calculator,Pweight + E.weight());
                    preVertex.put(calculator,P);
                }
            } else if (!marked.containsKey(calculator)) {
                PQ.add(calculator,priority);
                distostart.put(calculator,Pweight + E.weight());
                preVertex.put(calculator,P);
            }
        }
    }

    @Override
    public double solutionWeight(){
        return solutionweight;
    }


    @Override
    public int numStatesExplored(){
        return numofdequeue;
    }


    @Override
    public double explorationTime(){
        return explorationtime;
    }


}
