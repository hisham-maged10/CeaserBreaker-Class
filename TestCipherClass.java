/*
...@Author Hisham Maged
*/
public class TestCipherClass
{
	public static void main(String[] args)
	{
		quiz();
	}
	public static void simpleTest1()
	{
		CeaserCipher cc=new CeaserCipher(18);
		System.out.println("Encrypted Message: "+cc.getEncrypted());
		System.out.println("Decrypted using key given: "+cc.decrypt(cc.getEncrypted()));
		CeaserBreaker cb=new CeaserBreaker(cc.getEncrypted(),CeaserBreaker.Key.REGULAR);
		System.out.println("decrypted Automatically: "+cb.getDecrypted());
	}
	public static void simpleTest2()
	{
		CeaserCipher cc=new CeaserCipher(17,3);
		System.out.println("Encrypted Message: "+cc.getEncrypted());
		System.out.println("Decrypted using key given: "+cc.decrypt(cc.getEncrypted()));
		CeaserBreaker cb=new CeaserBreaker(cc.getEncrypted(),CeaserBreaker.Key.MULTIPLE);
		System.out.println("decrypted Automatically: "+cb.getDecrypted());					
	}
	public static void quiz()
	{
		/*CeaserCipher cc=new CeaserCipher("Can you imagine life WITHOUT the internet AND computers in your pocket?",15);
		System.out.println("Encrypted Message: "+cc.getEncrypted());*/
		/*CeaserCipher cc=new CeaserCipher("Can you imagine life WITHOUT the internet AND computers in your pocket?",21,8);
		System.out.println("Encrypted Message: "+cc.getEncrypted());*/
		/*CeaserBreaker cb=new CeaserBreaker("Hfs cpwewloj loks cd Hoto kyg Cyy.",14,24);
		System.out.println("decrypted Automatically: "+cb.getDecrypted());*/
		CeaserBreaker cb=new CeaserBreaker("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!",CeaserBreaker.Key.MULTIPLE);
		System.out.println("decrypted Automatically: "+cb.getDecrypted());
		/*CeaserBreaker cb=new CeaserBreaker(CeaserBreaker.Key.MULTIPLE);
		System.out.println("decrypted Automatically: "+cb.getDecrypted());*/
	}
}