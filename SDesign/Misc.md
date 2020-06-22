1. [Bitmap index](https://en.wikipedia.org/wiki/Bitmap_index)

>### **Row vs Column Oriented DB**
1. [Reference](https://www.youtube.com/watch?v=uMkVi4SDLbM&t=29s)
2. User Form vs Showing Response Time over a period of time


[Article on kafka](https://techbeacon.com/app-dev-testing/what-apache-kafka-why-it-so-popular-should-you-use-it)


1. 2pow10 = One Thousand = 1 Kb
2. 2pow20 = One Million = 1 Mb
3. 2pow30 = One Billion = 1 Gb
4. 2pow40 = One Trillion = 1 Tb

[Latency numbers every programmer should know](https://github.com/donnemartin/system-design-primer#latency-numbers-every-programmer-should-know)

>### **Google Big Query**
1. **TODO**
1. [Reference](https://www.youtube.com/watch?v=EnHQqQUCYu4)
1. [Reference](https://cloud.google.com/files/BigQueryTechnicalWP.pdf)
1. [Reference](https://storage.googleapis.com/pub-tools-public-publication-data/pdf/36632.pdf)
1. Data - MySQL(Relational) or NoSQL(JSON/XML)
2. Makes full table scan efficient, not to make indices to skip full table scan
3. Only touches the column that you have in query
4. Columnar Storage and Tree Architecture of Dremel
5. Work on only read-only data, dremel data will not support update opeartions
6. Columnar Storage - Instead of storing record as a whole, we will store columns in separate locations
    1. Used in warehouses
    2. Traffice minimization - as we will scan only columns not the entire records
    3. Higher compression ratio - 1:10 rather than 1:3 which we will observe in traditional row storage. As we can compress much better as it will have repeated values more frequentely
    4. No update operations as they are complex
7. Dremel is designed as an interactive data analysis tool for large datasets
8. MapReduce is designed as a programming framework to batch process large datasets, Hadoop is open-source implemenation of MapReduce
9. No joins as of 2012
1. BigQuery is designed to handle structured data using SQL
1. MapReduce is a better choice when you want to process unstructured data programmatically
2. Disk I/O throughput is the key to fullscan performance and we can improove it using In-memory database or flash storage, Columnar storage, and Parallel disk I/O
