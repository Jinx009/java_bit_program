package jinx.apigatewayDemo;
public class Demo {
	public static void main(String[] args) {
		String url = "https://service-5v2rb5oj-1255304211.ap-shanghai.apigateway.myqcloud.com/release" +
				"/api/v1/nation_air_by_city/city_realtime_list?city=马鞍山市";
		String secretId = "AKIDMwQttRjRZK4iuqTz4q67CqMn7vfNJynqw9p2";
		String secretKey = "d6P3428Ql15cu1RFLp07M33BoxJ111CyJvRzcFQ";
		SignAndSend signAndSendInstance = new SignAndSend();
		String result = SignAndSend.sendGet(url, secretId, secretKey);
        System.out.println(result);
    }
}