# CloudApplicationsOPC
Projects course Advanced Cloud Applications OPC

## URLs of Project

### URL Git hub

https://github.com/lcoronad/CloudApplicationsOPC

### CURL Freelancers Service

The Freelancer service provides information about freelancers and have two enpoints 

1. Get information of all Freelancers
2. Get information for a Freelancer by id

The commands to test the endpoints are:

curl for get all freelancers

```
curl http://freelancer-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/freelancers
```

curl for get a freelancer by id

```
curl http://freelancer-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/freelancers/123457
```

### Projects Service

The Project service provides information about the projects and have three endpoints

1. Get information of all projects
2. Get information for a project by id
2. Get information of all projects by status

The commands to test the endpoints are:

curl for get all projects

```
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/projects
```

curl for get a project by id

```
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/projects/329299
```

curl for get all projects by status

```
curl http://project-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/projects/status/34.99
```



### Gateway Service

The API gateway is the entry point for front-end clients into the freelance4j application. The gateway orchestrates the calls to the services that make up the application and have five endpoints

1. Get information of all Freelancers
2. Get information for a Freelancer by id
3. Get information of all projects
4. Get information for a project by id
5. Get information of all projects by status

curl for get all freelancers

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/projects
```

curl for get a freelancer by id

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/projects/329299
```

curl for get all projects

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/projects/status/34.99
```

curl for get a project by id

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/freelancers
```

curl for get all projects by status

```
curl http://api-gateway-service-lcoronad-redhat-freelancer.apps.na311.openshift.opentlc.com/gateway/freelancers/123457
```


