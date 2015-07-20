/**
 * 
 */
package cn.springmvc.test;

import org.junit.Test;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * @author hzzhangmin2015
 *
 */
public class JsonTest {
	
	@Test
	public void getJson() {
		String content = HttpRequest.get("http://localhost:8080/springmvc/api/user")
                .accept("application/json") //Sets request header
                .body();
		System.out.println(content);
	}

}
