// Import the necessary libraries
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

// Create an instance of HttpClient
HttpClient httpClient = HttpClientBuilder.create().build();

// Create an instance of HttpPost with the desired URL
String postUrl = "https://customer-analytics-34146.my.salesforce-sites.com/services/apexrest/buyStocks";
HttpPost httpPost = new HttpPost(postUrl);

// Add headers to the request
httpPost.setHeader("content-type", "application/json");
httpPost.setHeader("bfhl-auth", "2110990950");

// Set the request body
String request = "{ 
 "company": "Bajaj Finserv Ltd" , 
 "currentPrice": 1578,
 "accountNumber": "BFHL0018650",
"githubRepoLink" : " https://github.com/ErNikhilTiwari/Bajaj_salesforce" }";

StringEntity entity = new StringEntity(request);
httpPost.setEntity(entity);

// Execute the request and obtain the response
HttpResponse httpResponse = httpClient.execute(httpPost);

// Extract the response's content
HttpEntity responseEntity = httpResponse.getEntity();
String response = EntityUtils.toString(responseEntity);

// Print the response
System.out.println(response);