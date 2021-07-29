
How scalability is provided by NoSQL?     
Multi Document Transactions In NoSQL?    
Bigtable?

> **NoSQL High-Level System Classification**
1. Key-Value - Redis, Memcached, BerkeleyDB(keys are sorted so that range scans were supported), Riak
2. Document - Is a key-value store that restricts values to semi-structured formats such as JSON documents - MongoDB, CouchDB, CouchBase
3. Wide-Column - Cassandra, HBase, Accumulo
4. Graph - Titan, Neo4j

> **Terms**
4. CAP theorem - Consistency, Availability, Partition-Tolerance; AP, CP, CA
5. [PACELC](http://www.cs.umd.edu/~abadi/papers/abadi-pacelc.pdf)
6. Consistent Hashing - Records are not directly assigned to servers, but instead to logical partitions which are then distributed across all shard servers
7. RDBMSs are often CA systems run in single-server mode
8. BASE system gives up on consistency 
   1. Basically available indicates that the system does guarantee availability, in terms of the CAP theorem
   2. Soft state indicates that the state of the system may change over time, even without input. This is because of the eventual consistency model.
   3. Eventual consistency indicates that the system will become consistent over time, given that the system doesn't receive input during that time.
9. [Sharding]https://en.wikipedia.org/wiki/Shard_(database_architecture)
1. [Materialized view](https://en.wikipedia.org/wiki/Materialized_view)
   1. Materialized view is a database object that contains the results of a query
   2. As with other forms of precomputation, database users typically use materialized views for performance reasons, i.e. as a form of optimization.
   3. Whenever a query or an update addresses an ordinary view's virtual table, the DBMS converts these into queries or updates against the underlying base tables.
   4. A materialized view takes a different approach: the query result is cached as a concrete ("materialized") table (rather than a view as such) that may be updated from the original base tables from time to time. This enables much more efficient access, at the cost of extra storage and of some data being potentially out-of-date. Materialized views find use especially in data warehousing scenarios, where frequent queries of the actual base tables can be expensive.
   5. In a materialized view, indexes can be built on any column. In contrast, in a normal view, it's typically only possible to exploit indexes on columns that come directly from (or have a mapping to) indexed columns in the base tables; often this functionality is not offered at all.
2. 

> **Sharding Types**
1. range-sharding - BigTable, MongoDB
2. hash-sharding - Implemented using hashing, and will make scans feasible. Key-value stores like DynamoDB, Cassandra, Azure Tables
3. entity-group sharding - Single-partition transactions on co-located data

> **Replication**
1. When
    1. Eager(synchronous) - replication propagates incoming changes synchronously to all replicas before a commit can be returned to the client
    2. lazy (asynchronous) - replication applies changes only at the receiving replica and passes them on asynchronously
3. Where
   1. master-slave
   2. Update everywhere - Techiniques used are versioning, vector locks, gossiping and read repair(Dynamo), convergent or cumulative datatypes(Riak)
2. Out of all four combinations, generally eager master-slave replication is followed for strong consistency
3. MongoDB, HBase - lazy master-slave - CP systems
4. Dynamo, Cassandra - lazy update anywhere - AP systems
5. Megastore - eager update anywhere - Communication overhead generated by synchronization, and can cause distributed deadlocks which are expensive to detect
6. Many NoSQL systems leave the choice between latency and consistency to the client, i.e. for every request, the client decides whether to wait for a response from any replica to achieve minimal latency or for a certainly consistent response (by a majority of the replicas or the master) to prevent stale data.

> **Storage Management**
1. NoSQL - shared-nothing clusters
2. In-Memory databases
   1. n in-memory server nodes - HStore, VoltDB
   2. logging to durable storage - Redis
3. update-in-place access pattern is ideal for in-memory databases but used for persistent stroage also by RDBMS and most NoSQL(Mongo)

> **Query Processing**
1. Filter queries in their simplest form is filtered full-table scans. For hash-partitioned databases we will implement scatter-gather pattern
2. For range-partitioned systems, any conditions on the range attribute can be exploited to select partitions.
3. To prevent full table scans, we can have local secondary indexes or global secondary indexes
4. Global index has to be distributed over partitions, consistent secondary index maintenance would necessitate slow and potentially unavailable commit protocols. Therefore in practice, most systems only offer eventual consistency for these indexes (e.g. Megastore, Google AppEngine Datastore, DynamoDB) or do not support them at all (e.g. HBase, Azure Tables).
5. Query planning
6. In-database analytics 
7. Materialized views

> **System Case Studies**
1. Cassandra, Riak - Will allow all non-functional requirements at the cost of consistency(eventual). Supported for analytics
2. MongoDB, Hbase - Strong consistency and more functional requirements such as scan queries & filter queries
3. MongoDB, Hbase - Do not maintain read and write availability during partitions and tend to display higher read latencies

> **Misc**
1. Cassandra - Facebook
2. Bigtable built on top of Google File Storage - Google
3. Hadoop(distributed file system), HBase(distributed storage system) - Apache Software Foundation

> **SQL**
1. varchar(255) - Most used why? - Index length limitations
2. Performance degrade when use null values - NULL values are not indexed, so we will have full-table scan since index doesn't cover the values we need
3. Query Cache
   1. Not supported for partitioned tables
   2. Be cautious about sizing the query cache excessively large, which increases the overhead required to maintain the cache, possibly beyond the benefit of enabling it. Sizes in tens of megabytes are usually beneficial. Sizes in the hundreds of megabytes might not be.
   3. SQL_NO_CACHE option to prevent results from even entering the cache for SELECT statements that use frequently modified tables. 
   4. Cache will not be used for:
      1. Queries that are a subquery of an outer query
      2. Queries executed within the body of a stored function, trigger, or event
      3. user-defined functions (UDFs) or stored functions
      4. user variables or local stored program variables
      5. tables in the mysql, INFORMATION_SCHEMA, or performance_schema database
      6. does not use any tables
      7. generates warnings
      8. user has a column-level privilege for any of the involved tables
      9. uses TEMPORARY tables
     10. Query containing dynamic functions like current_date
   5. Before a query result is fetched from the query cache, MySQL checks whether the user has SELECT privilege for all databases and tables involved. If this is not the case, the cached result is not used
   6. If a table changes, all cached queries that use the table become invalid and are removed from the cache. This includes queries that use MERGE tables that map to the changed table. A table can be changed by many types of statements, such as INSERT, UPDATE, DELETE, TRUNCATE TABLE, ALTER TABLE, DROP TABLE, or DROP DATABASE.
   7. SELECT query on a view is cached
   
> **Graph Databases**
1. The true value of the graph approach becomes evident when one performs searches that are more than one level deep
2. 

> **Links Referred**
* https://www.sitepoint.com/sql-vs-nosql-differences/
* https://www.infoq.com/articles/Transition-RDBMS-NoSQL/
* https://www.lecloud.net/post/7994751381/scalability-for-dummies-part-2-database
* https://medium.baqend.com/nosql-databases-a-survey-and-decision-guidance-ea7823a822d#.wskogqenq
* https://stackoverflow.com/questions/3342497/explanation-of-base-terminology
* https://blog.grio.com/2015/11/sql-nosql-a-brief-history.html
* https://stackoverflow.com/questions/1217466/is-there-a-good-reason-i-see-varchar255-used-so-often-as-opposed-to-another-l
* https://stackoverflow.com/questions/1017239/how-do-null-values-affect-performance-in-a-database-search
* https://dev.mysql.com/doc/refman/5.7/en/query-cache.html
* https://www.paperplanes.de/2011/12/9/the-magic-of-consistent-hashing.html
* http://highscalability.com/blog/2009/8/6/an-unorthodox-approach-to-database-design-the-coming-of-the.html
* https://en.wikipedia.org/wiki/Shard_(database_architecture)
* https://en.wikipedia.org/wiki/Materialized_view
* https://docs.datastax.com/en/archived/cassandra/3.0/cassandra/architecture/archIntro.html
* https://github.com/donnemartin/system-design-primer#representational-state-transfer-rest
* https://en.wikipedia.org/wiki/Graph_database


* https://www.edureka.co/blog/hbase-architecture/

> **In-Progress**

> **Unvisited**
* https://stackoverflow.com/questions/4056093/what-are-the-disadvantages-of-using-a-key-value-table-over-nullable-columns-or
* https://github.com/donnemartin/system-design-primer#database
* https://en.wikipedia.org/wiki/Database_transaction
* https://www.slideshare.net/jboner/scalability-availability-stability-patterns/
* https://github.com/donnemartin/system-design-primer#disadvantages-replication
* https://en.wikipedia.org/wiki/Multi-master_replication
* https://github.com/donnemartin/system-design-primer#federation
* https://en.wikipedia.org/wiki/PostgreSQL
* https://github.com/donnemartin/system-design-primer#federation
* https://github.com/donnemartin/system-design-primer#sharding
* https://en.wikipedia.org/wiki/Denormalization
* http://httpd.apache.org/docs/2.2/programs/ab.html
* https://dev.mysql.com/doc/refman/5.7/en/slow-query-log.html
* https://en.wikipedia.org/wiki/B-tree
* https://github.com/donnemartin/system-design-primer#denormalization
* https://www.percona.com/blog/2016/10/12/mysql-5-7-performance-tuning-immediately-after-installation/
* http://aiddroid.com/10-tips-optimizing-mysql-queries-dont-suck/
* https://dev.mysql.com/doc/refman/5.7/en/slow-query-log.html
* https://github.com/donnemartin/system-design-primer#eventual-consistency
* https://github.com/donnemartin/system-design-primer#cap-theorem
* https://github.com/donnemartin/system-design-primer#sql-or-nosql
* https://en.wikipedia.org/wiki/Lexicographic_order
* https://en.wikipedia.org/wiki/Key%E2%80%93value_database
* http://qnimate.com/overview-of-redis-architecture/
* https://www.adayinthelifeof.nl/2011/02/06/memcache-internals/
* https://www.mongodb.com/mongodb-architecture
* https://blog.couchdb.org/2016/08/01/couchdb-2-0-architecture/
* http://www.read.seas.harvard.edu/~kohler/class/cs239-w08/decandia07dynamo.pdf
* https://en.wikipedia.org/wiki/Document-oriented_database
* https://www.elastic.co/blog/found-elasticsearch-from-the-bottom-up
* http://www.read.seas.harvard.edu/~kohler/class/cs239-w08/chang06bigtable.pdf
* https://neo4j.com/
* https://blog.twitter.com/engineering/en_us/a/2010/introducing-flockdb.html
* http://www.cs.umd.edu/~abadi/papers/abadi-pacelc.pdf
* https://www.youtube.com/watch?v=qI_g07C_Q5I
* http://horicky.blogspot.com/2009/11/nosql-patterns.html
* https://speakerdeck.com/divinetraube/nosql-data-stores-in-research-and-practice-icde-2016-tutorial-extended-version

> **Imp Links**
* https://medium.baqend.com/nosql-databases-a-survey-and-decision-guidance-ea7823a822d#.wskogqenq
* http://highscalability.com/blog/2009/8/6/an-unorthodox-approach-to-database-design-the-coming-of-the.html
* 
