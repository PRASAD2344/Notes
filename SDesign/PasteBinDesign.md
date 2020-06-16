[Reference](https://github.com/donnemartin/system-design-primer/blob/master/solutions/system_design/pastebin/README.md)

![Main Reference](https://camo.githubusercontent.com/4aee2d26ebedc20e7fa07a2c30780e332fa29f2c/687474703a2f2f692e696d6775722e636f6d2f346564584730542e706e67)

```
shortlink char(7) NOT NULL
expiration_length_in_minutes int NOT NULL
created_at datetime NOT NULL
paste_path varchar(255) NOT NULL
PRIMARY KEY(shortlink)
```

```java
url = base_encode(md5(ip_address+timestamp))[:URL_LENGTH]
```
1. Why base62 not base64, because base64 provides issues for urls because of the additional + and / characters. [Reference](https://stackoverflow.com/questions/742013/how-do-i-create-a-url-shortener)
2. What is base64 anyway?
3. The MD5 message-digest algorithm is a widely used hash function producing a 128-bit hash value
4. What is MD5?
5. What is X.509?
