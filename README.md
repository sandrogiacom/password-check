# Password Check Service

## Microservice for password pattern validation

**To validate a password pattern, just call:**

```shell
curl -X POST "http://localhost:8080/api/v1/passwords" -d "Pasword@123"
```

Responses:

**true** if the password passes validation

**false** if the password does not pass validation


**Ease to configure:**

Define a password pattern with requirements that can be passed by environment variable:

- Minimum characters
- Maximum characters
- Minimum numbers
- Minimum lowercase letters
- Minimum uppercase letters
- Minimum of special characters
- Set of special characters allowed
  
## Validations

By default, the service **does not** accept passwords with **blanks** in any position and **repeating characters**.

Other validations will be performed according to the configured rules defined by the requirements above

## Running

### With docker

```shell
docker run -p 8080:8080 --name password-check sandrogiacom/password-check
```

### With docker compose

**At the root of the project, run:**

```shell
docker-compose up
```

## Running the project from source code:

### Requirements

* [Java 11](https://adoptopenjdk.net/) or superior.
* [Maven 3.5.4](https://maven.apache.org/download.cgi) or superior.

**At the root of the project, run:**

```shell
mvn spring-boot:run
```

## Access to API documentation

[http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)


## Configuration

To customize password validation requirements, you can set the environment variables below:

|      ENV                      |DESCRIPTION                            |DEFAULT VALUE  |
|-------------------------------|---------------------------------------|---------------|
|MINIMUM_LENGTH                 | Minimum length                        |1              |
|MAXIMUM_LENGTH                 | Maximum lenght                        |50             |
|MINIMUM_NUMBERS                | Minimum numbers                       |9              |
|MINIMUM_LOWERCASE_LETTERS      | Minimum lowercase letters             |1              |
|MINIMUM_UPPERCASE_LETTERS      | Minimum uppercase letters             |1              |
|MINIMUM_SPECIAL_CHARACTERS     | Minimum of special characters         |1              |
|ACCEPTED_SPECIAL_CHARACTERS    | Set of special characters allowed     |!@#$%^&*()-+   |

To **disable** any of the settings, just enter the value zero. Ex:

`MINIMUM_SPECIAL_CHARACTERS=0`

This setting disables the requirement for at least one special character.

### Show Configurations

```shell
curl -X GET "http://localhost:8080/api/v1/configurations"
```

```json
{
  "minimumLength": 9,
  "maximumLength": 50,
  "minimumUpperCaseLetters": 1,
  "minimumLowerCaseLetters": 1,
  "minimumNumbers": 1,
  "minimumSpecialCharacters": 1,
  "acceptedSpecialCharacters": "!@#$%^&*()-+"
}
```

## About this project

