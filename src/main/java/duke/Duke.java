package duke;

import java.util.Scanner;

public class Duke {
    private final static String NAME = "Cindy's Duke Bot";
    private final String path;

    public Duke(String path) {
        this.path = path;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        TaskList taskList = new TaskList();
        Storage storage = new Storage(path);
        Ui ui = new Ui(NAME);
        Parser parser = new Parser(sc, taskList);

        ui.boot();
        try {
            storage.loadTo(taskList);
        } catch (DukeException e) {
            System.err.println(e.toString());
        }
        ui.start();
        parser.parse();
        storage.writeFrom(taskList);
    }

    public static void main(String[] args) {
        new Duke("./duke.txt").run();
    }
}








