
public class Runner {
    public static void main(String[] args) {
        String path = args[0];
        String outputFile = args[1];
        Tree.tree(path,outputFile,"",false);
    }
}
