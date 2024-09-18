#!/usr/bin/env bash

for i in {1..50}
do
  response=$(grpcurl -plaintext -d '{"name": "hello"}' localhost:8080 am.plotnikov.bugreport1.grpc.Greeter/SayHello)
  echo "Try $i times: $response"
  sleep .5
done