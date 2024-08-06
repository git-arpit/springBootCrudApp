
# SpringBoot CRUD Application

## Overview
This is a SpringBoot application that performs CRUD operations on employee records using H2 in-memory database. The application utilizes Spring Data JPA for database interactions.

## Requirements 
- Java 17
- Spring Boot 3

### Author

- [@git-arpit](https://www.github.com/git-arpit)

## Getting Started 
### Clone the repository 

```sh
  git clone https://github.com/git-arpit/springBootCrudApp.git
```

### Build the application
```sh
  mvn clean install
```
### Run the application
```sh
  mvn spring-boot:run
```
The application will start on https://localhost:9090.


## API Reference

#### Add employee details
```http
  POST /home/addemp
```
| Parameter      | Type       | Description                                                                       |
|:---------------|:-----------|:----------------------------------------------------------------------------------|
| `Request Body` | `Employee` | **Required**. Employee details as JSON in Request body is required to add details |

Request body JSON Example
```json
{
    "name": "Charlie",
    "primarySkill": "Core Java",
    "secondarySkill": "SQL",
    "empId": "1993203",
    "comments": "Strong Core Java developer with experience in the financial domain"
}
```

#### Get all employees
```http
  GET /home/emps
```
| Parameter | Type | Description                                           |
|:----------|:-----|:------------------------------------------------------|
| `NA`      | `NA` | Returns list of all the employees present in database |

#### Get employee by id
```http
  GET /home/emp/${id}
```
| Parameter | Type     | Description                          |
|:----------|:---------|:-------------------------------------|
| `id`      | `string` | **Required** Id of employee to fetch |

#### Update existing employee details
```http
  PUT /home/update
```
| Parameter      | Type       | Description                                                                         |
|:---------------|:-----------|:------------------------------------------------------------------------------------|
| `Request body` | `Employee` | **Required** Employee details as JSON in Request body is required to update details |

Request body JSON Example
```json
{
  "name": "Sammy",
  "primarySkill": "Core Java",
  "secondarySkill": "SpringBoot",
  "empId": "1993203",
  "comments": "Strong Core Java developer with experience in the financial domain"
}
```
#### Delete employee record by Id
```http
  DELETE /home/del/${id}
```
| Parameter | Type     | Description                            |
|:----------|:---------|:---------------------------------------|
| `id`      | `string` | **Required** Id of employee to delete. |

#### Search employee record by keywords in "Comments"
```http
  POST /home/search
```
| Parameter           | Type             | Description                                                                                                                            |
|:--------------------|:-----------------|:---------------------------------------------------------------------------------------------------------------------------------------|
| `Request Parameter` | `key-value pair` | **Required** request parameter in key-value pair form (Ex. keyword=java). Returns lsit of employee containing "keyword" in "comments". |
