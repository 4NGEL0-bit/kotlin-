Advance Lab - Kotlin Advanced Concepts
Source PDF: LAB_Ad_concepts___.pdf. Refer to the provided lab for exercise text. fileciteturn0file0

Folder structure:
- kotlin_src/
  - extensions.kt         : Extension functions exercises (whisper, toHexString, hexToByteArray, toSHA256, isAlphanumeric, containsSafeCharsOnly)
  - data_classes.kt       : Data class exercises (Player, AclRule demo)
  - enums.kt              : Enum exercises (PlayerStatus, CommonProtocol, getProtocolFromPort)
  - sealed_api.kt         : Sealed classes exercise (ApiResponse + handleResponse)
  - scoped_functions.kt   : Scoped functions exercises (apply, let, run, with, also)
  - generics.kt           : Generics exercises (logValue, GoodVault, computeHash)
- README.md               : This file

How I implemented each assignment (by file):
1) extensions.kt
   - Implemented String.whisper(): lowercase + "..."
   - Implemented ByteArray.toHexString(): converts bytes to lowercase hex using %02x
   - Implemented String.hexToByteArray(): uses chunked(2) and converts pairs to bytes
   - Implemented String.toSHA256(): uses java.security.MessageDigest and reuses toHexString
   - Implemented String.isAlphanumeric(): uses isLetterOrDigit()
   - Implemented String.containsSafeCharsOnly(allowed: Set<Char>): uses all { it in allowed }
   - Demo main included to show example usage.

2) data_classes.kt
   - Player data class as requested (username immutable, score mutable default=0)
   - Demonstrated equals, copy, and hashCode comparisons.
   - AclRule data class used with a MutableSet to show uniqueness behavior.

3) enums.kt
   - PlayerStatus enum with PLAYING, PAUSED, STOPPED
   - CommonProtocol enum mapping port and isSecure. Implemented getProtocolFromPort.
   - Demo main demonstrates lookup behavior.

4) sealed_api.kt
   - ApiResponse sealed class with Success and nested Error sealed class
   - Error contains Unauthorized, NotFound, ServerError(errorCode, message)
   - handleResponse() uses exhaustive when to print messages; demo list iterated in main.

5) scoped_functions.kt
   - Implemented all requested scope-function exercises with runnable examples
   - apply used to configure Logger
   - let used for null-safe city lengths
   - run used for welcome message + formatted summary
   - with used to call three logger methods without repeating object name
   - also used to log list size as a side effect while assigning list

6) generics.kt
   - logValue generic function
   - GoodVault<T> generic class
   - ByteConvertible interface and implementations (User, FileContent)
   - computeHash<T : ByteConvertible> uses SHA-256 and prints hex digest

Notes:
- Each .kt file contains a main() function with basic demonstrations so you can compile/run them independently.
- The code is intentionally straightforward and idiomatic Kotlin to be easy to read and maintain.
- I followed the exercise instructions from the provided PDF exactly; see the cited PDF for original wording. fileciteturn0file0

How to use:
- Extract the zip and inspect kotlin_src/.
- To compile and run a file with kotlinc/kotlin (command-line), for example:
  kotlinc kotlin_src/extensions.kt -include-runtime -d extensions.jar
  java -jar extensions.jar
- Or run with Kotlin scripting support or your preferred IDE (IntelliJ IDEA).

If you want:
- I can split each exercise into its own package, add unit tests, or create a single multiplatform Gradle project with proper build files so it can be imported to IntelliJ and run easily.
- I can also add LICENSE and CONTRIBUTING.md for GitHub readiness.
