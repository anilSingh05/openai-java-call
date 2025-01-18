#!/bin/zsh
echo "Calling OpenAI..."
prompt="Tell me something interesting about OpenAI"

# Send the request to the OpenAI API
curl https://api.openai.com/v1/chat/completions \
 -H "Authorization: Bearer ${OPEN_AI_KEY}" \
 -H "Content-Type: application/json" \
 -d '{"model":"gpt-4o", "messages":[{"role":"user", "content": "'"${prompt}"'"}]}'