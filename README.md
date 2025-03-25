# Mockito and JUnit Training Documentation

## 1. Mockito: Mocking Framework for Unit Testing
Mockito is a powerful Java library used to create **mock (fake) objects** for unit testing, enabling developers to isolate dependencies and test components in isolation.

### 1.1 Key Features
#### Dependency:
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>2.12.4</version>
    <scope>test</scope>
</dependency>
```

#### ✔ Mock Creation:
```java
List<String> mockedList = Mockito.mock(List.class);
```

#### ✔ Stubbing Methods:
Define mock behavior using `when().thenReturn()`:
```java
Mockito.when(mockedList.get(0)).thenReturn("Mockito");
```

#### ✔ Verification:
Ensure methods are called correctly:
```java
Mockito.verify(mockedList).get(0); // Verifies get(0) was called once
Mockito.verify(mockedList, Mockito.times(2)).size(); // Verifies size() called twice
```

#### ✔ Argument Matchers:
```java
Mockito.when(mockedList.get(Mockito.anyInt())).thenReturn("AnyIndex");
```

#### ✔ Exception Throwing:
```java
Mockito.when(mockedList.clear()).thenThrow(new RuntimeException());
```

---

## 2. Assertions in Unit Testing
Assertions validate expected outcomes in test cases.

### 2.1 Common Assertions
| Method | Description |
|---------|-------------|
| `assertNull(obj)` | Checks if object is `null` |
| `assertNotNull(obj)` | Checks if object is **not** `null` |
| `assertTrue(condition)` | Checks if condition is `true` |
| `assertFalse(condition)` | Checks if condition is `false` |
| `assertEquals(expected, actual)` | Checks if two objects are equal |
| `assertSame(expected, actual)` | Checks if two objects refer to the same instance |
| `assertNotSame(expected, actual)` | Checks if two objects refer to different instances |

### 2.2 Collection Assertions
Order matters:
```java
assertEquals(Arrays.asList("A", "B"), actualList); // Fails if order differs
```

Order-agnostic check:
```java
assertTrue(actualList.containsAll(expectedList));
```

---

## 3. JUnit 5 (JUnit Jupiter)
The latest version of JUnit introduces a modular architecture and new annotations.

### 3.1 Key Dependencies
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>
```

### 3.2 Annotations
| Annotation | Description |
|------------|-------------|
| `@BeforeAll` | Runs **once before all** test cases (static method) |
| `@AfterAll` | Runs **once after all** test cases (static method) |
| `@BeforeEach` | Runs **before each** test case |
| `@AfterEach` | Runs **after each** test case |
| `@Test` | Marks a method as a test case |
| `@DisplayName("Test Name")` | Provides a custom test name |
| `@Disabled` | Skips a test case |
| `@Timeout(5)` | Fails if test exceeds **5 seconds** |

### 3.3 Parameterized Tests
Run the same test with different inputs:
```java
@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
void testNumbers(int num) {
    assertTrue(num > 0);
}
```

### 3.4 Assumptions
Execute tests only if conditions are met:
```java
@Test
void testOnDevEnv() {
    Assumptions.assumeTrue("DEV".equals(System.getenv("ENV")));
    // Test runs only in DEV environment
}
```

---

## 4. JUnit 4 (Legacy Support)

### 4.1 Key Annotations
| Annotation | Description |
|------------|-------------|
| `@BeforeClass` | Runs once before all tests (static) |
| `@AfterClass` | Runs once after all tests (static) |
| `@Before` | Runs before each test |
| `@After` | Runs after each test |
| `@Test(timeout=1000)` | Fails if test exceeds 1 second |
| `@Test(expected=Exception.class)` | Expects an exception |

### 4.2 Assert Class (Legacy)
```java
Assert.assertEquals("Expected", actual);
Assert.assertNotEquals("Unexpected", actual);
Assert.assertArrayEquals(expectedArray, actualArray);
```

---

## 5. Unit Testing Best Practices
✅ **Isolate Tests:** Use mocks to avoid dependencies.  
✅ **Follow AAA Pattern:**  
- **Arrange** (Setup test data)  
- **Act** (Execute the method)  
- **Assert** (Verify the result)  
✅ **Use Descriptive Test Names:**  
```java
@Test
@DisplayName("Should return true when number is positive")
void testPositiveNumber() { ... }
```
✅ **Test Edge Cases:** Null inputs, empty collections, exceptions.  
✅ **Keep Tests Fast:** Avoid I/O operations, use mocking.

---

## 6. Example: Calculator Test
```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setup() {
        System.out.println("Running before all tests");
    }

    @Test
    @DisplayName("Test Addition")
    void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    @Timeout(2)
    void testTimeout() {
        // Fails if execution exceeds 2 seconds
    }
}
```

---

## Conclusion
- **Mockito** helps in mocking dependencies for isolated testing.  
- **JUnit 5** provides a modern, modular approach with new annotations.  
- **JUnit 4** is still used but lacks features like parameterized tests.  
- **Best Practices** ensure maintainable and reliable test cases.  

---

This documentation provides a comprehensive overview of using Mockito and JUnit for unit testing in Java projects. 🚀

