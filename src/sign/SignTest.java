package sign;

public class SignTest {

	public static void main(String[] args) {
//		{"m":"00043cde0a3d","d":{},"s":"63db2c9705cc8b46a9732de817859f3f499fa6adeccf186259bc98b4a930899a"}
//		String signStr = "mac=00043cde0a3d";
//		String signStr = "avlb=0&be=0&bv=0.00&cid=0&cnct=0&fc=0&fv=&hbi=0&hv=&mc=1234567812345678&md=0&pid=0&pm=525400c76ecf&rm=525400c76ecf&tp=0&x=0&y=0&z=0&mac=525400c76ecf";
//		String signStr = "avlb=0&be=0&bv=0.00&cid=0&cnct=0&fc=0    &hbi=0    &mc=1234567812345678&md=0&pid=0&pm=525400c76ecf&rm=525400c76ecf&tp=0&x=0&y=0&z=0&mac=525400c76ecf";
		String signStr = "avlb=0&be=0&bv=0.00&cid=0&cnct=0&fc=0	   &hbi=0    &mc=1234567812345678&md=0&pid=0&pm=525400c76ecf&rm=525400c76ecf&tp=0&x=0&y=0&z=0&mac=525400c76ecf";
		String ret = SignUtils.sign(signStr);
		 System.out.println(ret);
		 try {
			ret = StringUtils.toHexString(CipherUtil.encrypt("qiO7eqlUrG3yrLiX".getBytes("utf-8"), ret.getBytes("utf-8")));
			System.out.println(ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(decrypt("b7196dd1a612730e238bb75595c5da30a928ff884a7c37f3efd18818bec1891c","qiO7eqlUrG3yrLiX"));
	}

	public static String decrypt(String body, String appSecret) {
		if (StringUtils.isEmpty(appSecret)) {
			return null;
		}

		String md5Sign = null;

		try {
			byte[] result = StringUtils.hexStr2ByteArr(body);
			md5Sign = new String(CipherUtil.decrypt(appSecret.getBytes("utf-8"), result),"utf-8");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return md5Sign;
	}
	
}
