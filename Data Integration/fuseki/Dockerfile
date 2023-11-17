FROM stain/jena-fuseki

ADD datasets ./datasets

ENV ADMIN_PASSWORD admin

EXPOSE 3030

CMD /bin/sh -c "./fuseki-server --file ./datasets/* /ds"