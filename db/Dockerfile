FROM postgres
# Add a database
ENV POSTGRES_DATABASE postgres
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY /db/schema.sql/ /docker-entrypoint-initdb.d/