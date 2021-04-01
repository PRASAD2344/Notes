
> **[Chaos Engineering](https://www.youtube.com/watch?v=1SD18klTuYk&t=1s)**
1. [Gremlin](https://www.gremlin.com/)
2. Chaos Mesh by PingCAP
3. Serverless?
4. Game Days - Failure Scenario replication & logging
5. Injecting Chaos
6. Game Day?

> **[Article on SQL offset slowness](https://use-the-index-luke.com/no-offset)**

> **[WebSockets](https://www.youtube.com/watch?v=8ARodQ4Wlf4)**
1. socket.io npm package

> **[Apache Pulsar](https://www.youtube.com/watch?v=lAVPIY1PRdo&t=81s)**
1. Flexible pub-sub system backed by a durable log storage
2. Mirror Maker - Apache Kafka for replication
3. In-built multi tenancy - A single cluster can support many tenants and use-cases
4. Streaming vs Queuing Model - Pulsar supports both?

> **Apache Pulsar Architecture**
1. Brokers(Serving Nodes) -> Bookies(Apache Book Keepers)(Storage Nodes)
2. Segment Centric Storage(BookKeeper "ledger")
3. Replication at BookKeeper level
4. As long as we have 3 bookies in a cluster, we can continue to operate(write)
5. Segment Centric vs Partition Centric

> **Apache Book Keeper**
1. Simple repeatable read consistency
2. I/O Isolation
3. Storing multiple segments per node


> **[HTTP 3](https://www.youtube.com/watch?v=pUxyukqoXR4)**
1. https -> TLS(Transport Layer Security) over TCP -> IP - TCP - TLS - HTTP
2. http 1.1 -> HTTP head-of-line-blocking -> Multiple Connections Per HOST
3. http 2 -> Single Connection Per Host with parallel streams -> TCP head-of-line-blocking
4. IETF QUIC - Built on top of UDP
5. HTTP 3 -> QUIC over HTTP -> IP - UDP - QUIC(TLS 1.3)

> **[JDK 15]()**
1. Text blocks

> **[JDK 14]()**
1. Switch Expressions

> **[JDK 11]()**
1. Local variable type inference i.e., `var` keyword
2. Convenience factory methods for collections
3. New methods on Optional

> **[JDK 16](https://www.youtube.com/watch?v=1hyWJTjxeGM&t=75s)**
1. Record
2. PatternMatchingForInstanceOf
3. New Methods On Stream
    1. In JDK 10 and above, we have Collectors.toUnmodifiableList
    2. Instead of `collect(Collectors.toUnmodifiableList())` we can directly use `toList()` on streams
4. Warnings for value-based classes
    1. From JDK 9, `Double b = new Double(9.0)` is depreciated
    2. `Double b = 9.0`
5. Local Types - As part of changes for Record; Local versions of anything like Enum, Interface, Record
6. Static methods or classes on inner classes
7. Create a repo for hands-on