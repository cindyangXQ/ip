import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private static final String segLine = "    ____________________________________________________________";
    private static final String indent = "    ";
    private static final String logo = indent + " ____        _        \n"
            + indent + "|  _ \\ _   _| | _____ \n"
            + indent + "| | | | | | | |/ / _ \\\n"
            + indent + "| |_| | |_| |   <  __/\n"
            + indent + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String byePhrase = "Bye. Hope to see you again soon!";

    private final String name;
    private final List<String> tasks;

    private Duke(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    private void boot() {
        System.out.println(logo);
        System.out.println(segLine);
        System.out.println(indent + "Hello! I'm " + name + ".");
        System.out.println(indent + "What can I do for you?");
        System.out.println(segLine);
    }

    private void add(String s) {
        tasks.add(s);
        System.out.println(indent + "added: " + s);
    }

    private void list() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print(indent);
            System.out.print(i+1);
            System.out.println(". " + tasks.get(i));
        }
    }

    private void bye() {
        System.out.println(indent + byePhrase);
        System.out.println(segLine);
    }

    public static void main(String[] args) {
        Duke cindy = new Duke("Duke-Cindy");
        cindy.boot();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(segLine);
            if (s.equals("bye")) {
                cindy.bye();
                break;
            } else if (s.equals("list")) {
                cindy.list();
            } else {
                cindy.add(s);
            }
            System.out.println(segLine);
        }
    }
}
