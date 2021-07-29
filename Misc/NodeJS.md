[Referece](https://nodejsera.com/index.html)
1. File I/O
    1. NodeJS provides wrapper around standard POSIX functions
    2. `fs` module
    3. We have methods for synchronous & asynchronous file operations. 
        1. readFile vs readFileSync
        2. writeFile vs writeFileSync
        3. appendFile vs appendFileSync
        4. rename vs renameSync
        5. unlink vs unlinkSync
2. Regular expressions
    1. ```let regex = /ab*/;```
    2. ```let regex = new RegExp('ab*')```
    3. `gim` modifiers
    4. ```str.match(regex);```
3. Console
    1. Console class
        1. log
        2. clear
        3. count and countReset ```console.count('default');console.count('default'); Output:: default: 1 & default: 2```
        5. error
        6. time and timeEnd ```console.time('division); console.timeEnd('division); Output:: division: 2.895ms```
        7. warn
    2. Global console instance : This method is configured to write on process.stderr , process.stdout() and it can be used without exclusively calling the module require('console') .
4. `Error` object
5. Assert module
6. OS module
    1. os.cpus()
    2. os.arch()
    3. os.endianness()
    4. os.freemem()
    5. os.hostname()
    6. os.homedir() 
    7. os.platform() 
    8. os.release() 
    9. os.tmpdir() 
    1. os.totalmem() 
    2. os.uptime() 
    3. os.type()
7. [Cluster module](https://nodejsera.com/nodejs-tutorial-day25-clusters.html)
    ```javascript
    //Name of the file : cluster.js
    var cluster = require('cluster');
    var http = require('http');
    var numofCPUs = require('os').cpus().length;
    if (cluster.isMaster) {
        console.log(`Master with Process ID : ${process.pid} is running`);
        // Fork workers.
        for (var i = 0; i < numofCPUs; i++) {
            cluster.fork();
        }
        cluster.on('exit', (worker, code, signal) => {
            console.log(`worker with Process ID : ${worker.process.pid} died`);
        });
    } else {
        // Workers sharing an HTTP server
        http.createServer((req, res) => {
            res.writeHead(200);
            res.end('An example of clusters\n');
        }).listen(3000);
        console.log(`Worker with Process ID : ${process.pid} started`);
    }
    ```
8. [Child Processes/child_process module](https://nodejsera.com/nodejs-tutorial-day24-child-processes.html)
9. Timers
    1. setImmediate(callback, args*) : This method will execute the code after the end of current cycle of the event loop. This method will be executed after any I/O operations which are in the current event loop but before timers scheduled for the next cycle of event loop.
1. [Crypto module](https://nodejsera.com/nodejs-tutorial-day9-crypto-module.html)
2. [Express](https://nodejsera.com/nodejs-tutorial-day11-express-framework.html)
3. Zlib module
4. Query String module
5. String decoder module
6. Buffer
7. Stream
