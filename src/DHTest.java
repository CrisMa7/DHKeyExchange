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
		System.out.println("Alice public key:\n" + Base64.encodeBase64String(publicKeyAlice));
		System.out.println("Alice private key:\n" + Base64.encodeBase64String(privateKeyAlice));
		//生成Bob密钥对
		Map<String, Object> keyMapBob = DHCoder.initKey();
		publicKeyBob = DHCoder.getPublicKey(keyMapBob);
		privateKeyBob = DHCoder.getPrivateKey(keyMapBob);
		System.out.println("Bob public key:\n" + Base64.encodeBase64String(publicKeyBob));
		System.out.println("Bob private key:\n" + Base64.encodeBase64String(privateKeyBob));
		//DH密钥交换生成AES密钥
		keyAlice = DHCoder.getSecretKey(publicKeyBob, privateKeyAlice);
		keyBob = DHCoder.getSecretKey(publicKeyAlice, privateKeyBob);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		initKey();
		System.out.println("--------------------------------------------------------------");
		System.out.println("Alice向Bob发送密文");
		String message1 = "天王盖地虎";
		System.out.println("明文： " + message1);
		byte[] ctext1 = DHCoder.encrypt(message1.getBytes(), keyAlice);
		System.out.println("密文: " + Base64.encodeBase64String(ctext1));
		String decode1 = new String(DHCoder.decrypt(ctext1, keyBob));
		System.out.println("Bob解密出来的明文: "+ decode1);
		System.out.println("--------------------------------------------------------------");
		System.out.println("Bob向Alice发送密文");
		String message2 = "小鸡炖蘑菇";
		System.out.println("明文： " + message2);
		byte[] ctext2 = DHCoder.encrypt(message2.getBytes(), keyBob);
		System.out.println("密文: " + Base64.encodeBase64String(ctext2));
		String decode2 = new String(DHCoder.decrypt(ctext2, keyAlice));
		System.out.println("Alice解密出来的明文: "+ decode2);
	}

}
