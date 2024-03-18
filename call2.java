import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

HttpClient httpClient = HttpClientBuilder.create().build();


String postUrl = "https://customer-analytics-34146.my.salesforce-sites.com/services/apexrest/buyStocks";
HttpPost httpPost = new HttpPost(postUrl);

httpPost.setHeader("content-type", "application/json");
httpPost.setHeader("bfhl-auth", "2110990950");

String request = "{ 
 "company": "Bajaj Finserv Ltd" , 
 "currentPrice": 1578,
 "accountNumber": "BFHL0018650",
"githubRepoLink" : " https://github.com/ErNikhilTiwari/Bajaj_salesforce" }";

StringEntity entity = new StringEntity(request);
httpPost.setEntity(entity);


HttpResponse httpResponse = httpClient.execute(httpPost);

HttpEntity responseEntity = httpResponse.getEntity();
String response = EntityUtils.toString(responseEntity);

System.out.println(response);
