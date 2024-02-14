///*
//package EmbeddedCassandra;
//
//import com.datastax.driver.core.Cluster;
//import com.datastax.driver.core.ResultSet;
//import com.github.nosan.embedded.cassandra.Cassandra;
//import com.github.nosan.embedded.cassandra.CassandraBuilder;
//import com.github.nosan.embedded.cassandra.Settings;
//import com.github.nosan.embedded.cassandra.commons.ClassPathResource;
//import com.github.nosan.embedded.cassandra.commons.FileSystemResource;
//import com.github.nosan.embedded.cassandra.cql.CqlDataSet;
//import com.github.nosan.embedded.cassandra.cql.CqlScript;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.thrift.transport.TTransportException;
//import org.cassandraunit.CQLDataLoader;
//import org.cassandraunit.dataset.cql.FileCQLDataSet;
//import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
//import com.datastax.driver.core.Session;
//import org.eclipse.jdt.internal.compiler.batch.FileSystem;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.InetSocketAddress;
//import java.nio.file.Paths;
//
//@Slf4j
//public class Application {
//    public static void main(String[] args) throws InterruptedException, IOException, TTransportException {
////        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
////        Session session = EmbeddedCassandraServerHelper.getSession();
////
//////        Cluster cluster = new Cluster.Builder().addContactPoints(InetAddress.getLocalHost()).withPort(9042).build();
//////        Session session = cluster.connect();
////        CQLDataLoader dataLoader = new CQLDataLoader(session);
////        dataLoader.load(new FileCQLDataSet("src/main/java/EmbeddedCassandra/simple.cql", "booking_orch"));
////        session.execute("use booking_orch;");
//////        ResultSet resultSet = session.execute("select * from configs allow filtering;");
//////        resultSet.forEach(result -> log.info(result.toString()));
//////        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
//
//        Cassandra cassandra = new CassandraBuilder().build();
//        cassandra.start();
//        try {
//            Settings settings = cassandra.getSettings();
//            Cluster cluster = new Cluster.Builder().addContactPoints(settings.getAddress()).withPort(settings.getPort()).build();
//            Session session = cluster.connect();
//            CqlScript.ofResource(new FileSystemResource(Paths.get("/Users/satyam.poddar/Desktop/potato/potato-punch/src/main/java/EmbeddedCassandra/simple.cql"))).forEachStatement(session::execute);
//            //CqlScript.ofClassPath(new FileSystem.Classpath("/Users/satyam.poddar/Desktop/potato/potato-punch/src/main/java/EmbeddedCassandra/simple.cql"))
//            //CqlScript.ofClassPath("/Users/satyam.poddar/Desktop/potato/potato-punch/src/main/java/EmbeddedCassandra/simple.cql").forEachStatement(session::execute);
//            //dataLoader.load(new FileCQLDataSet("src/main/java/EmbeddedCassandra/simple.cql", "booking_orch"));
//            log.info("###MYLOG" + session.execute("describe tables").toString());
//            log.info("###Exiting CQL###");
//        }
//        finally {
//            cassandra.stop();
//        }
//    }
//}
//*/
