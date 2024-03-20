FROM ubuntu:latest
LABEL authors="osman"

ENTRYPOINT ["top", "-b"]