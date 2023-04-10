# failure repro
```
gradle build

java -jar build/libs/script-module-not-found-1.0-standalone.jar 5
```

## Example failure output
```
Using JDK home inferred from java.home: /usr/lib/jvm/java-17-openjdk
Using JVM IR backend
Using JVM IR backend
Loading modules: [java.se, jdk.accessibility, jdk.attach, jdk.compiler, jdk.dynalink, jdk.httpserver, jdk.incubator.foreign, jdk.incubator.vector, jdk.jartool, jdk.javadoc, jdk.jconsole, jdk.jdi, jdk.jfr, jdk.jshell, jdk.jsobject, jdk.management, jdk.management.jfr, jdk.net, jdk.nio.mapmode, jdk.sctp, jdk.security.auth, jdk.security.jgss, jdk.unsupported, jdk.unsupported.desktop, jdk.xml.dom, kotlin.stdlib, kotlin.script.runtime, kotlin.reflect, java.base, java.compiler, java.datatransfer, java.desktop, java.xml, java.instrument, java.logging, java.management, java.management.rmi, java.rmi, java.naming, java.net.http, java.prefs, java.scripting, java.security.jgss, java.security.sasl, java.sql, java.transaction.xa, java.sql.rowset, java.xml.crypto, jdk.internal.jvmstat, jdk.management.agent, jdk.jdwp.agent, jdk.internal.ed, jdk.internal.le, jdk.internal.opt]
Module kotlin.stdlib cannot be found in the module graph
Module kotlin.script.runtime cannot be found in the module graph
Module kotlin.reflect cannot be found in the module graph
Ended in failure
```

# success repro
1. Use intellij to run main in main.kt
2. add 5 to the program arguments in the run configuration, this serves as the script
3. run it

## Example success output
```
Using JDK home inferred from java.home: /usr/lib/jvm/java-17-openjdk
Using JVM IR backend
Using JVM IR backend
Loading modules: [java.se, jdk.accessibility, jdk.attach, jdk.compiler, jdk.dynalink, jdk.httpserver, jdk.incubator.foreign, jdk.incubator.vector, jdk.jartool, jdk.javadoc, jdk.jconsole, jdk.jdi, jdk.jfr, jdk.jshell, jdk.jsobject, jdk.management, jdk.management.jfr, jdk.net, jdk.nio.mapmode, jdk.sctp, jdk.security.auth, jdk.security.jgss, jdk.unsupported, jdk.unsupported.desktop, jdk.xml.dom, kotlin.stdlib, kotlin.script.runtime, kotlin.reflect, java.base, java.compiler, java.datatransfer, java.desktop, java.xml, java.instrument, java.logging, java.management, java.management.rmi, java.rmi, java.naming, java.net.http, java.prefs, java.scripting, java.security.jgss, java.security.sasl, java.sql, java.transaction.xa, java.sql.rowset, java.xml.crypto, jdk.internal.jvmstat, jdk.management.agent, jdk.jdwp.agent, jdk.internal.ed, jdk.internal.le, jdk.internal.opt]
Loading modules: [java.se, jdk.accessibility, jdk.attach, jdk.compiler, jdk.dynalink, jdk.httpserver, jdk.incubator.foreign, jdk.incubator.vector, jdk.jartool, jdk.javadoc, jdk.jconsole, jdk.jdi, jdk.jfr, jdk.jshell, jdk.jsobject, jdk.management, jdk.management.jfr, jdk.net, jdk.nio.mapmode, jdk.sctp, jdk.security.auth, jdk.security.jgss, jdk.unsupported, jdk.unsupported.desktop, jdk.xml.dom, kotlin.stdlib, kotlin.script.runtime, kotlin.reflect, java.base, java.compiler, java.datatransfer, java.desktop, java.xml, java.instrument, java.logging, java.management, java.management.rmi, java.rmi, java.naming, java.net.http, java.prefs, java.scripting, java.security.jgss, java.security.sasl, java.sql, java.transaction.xa, java.sql.rowset, java.xml.crypto, jdk.internal.jvmstat, jdk.management.agent, jdk.jdwp.agent, jdk.internal.ed, jdk.internal.le, jdk.internal.opt]
Ended in success: $$result: kotlin.Int = 5
```