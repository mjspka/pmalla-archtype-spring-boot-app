package ${package};

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * This is the starting point for spring application. The spring application can
 * be run as Java application from eclipse. Or it can be run as mvn
 * spring-boot:run from command line.
 * 
 * @author Praveen Malla
 *
 */
@SpringBootApplication
public class ${app-name}Application extends SpringBootServletInitializer{
	private static Logger logger = LoggerFactory.getLogger(${app-name}Application.class);

	@Autowired
	Environment env;

	@Value("${proxy.host.name}")
	private String proxyHost;

	@Value("${proxy.port}")
	private int proxyPort;

	@Value("${proxy.user}")
	private String proxyUser;

	@Value("${proxy.passwd}")
	private String proxyPassword;

	@Value("${proxy.enabled}")
	private Boolean proxyEnabled;

	public static void main(String[] args) {
		SpringApplication.run(${app-name}Application.class, args);
	}

	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
		return converter;
	}

	@Bean
	public RestTemplate restTemplate() {
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();

		if (proxyEnabled) {
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(proxyHost, proxyPort),
					new UsernamePasswordCredentials(proxyUser, proxyPassword));

			HttpHost myProxy = new HttpHost(proxyHost, proxyPort);
			clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();
		}

		HttpClient httpClient = clientBuilder.build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(httpClient);

		factory.setReadTimeout(1 * 60 * 1000);
		factory.setConnectTimeout(15 * 1000);
		factory.setConnectionRequestTimeout(15 * 1000);

		return new RestTemplate(factory);
	}

}