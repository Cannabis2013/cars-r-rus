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
        printEndPoint("","SwaggerUI/OpenAPI interface");
        printEndPoint("h2-console","H2 web interface");
    }

    private static void printEndPoint(String path, String description)
    {
        var domain = "\t http://localhost:8080/";

        System.out.println(domain + path + " : " + description);
    }
}
