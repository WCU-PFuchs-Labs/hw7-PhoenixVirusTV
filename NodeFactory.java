import java.util.Random;

public class NodeFactory {
    private int numIndepVars;
    private Binop[] currentOps;

    public NodeFactory(Binop[] ops, int numVars){
        currentOps = ops;
        numIndepVars = numVars;
    }

    public Node getOperator(Random rand){
        return new Node((Binop)currentOps[rand.nextInt(currentOps.length)].clone(), null, null);
    }

    public Node getTerminal(Random rand){
        if(rand.nextBoolean()){
            // 2 decimal places for constants
            double val = Math.round(rand.nextDouble()*100.0)/100.0;
            return new Node(new Const(val));
        } else {
            int index = rand.nextInt(numIndepVars);
            return new Node(new Variable(index));
        }
    }

    public int getNumOps(){ return currentOps.length; }
    public int getNumIndepVars(){ return numIndepVars; }
}
