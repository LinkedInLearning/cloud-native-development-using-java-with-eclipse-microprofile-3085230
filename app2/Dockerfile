FROM open-liberty:beta-java11
COPY --chown=1001:0 src/main/liberty/config /config/
COPY --chown=1001:0 target/demo.war /config/dropins
RUN configure.sh
EXPOSE 9080 9443
