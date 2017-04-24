package ui;

import java.util.Arrays;
import java.util.Scanner;
import linkedlist2.Friend;
import linkedlist2.LinkedList;
import utility.Validator;

/**
 * A black book rating app.
 *
 * @author 55jphillip
 */
public class BBApp {

    LinkedList list;

    public BBApp() {
        this.list = new LinkedList();
        list.push(new Friend("Barb", 9));
        list.push(new Friend("Steve", 5));
        list.push(new Friend("Tom", 7));
        list.push(new Friend("Sue", 3));
        list.push(new Friend("Mark", 9));
        start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true) {
            menu();
            String regex = "^quit|add|remove|list|name|reverse|rating|search|range$";
            choice = Validator.getLine(sc, "Enter your choice: ", regex);
            if (choice.equalsIgnoreCase("quit")) {
                break;
            } else if (choice.equals("add")) {
                String name = Validator.getLine(sc, "Enter friend's name: ");
                int rating = Validator.getInt(sc, "Enter rating: ");
                list.push(new Friend(name, rating));
            } else if (choice.equals("remove")) {
                int index = Validator.getInt(sc, "Enter index to remove: ");
                list.delete(index);
            } else if (choice.equals("list")) {
                System.out.println(list);
            } else if (choice.equals("name")) {
                Friend[] fa = list.toArray();
                Arrays.sort(fa, (a, b) -> a.getName().compareTo(b.getName()));
                for (Friend f : fa) {
                    System.out.println(f.toString());
                }
            } else if (choice.equals("reverse")) {
                Friend[] fa = list.toArray();
                Arrays.sort(fa, (a, b) -> b.getName().compareTo(a.getName()));
                for (Friend f : fa) {
                    System.out.println(f.toString());
                }
            } else if (choice.equals("rating")) {
                Friend[] fa = list.toArray();
                Arrays.sort(fa, (a, b) -> Integer.compare(a.getRating(), b.getRating()));
                for (Friend f : fa) {
                    System.out.println(f.toString());
                }
            } else {

            }
        }
    }

    public void menu() {
        System.out.println("\nJohn's Black Book");
        System.out.println("Add - add a new friend");
        System.out.println("Remove - remove a friend");
        System.out.println("List - display list of friends");
        System.out.println("Name - display list of friends ordered by name");
        System.out.println("Reverse - display list of friends ordered by name descending");
        System.out.println("Rating - display list of friends ordered by rating");
        System.out.println("Search - search for a friend");
        System.out.println("Range - display friends in a range of ratings");
        System.out.println("Quit");
    }

    public static void main(String[] args) {
        BBApp app = new BBApp();
    }
}
