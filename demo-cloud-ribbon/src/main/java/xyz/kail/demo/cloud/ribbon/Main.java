package xyz.kail.demo.cloud.ribbon;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.http4.NFHttpClient;
import com.netflix.http4.NFHttpClientFactory;
import com.netflix.niws.client.http.HttpClientRequest;
import com.netflix.niws.client.http.RestClient;
import org.apache.commons.configuration.AbstractConfiguration;

import java.net.URI;
import java.util.List;
import java.util.Properties;

public class Main {
    static DynamicPropertyFactory property = DynamicPropertyFactory.getInstance();

    public static void main(String[] args) throws Exception {




        DynamicStringProperty stringProperty = property.getStringProperty("java.version", "1.7");

        System.out.println(stringProperty.get());

        URI uri = ClassLoader.getSystemResource("sample-client.properties").toURI();
        System.out.println(uri);

        AbstractConfiguration propertiesFile = ConfigurationManager.getConfigFromPropertiesFile(ClassLoader.getSystemResource("sample-client.properties").toURI().toURL());
        List<Object> list = propertiesFile.getList("sample-client.ribbon.listOfServers");
        System.out.println(list);

        ConfigurationManager.loadPropertiesFromResources("sample-client.properties");
        List<Object> list1 = ConfigurationManager.getConfigInstance().getList("sample-client.ribbon.listOfServers");
        System.out.println(list1);

        Properties properties = ConfigurationManager.getConfigInstance().getProperties("sample-client.ribbon.listOfServers");
        System.out.println(properties);


        NFHttpClient client = NFHttpClientFactory.getNamedNFHttpClient("sample-client");



//        System.out.println();
//        RestClient client = (RestClient) ClientFactory.getNamedClient("sample-client");  // 2
//        HttpClientRequest request = HttpClientRequest.newBuilder().setUri(new URI("/")).build(); // 3
//        for (int i = 0; i < 20; i++) {
//            HttpClientResponse response = client.executeWithLoadBalancer(request); // 4
//            System.out.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus());
//        }
//        ZoneAwareLoadBalancer lb = (ZoneAwareLoadBalancer) client.getLoadBalancer();
//        System.out.println(lb.getLoadBalancerStats());
//        ConfigurationManager.getConfigInstance().setProperty(
//                "sample-client.ribbon.listOfServers", "www.linkedin.com:80,www.google.com:80"); // 5
//        System.out.println("changing servers ...");
//        Thread.sleep(3000); // 6
//        for (int i = 0; i < 20; i++) {
//            HttpClientResponse response = client.executeWithLoadBalancer(request);
//            System.out.println("Status code for " + response.getRequestedURI() + "  : " + response.getStatus());
//            response.releaseResources();
//        }
//        System.out.println(lb.getLoadBalancerStats()); // 7
    }

}