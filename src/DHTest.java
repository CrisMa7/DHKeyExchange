import java.util.Map;
import org.apache.commons.codec.binary.Base64;
public class DHTest {
	//Alice 公私钥 对称密钥
	private static byte[] publicKeyAlice;
	private static byte[] privateKeyAlice;
	private static byte[] keyAlice;
	//Bob 公私钥 对称密钥
	private static byte[] publicKeyBob;
	private static byte[] privateKeyBob;
	private static byte[] keyBob;
	
	 /** 
     * 初始化密钥 
     * @throws Exception 
     */
	public static final void initKey() throws Exception{
		//生成Alice密钥对
		Map<String, Object> keyMapAlice = DHCoder.initKey();
		publicKeyAlice = DHCoder.getPublicKey(keyMapAlice);
		privateKeyAlice = DHCoder.getPrivateKey(keyMapAlice);
		System.out.println(x);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
