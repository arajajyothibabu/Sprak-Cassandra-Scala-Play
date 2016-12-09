# Sprak-Cassandra-Scala-Play
Powered by Apache Spark, Cassandra, Scala and Play Framework

###### Inspired from [koeninger](https://github.com/koeninger/spark-cassandra-example)'s Repo.
 
#### Steps to use this Starter Kit:

1. Clone this repo
 ```$xslt
    git clone https://github.com/arajajyothibabu/Sprak-Cassandra-Scala-Play
```

2. Run [schema](https://github.com/arajajyothibabu/Sprak-Cassandra-Scala-Play/blob/master/schema.cql)
  ```$xslt
    cqlsh --file schema.sql
```

3. Run **cassandra** in Terminal
  ```$xslt
    > cqlsh
```

4. Run this project using 
    
    `activator run` or `sbt run`
 
5. This opens `localhost:9000` where you can run different methods in this example. Results will be in `console`.