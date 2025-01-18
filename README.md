### Calling Open  AI using shell script  - 

```
#!/bin/zsh
echo "Calling OpenAI..."
prompt="Tell me something interesting about OpenAI"

# Send the request to the OpenAI API
curl https://api.openai.com/v1/chat/completions \
 -H "Authorization: Bearer ${OPEN_AI_KEY}" \
 -H "Content-Type: application/json" \
 -d '{"model":"gpt-4o", "messages":[{"role":"user", "content": "'"${prompt}"'"}]}'
```

### Calling OpenAI using Java HttpRequest method - 

```
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
```
