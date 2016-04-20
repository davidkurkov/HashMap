
/**
 * Created by david on 4/19/16.
 */
public class Watch implements stopwatch {
    static HashMap results;
    String event;
    int startTime;
    int endTime;
    int totalTime;

    Watch(String event) {
        this.event = event;
        results = new HashMap();
    }

    @Override
    public void start() {
        startTime = (int) System.currentTimeMillis();
    }

    @Override
    public void stop() {
        endTime = (int) System.currentTimeMillis();
        totalTime = (endTime - startTime) / 1000;
        results.put(this.event, totalTime);
    }

    @Override
    public void printResults() {
        StringBuilder formattedResults = new StringBuilder();
        for (String key: results.keys()) {
            formattedResults.append(key);
            formattedResults.append(" took ");
            formattedResults.append(results.get(key));
            formattedResults.append("s");
            formattedResults.append("\n");
        }
        System.out.print(formattedResults);
    }
}
