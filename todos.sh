#!/bin/bash
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

while true; do
  url="http://127.0.0.1:8080/todos/1"

  response=$(curl -o /dev/null -s -w "%{http_code}\n" --location --request GET "$url"
  )

  #echo "Response $response"

  if [ "$response" -eq 200 ]; then
    echo -e "${GREEN}Response $response${NC}"
  elif [ "$response" -eq 429 ]; then
    echo -e "${RED}Response $response${NC}"
  else
    echo "Response $response"
  fi

  #sleep .1
done