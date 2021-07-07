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

To make testing easier by changing the environment variables, run docker-compose.

**At the root of the project, run:**

```shell
docker-compose up
```
> **Note:** Remember that the `$` character is used as a special in docker-compose, so if the 
> `ACCEPTED_SPECIAL_CHARACTERS` variable 
contains the `$` character, you will need to duplicate it. Ex: `!@#$$%?:^&*()-+}<>`. In this case, the system will only consider a `$`.

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

This project is a case study to exemplify the development of a password pattern validation service. The project follows good engineering and code quality practices, such as:

- Clean Code
- SOLID
- API Design
- Tests

### Application design

- The core of the application is in the service layer, where business rule operations such as getting password validation rules and performing validation are performed.

- The API layer is versioned following the v1, v2 pattern.

- Api Documentation by swagger.

- Unit and integration tests are performed in the build process.

- Part of the validation process uses regex. This decision was to have less code, more effectiveness and facilitate testing

- Leaving the parameters configurable was a decision in order to facilitate the configuration and not need to recompile the project.

- **TODO:** 
  - Maybe use the Step Builder pattern to assemble the validation regular expression.

## Code coverage

To verify code coverage, run:

```shell
mvn clean install
```

Open the generated HTML in the folder: target/site/jacoco/index.html
