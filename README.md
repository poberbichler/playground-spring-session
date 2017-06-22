# playground-spring-session
Small sample application based on spring-session, redis and nginx for load balancing, supported by python accpetance tests.

To start the application, use maven and docker-compose to build and run the application:

```
> mvn package
> docker-compose build
> docker-compose up -d
```

After that, the application should be accessible on your local machine on port 5050.
If everything is working fine, the backend service can be scaled with docker-compose:

```
> docker-compose scale api=5
```
