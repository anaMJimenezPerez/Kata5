import spark.Spark;
public class Main {
    public static void main(String[] args) {
        CommandExecutor.put("fibo", new FiboCommand());
        Spark.port(8080);
        Spark.get("/fibo", (req, res) -> CommandExecutor.with(req, res).execute("fibo"));
    }
}
