package dat3.car.ConsoleIO;

public class CarsConsoleApiInfo {
    public static void print()
    {
        printWelcome();
        printApiEndpoints();

    }

    private static void printWelcome()
    {
        System.out.println();
        System.out.println("Cars'r'rus api v0.01a");
        System.out.println();
    }

    private static void printApiEndpoints()
    {
        System.out.println("Available endpoints:");
        System.out.println();
        printEndPoint("","Welcome message");
        printEndPoint("cars","A list of all cars");
        printEndPoint("cars/addCar","Add a car object");
        printEndPoint("members","A list of all members");
        printEndPoint("h2-console/login.jsp","H2 UI interface for embedded database management");
    }

    private static void printEndPoint(String path, String description)
    {
        var domain = "\t http://localhost:8080/";

        System.out.println(domain + path + " : " + description);
    }
}
