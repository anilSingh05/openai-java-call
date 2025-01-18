import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        var apiKey = System.getenv("OPEN_AI_KEY"); // Replace with your OpenAI API key
        System.out.println("Calling OpenAI..." );

        var body = """
                    {
                    "model": "gpt-4o",
                    "messages": [
                        {
                            "role": "user",
                            "content": "Tell me some interesting facts about a famous person."
                        }
                    ]
                    }
                """;

        // Wrote code to call openai url https://api.openai.com/v1/chat/completions using  HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create("https://api.openai.com/v1/chat/completions"))
               .header("Authorization", "Bearer "+apiKey)
               .header("Content-Type", "application/json")
               .POST(HttpRequest.BodyPublishers.ofString(body))
               .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }
}