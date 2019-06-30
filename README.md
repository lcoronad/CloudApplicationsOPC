# CloudApplicationsOPC
Projects for assignment of course Advanced Cloud Applications OCP for business case Freelancers4J inc.

This project have four directories

* api-gateway-service: Entry point for front-end clients
* freelancer-service: Provides information about freelancers
* project-service: Provides information about projects
* ocp: Commands for create projects and applications in OpenShift 3.11, and templates for databases MongoDB and PostgreSQL in format YAML

The microservices is deployed in Red Hat Opentlc over OpenShift 3.11 Shared access this environment is active until 04/07/2019.

## URL Git hub

* [URL Freelancer4J](https://github.com/lcoronad/CloudApplicationsOPC) - URL of Git for the source code.

## Freelancers Service

The Freelancer service provides information about freelancers and have three enpoints, is developed in SpringBoot whit the next tiers.

1. SpringBoot root Application: Class main of SpringBoot
2. Model: Objects that represents the business entities (Model of Freelance), and interface of Spring Repository
3. Rest: Classes that expose the service endpoints and call the business logic and health check endpoint
4. Service: Classes that implements the business logic and connect to database PostgreSQL using JPA and Srping Repository.

This service use PostgreSQL like repository and the data for connection is in a ConfigMap. The health check and route that use OpenShift is configured in YAML into fabric8 directory.

The unit test is developed whit SpringRunner.

The PostgreSQL application is created from YAML template, this template is in directory ocp/freelancer/freelancer-service-postgresql-persistent.yaml

The service application is deployed in Openshift whit fabric8 and maven.

### Endpoints

1. Get information of all Freelancers

curl for get all freelancers

```
curl http://freelancer-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/freelancers
```

2. Get information for a Freelancer by id

curl for get a freelancer by id

```
curl http://freelancer-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/freelancers/123457
```

3. Health check

curl for health check

```
curl http://freelancer-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/health
```

## Projects Service

The Project service provides information about the projects and have five endpoints, is developed in Vert.x whit the next tiers.

1. MainVerticle: Main verticle that deploy others verticles and retreive the enviroment variables.
2. ApiVerticle: Verticle that expose the five endpoints three business endpoint and two of health check, too create the server to listen requests.
3. Model: Objects that represents the business entities (Model of Project)
4. Service: Classes that implements the business logic and connect to database MongoDB using MongoClient of Vert.x.

This service use Mongo like repository and the data for connection is in a ConfigMap. The health check and route that use OpenShift is configured in YAML into fabric8 directory.

The unit test is developed whit VertxUnitRunner.

The Mongo application of OpenShift is created from YAML template, this template is in directory ocp/freelancer/freelancer-project-mongodb-persistent.yaml

The service application is deployed in Openshift whit fabric8 and maven.

### Endpoints

1. Get information of all projects

curl for get all projects

```
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/projects
```

2. Get information for a project by id

curl for get a project by id

```
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/projects/329299
```

3. Get information of all projects by status

curl for get all projects by status

```
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/projects/status/34.99
```

4. Health check

curl for health check

```
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/health/readiness
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/health/liveness
```

## Gateway Service

The API gateway is the entry point for front-end clients into the freelance4j application. The gateway orchestrates the calls to the services that make up the application and have six endpoints, is developed in Thorntail whit the next tiers.

1. Application: Root application for Thorntail.
2. Rest: Classes that expose the service endpoints and call the business logic, and health check endpoint.
3. Model: Objects that represents the business entities (Model of Freelancer and Project)
4. Service: Classes that consume the backends services (Project and Freelancer) using Resteasy.

This service use a ConfigMap for the URL of the backend services. The health check, volumens, config map, java options and route that use OpenShift is configured in YAML into fabric8 directory.

The unit test is developed whit Arquillian.

The service application is deployed in Openshift whit fabric8 and maven.

### Endpoints

1. Get information of all Freelancers

curl for get all freelancers

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/projects
```

2. Get information for a Freelancer by id

curl for get a freelancer by id

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/projects/329299
```

3. Get information of all projects

curl for get all projects

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/projects/status/34.99
```

4. Get information for a project by id

curl for get a project by id

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/freelancers
```

5. Get information of all projects by status

curl for get all projects by status

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/freelancers/123457
```

6. Health Check

curl for health check

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/health
```

## Author

* **Lázaro Miguel Coronado Torres** - *Middleware Senior Consultant - lcoronad@redhat.com* 

