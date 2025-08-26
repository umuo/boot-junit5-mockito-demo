# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview
Spring Boot 3.5.5 demo project showcasing JUnit 5 and Mockito testing with async service implementation and custom thread pool configuration. This is a learning-focused project with comprehensive testing dependencies.

## Quick Commands

### Build & Run
```bash
# Build project
./mvnw clean package

# Run application
./mvnw spring-boot:run

# Build native executable
./mvnw native:compile -Pnative
```

### Testing
```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=AsyncServiceTest

# Run specific test method
./mvnw test -Dtest=AsyncServiceTest#testCustomThreadPoolCreation

# Run integration tests
./mvnw test -Dtest=BootJunit5MockitoDemoApplicationTests
```

### Development
```bash
# Clean and compile
./mvnw clean compile

# Run with hot reload (devtools not included, requires manual restart)
./mvnw spring-boot:run
```

## Project Structure
- **Main package**: `cn.lacknb.blog.bootjunit5mockitodemo`
- **Java version**: 21
- **Build tool**: Maven with wrapper
- **Testing**: JUnit 5 + Mockito + AssertJ + Hamcrest
- **Server port**: 9001

## Key Components

### Configuration
- `ThreadPoolConfig.java` - Custom thread pool bean (core: 5, max: 10, queue: 25) with CallerRunsPolicy
- `application.yml` - Minimal configuration with custom port 9001

### Services
- `AsyncService.java` - Demonstrates CompletableFuture.runAsync with custom thread pool
- Uses dependency injection with `@Qualifier("customThreadPool")`
- Implements both async execution and blocking wait patterns

### Controllers
- `HelloController.java` - REST API with three endpoints:
  - `GET /api/hello` - Simple greeting
  - `GET /api/hello/{name}` - Path variable greeting
  - `GET /api/hello/greet` - Query parameter greeting with defaults

### Testing
- `BootJunit5MockitoDemoApplicationTests.java` - Basic Spring context test
- `AsyncServiceTest.java` - Mockito-based unit test with `@ExtendWith(MockitoExtension.class)`

## Dependencies
- **Core**: spring-boot-starter-web, lombok
- **Testing**: Comprehensive testing stack including:
  - spring-boot-starter-test (JUnit 5 + Mockito)
  - junit-jupiter, junit-jupiter-params, junit-jupiter-engine
  - mockito-core, mockito-junit-jupiter
  - assertj-core, hamcrest
- **Native**: GraalVM native-maven-plugin configured
- **Commented out**: Spring AI OpenAI and Docker Compose dependencies (not needed for learning)

## Development Notes
- Project uses Chinese comments in some test files
- Async service demonstrates proper thread pool usage and exception handling
- Controller shows REST API patterns with different parameter types
- Tests use Mockito injection and JUnit 5 features
- Lombok configured for code generation